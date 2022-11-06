package com.d.tradeserver.manager.service;

import com.d.tradeserver.common.utils.MyPair;
import com.d.tradeserver.manager.pojo.ManageUser;

/**
 * @author: Ding
 * @date: 2022/7/18 14:36
 * @description:
 * @modify:
 */


public interface ManagerUserService {

    MyPair<Boolean, Object> register(ManageUser manageUser) throws Exception;

    MyPair<Boolean, Object> login(ManageUser manageUser) throws Exception;

    MyPair<Boolean, Object> checkUsernameIsExist(String username);
}
