package com.sale.service;

import java.util.ArrayList;

import com.sale.domain.Sales;

public interface SalesService {
	public int findAll();
	public ArrayList<Sales> seven();
	public ArrayList<Sales> findOne(String date);
	public ArrayList<Sales> findByPage(int startIndex,int pageSize);
}
