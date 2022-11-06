package com.d.tradeserver.service.manager.impl;

import com.d.tradeserver.common.constant.Constants;
import com.d.tradeserver.common.utils.MyPair;
import com.d.tradeserver.common.utils.MyPairUtils;
import com.d.tradeserver.mapper.manager.ManageUserMapper;
import com.d.tradeserver.pojo.ManageUser;
import com.d.tradeserver.service.manager.ManagerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

/**
 * @author: Ding
 * @date: 2022/10/16 18:04
 * @description:
 * @modify:
 */


@Service
@Transactional
public class ManagerUserServiceImpl implements ManagerUserService {

    private ManageUserMapper manageUserMapper;

    @Autowired
    public void setManageUserMapper(ManageUserMapper manageUserMapper) {
        this.manageUserMapper = manageUserMapper;
    }

    @Override
    public MyPair<Boolean, Object> login(ManageUser manageUser) throws Exception {
        ManageUser user = manageUserMapper.selectByPropertyEquals(manageUser);
        if (ObjectUtils.isEmpty(user)) {
            return MyPairUtils.createMyPair(Boolean.FALSE, "账号或密码错误");
        } else {
            return MyPairUtils.createMyPair(Boolean.TRUE, user);
        }
    }

    @Override
    public MyPair<Boolean, Object> checkUsernameIsExist(String username) {
        ManageUser user = new ManageUser();
        user.setUsername(username);
        if (ObjectUtils.nullSafeEquals(1, manageUserMapper.selectCountByPropertyEquals(user))) {
            return MyPairUtils.createMyPair(Boolean.TRUE, null);
        } else {
            return MyPairUtils.createMyPair(Boolean.FALSE, Constants.DATA_EXISTED);
        }
    }
}
