package com.d.tradeserver.mapper.trade;

import com.d.tradeserver.pojo.trade.UserDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author: Ding
 * @date: 2022/7/18 14:36
 * @description:
 * @modify:
 */

@Repository
public interface UserDetailMapper {

    UserDetail selectById(@Param("id") Integer id);


}
