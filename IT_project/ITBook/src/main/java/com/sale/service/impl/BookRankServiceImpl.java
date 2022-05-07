package com.sale.service.impl;

import java.util.ArrayList;
import java.util.HashSet;

import com.sale.dao.BookRankDao;
import com.sale.domain.BookRank;
import com.sale.service.BookRankService;


public class BookRankServiceImpl implements BookRankService{

	@Override
	public int findAll(String date) {
		BookRankDao bookrankDao = new BookRankDao();
		return bookrankDao.findAll(date);
	}

	@Override
	public ArrayList<BookRank> findByPage(int startIndex, int pageSize, String date) {
		BookRankDao bookrankDao = new BookRankDao();
		return bookrankDao.findByPage(startIndex, pageSize, date);
	}

	@Override
	public ArrayList<BookRank> findseven() {
		BookRankDao bookrankDao = new BookRankDao();
		return bookrankDao.findseven();
	}

	
}
