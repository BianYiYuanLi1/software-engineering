package com.order.service;

import java.util.List;

import com.order.dao.OrderDao;
import com.order.domain.Order;

public class Serviceimpl implements OrderService{
	
	//��ѯ�����б�
	 @Override
     public List<Order> findAll()
     {
    	 OrderDao orderDao=new OrderDao();
 		 return orderDao.findAll();
     }
	 //��Ӷ�����¼
	 @Override
	 public void add_list(int user_id,int book_id,int numbe)
	 {
		 OrderDao orderDao=new OrderDao();
 		 orderDao.add_list(user_id,book_id,numbe);
	 }
	@Override
	public List<Order> findByPage(int startIndex, int pageSize) {
		OrderDao orderDao=new OrderDao();
		 return orderDao.findByPage(startIndex, pageSize);
	}
}
