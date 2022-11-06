package com.d.tradeserver.manager.service.impl;

import com.d.tradeserver.common.pool.impl.MyPairPool;
import com.d.tradeserver.common.utils.MyPair;
import com.d.tradeserver.manager.mapper.ManageUserMapper;
import com.d.tradeserver.manager.pojo.ManageUser;
import com.d.tradeserver.manager.service.ManagerUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;

/**
 * @author: Ding
 * @date: 2022/10/16 18:04
 * @description:
 * @modify:
 */


@Service
public class ManagerUserServiceImpl implements ManagerUserService  {

    private ManageUserMapper manageUserMapper;
    @Autowired
    public void setManageUserMapper(ManageUserMapper manageUserMapper) {
        this.manageUserMapper = manageUserMapper;
    }

    private MyPairPool<Boolean, Object> pairPool;
    @Autowired
    public void setPairPool(MyPairPool<Boolean, Object> pairPool) {
        this.pairPool = pairPool;
    }

    @Override
    public MyPair<Boolean, Object> register(ManageUser manageUser) throws Exception {
        if (ObjectUtils.isEmpty(manageUser.getSessionAge())) manageUser.setSessionAge(30);
        manageUser.setCreateDateTime(LocalDateTime.now());
        manageUser.setUpdateDateTime(LocalDateTime.now());
        if (ObjectUtils.nullSafeEquals(manageUserMapper.insertOne(manageUser), 1)) {
            return pairPool.borrowObject().setKeyValue(Boolean.TRUE, manageUser);
        } else {
            return pairPool.borrowObject().setKeyValue(Boolean.FALSE, "注册失败");
        }
    }

    @Override
    public MyPair<Boolean, Object> login(ManageUser manageUser) throws Exception {
        ManageUser user = manageUserMapper.selectByPropertyEquals(manageUser);
        if (ObjectUtils.isEmpty(user)) {
            return pairPool.borrowObject().setKeyValue(Boolean.FALSE, "登录失败");
        } else {
            return pairPool.borrowObject().setKeyValue(Boolean.TRUE, user);
        }
    }

    @Override
    public MyPair<Boolean, Object> checkUsernameIsExist(String username) {
        ManageUser user = new ManageUser();
        user.setUsername(username);
        if (ObjectUtils.nullSafeEquals(1, manageUserMapper.selectCountByPropertyEquals(user))) {
            return pairPool.borrowObject().setKey(Boolean.TRUE);
        } else {
            return pairPool.borrowObject().setKey(Boolean.FALSE);
        }
    }
}
