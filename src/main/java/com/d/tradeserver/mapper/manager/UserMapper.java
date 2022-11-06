package com.d.tradeserver.mapper.manager;

import com.d.tradeserver.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: Ding
 * @date: 2022/10/27 10:30
 * @description:
 * @modify:
 */


@Repository
public interface UserMapper {

    List<User> selectAll();

    Integer insertOne(User user);

    Integer updateUserDetailById(@Param("userId") Integer userId,
                                 @Param("userDetailId") Integer userDetailId);

    Integer notRealDeleteById(@Param("id") Integer id);

    Integer selectUserDetailIdById(@Param("id") Integer id);

    Integer notRealDeleteByIds(@Param("ids") Integer[] ids);

    List<Integer> selectUserDetailIdByIds(@Param("ids") Integer[] ids);

    User selectById(@Param("id") Integer id);

    Integer updateById(User newUser);

    Integer selectCountById(@Param("id") Integer id);

    List<User> selectByMap(Map<String, Object> map);

}
