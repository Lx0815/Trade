package com.d.tradeserver.mapper.trade;

import com.d.tradeserver.pojo.trade.Major;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author: Ding
 * @date: 2022/7/18 14:36
 * @description:
 * @modify:
 */

@Repository
public interface MajorMapper {

    Major selectById(@Param("id") Integer id);


}
