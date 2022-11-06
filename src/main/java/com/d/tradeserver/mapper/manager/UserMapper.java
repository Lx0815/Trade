package com.d.tradeserver.mapper.trade;

import com.d.tradeserver.pojo.trade.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Ding
 * @date: 2022/10/27 10:30
 * @description:
 * @modify:
 */


@Repository
public interface UserMapper {

    List<User> selectAll();

}
