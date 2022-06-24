package com.book.manager.dao;

import com.book.manager.entity.HotSearch;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface HotSearchMapper {

    void updateHotScore(List<Integer> list);

    void insert(Integer id);

    List<Integer> selectFive();

    void update(List<HotSearch> list);

}
