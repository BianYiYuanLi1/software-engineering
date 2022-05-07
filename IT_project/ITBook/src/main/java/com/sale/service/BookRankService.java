package com.sale.service;

import java.util.ArrayList;

import com.sale.domain.BookRank;


public interface BookRankService {
	public int findAll(String date);
	public ArrayList<BookRank> findByPage(int startIndex,int pageSize,String date);
	public ArrayList<BookRank> findseven();
}
