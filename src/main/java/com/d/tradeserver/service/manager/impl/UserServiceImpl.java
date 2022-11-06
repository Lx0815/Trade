package com.d.tradeserver.service.manager.impl;

import com.d.tradeserver.common.constant.Constants;
import com.d.tradeserver.mapper.manager.MajorMapper;
import com.d.tradeserver.mapper.manager.SchoolMapper;
import com.d.tradeserver.mapper.manager.UserDetailMapper;
import com.d.tradeserver.mapper.manager.UserMapper;
import com.d.tradeserver.pojo.User;
import com.d.tradeserver.pojo.UserDetail;
import com.d.tradeserver.service.common.exception.ServiceException;
import com.d.tradeserver.service.manager.UserService;
import com.d.tradeserver.web.common.response.ResponseCode;
import com.d.tradeserver.web.manager.dto.UserFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: Ding
 * @date: 2022/10/27 10:38
 * @description:
 * @modify:
 */


@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;
    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    private UserDetailMapper userDetailMapper;
    @Autowired
    public void setUserDetailMapper(UserDetailMapper userDetailMapper) {
        this.userDetailMapper = userDetailMapper;
    }

    private SchoolMapper schoolMapper;
    @Autowired
    public void setSchoolMapper(SchoolMapper schoolMapper) {
        this.schoolMapper = schoolMapper;
    }

    private MajorMapper majorMapper;
    @Autowired
    public void setMajorMapper(MajorMapper majorMapper) {
        this.majorMapper = majorMapper;
    }

    @Override
    public List<User> queryAllUser() {
        return userMapper.selectAll();
    }


    @Override
    public UserDetail queryDetailByUserId(Integer userId) {
        UserDetail userDetail = userDetailMapper.selectByUserId(userId);
        if (ObjectUtils.isEmpty(userDetail)) {
            throw new ServiceException(ResponseCode.NO_DATA, String.format("不存在 id 为 %s 的 user", userId));
        }
        return userDetail;
    }

    @Override
    public Boolean addNewUserAndUserDetail(User user, UserDetail userDetail) {
        // 初始化数据
        user.setCreateDateTime(LocalDateTime.now());
        user.setUpdateDateTime(LocalDateTime.now());
        userDetail.setCreateDateTime(LocalDateTime.now());
        userDetail.setUpdateDateTime(LocalDateTime.now());
        if (StringUtils.isBlank(user.getHeadshot())) {
            user.setHeadshot(Constants.HEADSHOT_DEFAULT_PATH);
        }
        if (StringUtils.isBlank(userDetail.getPassword())) {
            userDetail.setPassword(Constants.DEFAULT_PASSWORD);
        }

        Integer rows1 = userMapper.insertOne(user);
        userDetail.setUser(user);
        Integer rows2 = userDetailMapper.insertOne(userDetail);
        Integer rows3 = userMapper.updateUserDetailById(user.getId(), userDetail.getId());
        if (ObjectUtils.nullSafeEquals(1, rows1)
                && ObjectUtils.nullSafeEquals(rows1, rows2)
                && ObjectUtils.nullSafeEquals(rows2, rows3)) {

            return Boolean.TRUE;
        } else {
            throw new ServiceException(ResponseCode.ADD_EXCEPTION, String.format("新增用户失败，插入 user 表影响了 %d 行， " +
                    "插入 userDetail 表影响了 %d 行，更新 user 表的 user_detail_id 字段影响了 %d 行", rows1, rows2, rows3));
        }
    }

    @Override
    public Boolean removeUserById(Integer id) {
        Integer rows1 = userMapper.notRealDeleteById(id);
        Integer userDetailId = userMapper.selectUserDetailIdById(id);
        Integer rows2 = userDetailMapper.notRealDeleteById(userDetailId);
        if (ObjectUtils.nullSafeEquals(1, rows1) && ObjectUtils.nullSafeEquals(rows1, rows2)) {
            return Boolean.TRUE;
        } else {
            throw new ServiceException(ResponseCode.DELETE_EXCEPTION,
                    String.format("删除操作失败，删除 user 表影响了 %d 行，删除 userDetail 表影响了 %d 行",
                            rows1, rows2));
        }
    }

    @Override
    public Boolean removeUserByIds(Integer[] ids) {
        Integer rows1 = userMapper.notRealDeleteByIds(ids);
        List<Integer> userDetailIds = userMapper.selectUserDetailIdByIds(ids);
        Integer rows2 = userDetailMapper.notRealDeleteByIds(userDetailIds.toArray(new Integer[0]));
        if (ObjectUtils.nullSafeEquals(rows1, rows2)) {
            return Boolean.TRUE;
        } else {
            throw new ServiceException(ResponseCode.DELETE_EXCEPTION,
                    String.format("删除失败。本次操作将删除 %d 行 user 数据，%d 行 userDetail 数据。",
                            rows1, rows2));
        }
    }

    @Override
    public Boolean updateUserById(User newUser) {
        Integer userCount = null;
        Integer userDetailCount = null;
        if (newUser.getId() < 0 || newUser.getUserDetail().getId() < 0
                || (userCount = userMapper.selectCountById(newUser.getId())) <= 0
                || (userDetailCount = userDetailMapper.selectCountById(newUser.getUserDetail().getId())) <= 0) {
            throw new ServiceException(ResponseCode.NO_DATA,
                    String.format("数据不存在，user.id = %s, user.userDetail.id = %s, userCount = %d, userDetailCount = %d",
                            newUser.getId(), newUser.getUserDetail().getId(), userCount, userDetailCount));
        }
        if (newUser.getUserDetail().getSchool().getId() < 0) {
            newUser.getUserDetail().setSchool(null);
        }
        if (newUser.getUserDetail().getMajor().getId() < 0) {
            newUser.getUserDetail().setMajor(null);
        }
        newUser.setUpdateDateTime(LocalDateTime.now());
        newUser.getUserDetail().setUpdateDateTime(LocalDateTime.now());
        Integer rows1 = userMapper.updateById(newUser);
        Integer rows2 = userDetailMapper.updateById(newUser.getUserDetail());
        if (ObjectUtils.nullSafeEquals(1, rows1) && ObjectUtils.nullSafeEquals(rows1, rows2)) {
            return Boolean.TRUE;
        } else {
            throw new ServiceException(ResponseCode.UPDATE_EXCEPTION,
                    String.format("更新失败。本次操作更新了 %d 行 user， %d 行 userDetail", rows1, rows2));
        }
    }


    @Override
    public List<User> queryUserByUserFilter(UserFilter userFilter) {
        List<User> userList = userMapper.selectByMap(userFilter.getUserMap());
        List<Integer> schoolIdList = schoolMapper.selectIdsByName(userFilter.getSchoolName());
        List<Integer> majorIdList = majorMapper.selectIdsByName(userFilter.getMajorName());
        userFilter.setSchoolIdList(schoolIdList);
        userFilter.setMajorIdList(majorIdList);
        Map<String, Object> userDetailMap = userFilter.getUserDetailMap();
        List<Integer> userIdList = userDetailMapper.selectUserIdsByMap(userDetailMap);
        return userList.stream()
                .filter(user -> userIdList.contains(user.getId()))
                .collect(Collectors.toList());
    }
}
