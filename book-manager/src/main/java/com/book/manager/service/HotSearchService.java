package com.book.manager.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.book.manager.dao.BookMapper;
import com.book.manager.dao.HotSearchMapper;
import com.book.manager.dao.UserBookRelationMapper;
import com.book.manager.entity.Book;
import com.book.manager.entity.UserBookRelation;
import com.book.manager.entity.Users;
import com.book.manager.util.R;
import com.book.manager.util.consts.Constants;
import com.book.manager.util.http.CodeEnum;
import com.book.manager.util.recommend.Recommend;
import com.book.manager.util.vo.UserOut;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HotSearchService {

    @Autowired
    private HotSearchMapper hotSearchMapper;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private UserBookRelationMapper userBookRelationMapper;

    @Autowired
    Recommend recommend;

    @Autowired
    UserService userService;

    public void updateHotScore(List<Integer> book_ids) {
        hotSearchMapper.updateHotScore(book_ids);
    }

    public List<Book> findHotBookList() {
        List<Integer> list = hotSearchMapper.selectFive();
        List<Book> bookList = bookMapper.getBookList(list);
        for (Book book : bookList) {
            System.out.println(book);
        }
        return bookList;
    }

    public List<Book> findRecommendBookList(List<UserBookRelation> list) {

        Integer userId = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal!=null) {
            Map<String,Object> map = BeanUtil.beanToMap(principal);
            String username = (String) map.get("username");
            if (StrUtil.isNotBlank(username)) {
                Users user = userService.findByUsername(username);
                userId = user.getId();
            }
        }
        List<Integer> recommend = this.recommend.recommend(userId, list);
        List<Book> bookList = bookMapper.getBookList(recommend);
        return bookList;
    }

    public void updateRecommendScore(List<Integer> bookIds,Integer score) {
        Integer userId = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal!=null) {
            Map<String,Object> map = BeanUtil.beanToMap(principal);
            String username = (String) map.get("username");
            if (StrUtil.isNotBlank(username)) {
                Users user = userService.findByUsername(username);
                userId = user.getId();
            }
        }
        userBookRelationMapper.updateRecommendScore(userId,bookIds,score);
    }
}
