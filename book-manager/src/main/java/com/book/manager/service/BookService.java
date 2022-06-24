package com.book.manager.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.book.manager.dao.BookMapper;
import com.book.manager.dao.HotSearchMapper;
import com.book.manager.dao.UserBookRelationMapper;
import com.book.manager.entity.Book;
import com.book.manager.entity.UserBookRelation;
import com.book.manager.repos.BookRepository;
import com.book.manager.util.vo.BookOut;
import com.book.manager.util.vo.PageOut;
import com.book.manager.util.ro.PageIn;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Description 图书业务类
 */
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private HotSearchService hotSearchService;

    @Autowired
    private HotSearchMapper hotSearchMapper;

    @Autowired
    UserBookRelationMapper userBookRelationMapper;


    /**
     * 添加用户
     * @param book 图书
     * @return 返回添加的图书
     */
    public Book addBook(Book book) {
        Book book1 = bookRepository.saveAndFlush(book);
        System.out.println("新插入"+book1.getId());
        hotSearchMapper.insert(book1.getId());
        return book1;
    }

    /**
     * 编辑用户
     * @param book 图书对象
     * @return true or false
     */
    public boolean updateBook(Book book) {
        return bookMapper.updateBook(BeanUtil.beanToMap(book))>0;
    }

    /**
     * 图书详情
     * @param id 主键
     * @return 图书详情
     */
    public BookOut findBookById(Integer id) {
        Optional<Book> optional = bookRepository.findById(id);
        if (optional.isPresent()) {
            Book book = optional.get();
            BookOut out = new BookOut();
            BeanUtil.copyProperties(book,out);
            out.setPublishTime(DateUtil.format(book.getPublishTime(),"yyyy-MM-dd"));
            return out;
        }
        return null;
    }

    public Book findBook(Integer id) {
        Optional<Book> optional = bookRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    /**
     * ISBN查询
     * @param isbn
     * @return
     */
    public BookOut findBookByIsbn(String isbn) {
        Book book = bookRepository.findByIsbn(isbn);
        BookOut out = new BookOut();
        if (book == null) {
            return out;
        }
        BeanUtil.copyProperties(book,out);
        out.setPublishTime(DateUtil.format(book.getPublishTime(),"yyyy-MM-dd"));
        return out;
    }

    /**
     * 删除图书
     * @param id 主键
     * @return true or false
     */
    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }


    /**
     * 图书搜索查询(mybatis 分页)
     * @param pageIn
     * @return
     */
    public PageOut getBookList(PageIn pageIn) {

        PageHelper.startPage(pageIn.getCurrPage(),pageIn.getPageSize());
        String keyword = pageIn.getKeyword();
        List<Book> list = bookMapper.findBookListByLike(keyword);
        //如果关键字不为空就更新热搜榜和推荐榜
        System.out.println("keyword="+keyword);
        if(!StringUtils.isEmpty(keyword)){
            List<Integer> book_ids = list.stream().map(book -> book.getId()).collect(Collectors.toList());
            hotSearchService.updateHotScore(book_ids);
            hotSearchService.updateRecommendScore(book_ids,1);
        }
        PageInfo<Book> pageInfo = new PageInfo<>(list);

        List<BookOut> bookOuts = new ArrayList<>();
        for (Book book : pageInfo.getList()) {
            BookOut out = new BookOut();
            BeanUtil.copyProperties(book,out);
            out.setPublishTime(DateUtil.format(book.getPublishTime(),"yyyy-MM-dd"));
            bookOuts.add(out);
        }

        // 自定义分页返回对象
        PageOut pageOut = new PageOut();
        pageOut.setList(bookOuts);
        pageOut.setTotal((int)pageInfo.getTotal());
        pageOut.setCurrPage(pageInfo.getPageNum());
        pageOut.setPageSize(pageInfo.getPageSize());
        return pageOut;
    }


    public PageOut getHotBookList(PageIn pageIn) {
        PageHelper.startPage(pageIn.getCurrPage(),pageIn.getPageSize());
        List<Book> list = hotSearchService.findHotBookList();
        PageInfo<Book> pageInfo = new PageInfo<>(list);

        List<BookOut> bookOuts = new ArrayList<>();
        for (Book book : pageInfo.getList()) {
            BookOut out = new BookOut();
            BeanUtil.copyProperties(book,out);
            out.setPublishTime(DateUtil.format(book.getPublishTime(),"yyyy-MM-dd"));
            bookOuts.add(out);
        }

        // 自定义分页返回对象
        PageOut pageOut = new PageOut();
        pageOut.setList(bookOuts);
        pageOut.setTotal((int)pageInfo.getTotal());
        pageOut.setCurrPage(pageInfo.getPageNum());
        pageOut.setPageSize(pageInfo.getPageSize());
        return pageOut;
    }

    public PageOut getRecommendBookList(PageIn pageIn) {
        List<UserBookRelation> list1 = userBookRelationMapper.selectAll();
        PageHelper.startPage(pageIn.getCurrPage(),pageIn.getPageSize());
        List<Book> list = hotSearchService.findRecommendBookList(list1);
        PageInfo<Book> pageInfo = new PageInfo<>(list);

        List<BookOut> bookOuts = new ArrayList<>();
        for (Book book : pageInfo.getList()) {
            BookOut out = new BookOut();
            BeanUtil.copyProperties(book,out);
            out.setPublishTime(DateUtil.format(book.getPublishTime(),"yyyy-MM-dd"));
            bookOuts.add(out);
        }

        // 自定义分页返回对象
        PageOut pageOut = new PageOut();
        pageOut.setList(bookOuts);
        pageOut.setTotal((int)pageInfo.getTotal());
        pageOut.setCurrPage(pageInfo.getPageNum());
        pageOut.setPageSize(pageInfo.getPageSize());
        return pageOut;
    }
}
