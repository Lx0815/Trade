package com.d.tradeserver.web.manager.controller;

import com.d.tradeserver.common.constant.Constants;
import com.d.tradeserver.common.utils.ResponseUtils;
import com.d.tradeserver.pojo.User;
import com.d.tradeserver.pojo.UserDetail;
import com.d.tradeserver.service.manager.UserService;
import com.d.tradeserver.web.common.annotation.MultiRequestBody;
import com.d.tradeserver.web.common.annotation.RequestParamObject;
import com.d.tradeserver.web.manager.dto.UserFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.d.tradeserver.web.common.response.ResponseCode.SUCCESS;

/**
 * @author: Ding
 * @date: 2022/10/27 10:22
 * @description:
 * @modify:
 */

@RestController
@RequestMapping("/manager")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public Object fetchAllUser() {
        List<User> userList = userService.queryAllUser();
        return ResponseUtils.createResponse(SUCCESS, userList, Constants.SELECT_SUCCESS);
    }

    @GetMapping("/user/detail/{userId}")
    public Object fetchDetailByUserId(@PathVariable Integer userId) {
        UserDetail userDetail = userService.queryDetailByUserId(userId);
        return ResponseUtils.createResponse(SUCCESS, userDetail, Constants.SELECT_SUCCESS);
    }

    @GetMapping("/users/filter")
    public Object fetchUserByUserFilter(@RequestParamObject UserFilter userFilter) {
        List<User> userList = userService.queryUserByUserFilter(userFilter);
        return ResponseUtils.createResponse(SUCCESS, userList, Constants.SELECT_SUCCESS);
    }

    @PostMapping("/user")
    public Object addNewUser(@MultiRequestBody User user,
                             @MultiRequestBody UserDetail userDetail) {

        userService.addNewUserAndUserDetail(user, userDetail);
        return ResponseUtils.createResponse(SUCCESS, Constants.CREATE_SUCCESS);
    }

    @DeleteMapping("/user/{id}")
    public Object deleteUser(@PathVariable Integer id) {

        userService.removeUserById(id);
        return ResponseUtils.createResponse(SUCCESS, Constants.DELETE_SUCCESS);
    }


    @DeleteMapping("/users")
    public Object deleteUsers(@MultiRequestBody Integer[] ids) {

        userService.removeUserByIds(ids);
        return ResponseUtils.createResponse(SUCCESS, Constants.DELETE_SUCCESS);
    }

    @PatchMapping("/user")
    public Object editUser(@RequestBody User user) {
        userService.updateUserById(user);
        return ResponseUtils.createResponse(SUCCESS, Constants.UPDATE_SUCCESS);
    }
}
