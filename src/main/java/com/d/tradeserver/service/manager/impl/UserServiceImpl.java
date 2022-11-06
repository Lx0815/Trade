package com.d.tradeserver.service.trade.impl;

import com.d.tradeserver.common.utils.MyPair;
import com.d.tradeserver.common.utils.MyPairUtils;
import com.d.tradeserver.mapper.trade.UserMapper;
import com.d.tradeserver.pojo.trade.User;
import com.d.tradeserver.service.trade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @author: Ding
 * @date: 2022/10/27 10:38
 * @description:
 * @modify:
 */


@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public MyPair<Boolean, Object> queryAllUser() {
        List<User> userList = userMapper.selectAll();
        if (ObjectUtils.nullSafeEquals(userList.size(), 0)) {
            return MyPairUtils.createMyPair(Boolean.FALSE, "暂无数据");
        } else {
            return MyPairUtils.createMyPair(Boolean.TRUE, userList);
        }
    }
}
