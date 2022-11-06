package com.d.tradeserver.mapper.manager;

import com.d.tradeserver.pojo.UserDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: Ding
 * @date: 2022/7/18 14:36
 * @description:
 * @modify:
 */

@Repository
public interface UserDetailMapper {

    UserDetail selectById(@Param("id") Integer id);


    Integer insertOne(UserDetail userDetail);

    UserDetail selectByUserId(@Param("userId") Integer userId);

    Integer notRealDeleteById(@Param("id") Integer id);

    Integer notRealDeleteByIds(@Param("ids") Integer[] ids);

    Integer updateById(UserDetail userDetail);

    Integer selectCountById(@Param("id") Integer id);

    List<Integer> selectUserIdsByMap(Map<String, Object> map);
}
