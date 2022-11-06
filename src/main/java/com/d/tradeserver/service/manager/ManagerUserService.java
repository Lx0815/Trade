package com.d.tradeserver.service.manager;

import com.d.tradeserver.common.utils.MyPair;
import com.d.tradeserver.pojo.ManageUser;

/**
 * @author: Ding
 * @date: 2022/7/18 14:36
 * @description:
 * @modify:
 */


public interface ManagerUserService {

    MyPair<Boolean, Object> login(ManageUser manageUser) throws Exception;

    MyPair<Boolean, Object> checkUsernameIsExist(String username);
}
