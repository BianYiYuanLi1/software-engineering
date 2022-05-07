package com.library.service;

import java.util.List;

import com.library.domain.Book;

public interface BookService {
	public List<Book> findByPage(int startIndex,int pageSize);
	public int findAll();
	public void addBook(Book book);
	public Book FindByBookId(int bookId);
	public Book EditBook(Book book);
	public void DeleteBook(int bookId);
	public List<Book> FindBook(String bookName,String bookWriter);
}
