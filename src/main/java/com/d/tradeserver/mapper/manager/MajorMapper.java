package com.d.tradeserver.mapper.manager;

import com.d.tradeserver.pojo.Major;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Ding
 * @date: 2022/7/18 14:36
 * @description:
 * @modify:
 */

@Repository
public interface MajorMapper {

    Major selectById(@Param("id") Integer id);

    List<Major> selectByKeyword(@Param("keywordLike") String keywordLike);

    List<Integer> selectIdsByName(@Param("nameLike") String nameLike);
}
