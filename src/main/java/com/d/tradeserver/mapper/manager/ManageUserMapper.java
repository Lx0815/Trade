package com.d.tradeserver.manager.mapper;

import com.d.tradeserver.manager.pojo.ManageUser;
import org.springframework.stereotype.Repository;

/**
 * @author: Ding
 * @date: 2022/7/18 14:36
 * @description:
 * @modify:
 */

@Repository
public interface ManageUserMapper {

    Integer insertOne(ManageUser manageUser);

    ManageUser selectByPropertyEquals(ManageUser manageUser);

    Integer selectCountByPropertyEquals(ManageUser manageUser);
}
