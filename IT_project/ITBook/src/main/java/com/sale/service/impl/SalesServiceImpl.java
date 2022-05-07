package com.sale.service.impl;

import java.util.ArrayList;

import com.sale.dao.SalesDao;
import com.sale.domain.Sales;
import com.sale.service.SalesService;


public class SalesServiceImpl implements SalesService{

	@Override
	public int findAll() {
		SalesDao salesdao = new SalesDao();
		return salesdao.findAll();
	}

	@Override
	public ArrayList<Sales> seven() {
		SalesDao salesdao = new SalesDao();
		return salesdao.seven();
	}

	@Override
	public ArrayList<Sales> findOne(String date) {
		SalesDao salesdao = new SalesDao();
		return salesdao.findOne(date);
	}

	@Override
	public ArrayList<Sales> findByPage(int startIndex, int pageSize) {
		SalesDao salesdao = new SalesDao();
		return salesdao.findByPage(startIndex, pageSize);
	}
	
}
