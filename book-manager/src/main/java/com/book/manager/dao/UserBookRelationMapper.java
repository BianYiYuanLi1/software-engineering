package com.book.manager.dao;

import com.book.manager.entity.HotSearch;
import com.book.manager.entity.UserBookRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserBookRelationMapper {
    List<UserBookRelation> selectAll();

    void batchInsert(List<UserBookRelation> userBookRelations);

    void updateRecommendScore(@Param("userId") Integer userId,@Param("bookIds") List<Integer> bookIds,@Param("score") Integer score);

    List<HotSearch> selectScoreGroupByBookId();

    void deleteByUserId(Integer userId);
}
