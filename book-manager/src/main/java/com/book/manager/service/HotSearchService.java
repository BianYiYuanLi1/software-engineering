package com.book.manager.service;

import com.book.manager.dao.BookMapper;
import com.book.manager.dao.HotSearchMapper;
import com.book.manager.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotSearchService {

    @Autowired
    private HotSearchMapper hotSearchMapper;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;

    public void updateHotScore(List<Integer> book_ids) {
        hotSearchMapper.updateHotScore(book_ids);
    }

    public List<Book> findHotBookList() {
        List<Integer> list = hotSearchMapper.selectFive();
        List<Book> bookList = bookMapper.getHotBookList(list);
        for (Book book : bookList) {
            System.out.println(book);
        }
        return bookList;
    }
}
