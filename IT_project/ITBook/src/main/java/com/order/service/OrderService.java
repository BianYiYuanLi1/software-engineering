package com.order.service;
import java.util.List;

import com.order.domain.Order;


public interface OrderService {
	public List<Order> findAll();
	public void add_list(int a,int b,int c);
	public List<Order> findByPage(int startIndex, int pageSize);
}
