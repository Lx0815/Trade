package com.d.tradeserver.service.manager;

import com.d.tradeserver.pojo.User;
import com.d.tradeserver.pojo.UserDetail;
import com.d.tradeserver.web.manager.dto.UserFilter;

import java.util.List;

/**
 * @author: Ding
 * @date: 2022/7/18 14:36
 * @description:
 * @modify:
 */


public interface UserService {

    List<User> queryAllUser();

    UserDetail queryDetailByUserId(Integer id);

    Boolean addNewUserAndUserDetail(User user, UserDetail userDetail);

    Boolean removeUserById(Integer id);

    Boolean removeUserByIds(Integer[] ids);

    Boolean updateUserById(User user);

    List<User> queryUserByUserFilter(UserFilter userFilter);
}
