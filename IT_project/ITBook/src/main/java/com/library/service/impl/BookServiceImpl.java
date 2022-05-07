package com.library.service.impl;

import java.util.List;

import com.library.dao.Bookdao;
import com.library.domain.Book;
import com.library.service.BookService;

public class BookServiceImpl implements BookService{

	@Override
	public List<Book> findByPage(int startIndex,int pageSize) {
		Bookdao bookDao=new Bookdao();
		return bookDao.findByPage(startIndex,pageSize);
	}

	@Override
	public void addBook(Book book) {
		Bookdao dao=new Bookdao();
		dao.addBook(book);
	}

	@Override
	public Book FindByBookId(int bookId) {
		Bookdao dao=new Bookdao();
		return dao.FindByBookId(bookId);
	}

	@Override
	public Book EditBook(Book book) {
		Bookdao dao=new Bookdao();
		return dao.EditBook(book);
		
	}

	@Override
	public void DeleteBook(int bookId) {
		Bookdao dao=new Bookdao();
		dao.DeleteBook(bookId);
	}

	@Override
	public List<Book> FindBook(String bookName,String bookWriter) {
		Bookdao dao=new Bookdao();
		return dao.FindBook(bookName,bookWriter);
	}

	@Override
	public int findAll() {
		Bookdao dao=new Bookdao();
		return dao.findAll();
	}
}
