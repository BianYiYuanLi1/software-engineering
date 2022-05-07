package com.order.domain;
import java.text.SimpleDateFormat;

public class Order {
	private int order_id;//主键
	private String create_time;//订单创建时间
	private int book_id;//图书编号
	private int user_id;//用户编号
	private int prices;
	private int numbers;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int id) {
		order_id = id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int id) {
		book_id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int id) {
		user_id = id;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String t) {
		create_time = t;	
	}
	public void setPrices(int t) {
		prices=t;
	}
	public int getPrices() {
		return prices;
	}
	public int getNumbers() {
		return numbers;
	}
	public void setNumbers(int id) {
		numbers = id;
	}
}
