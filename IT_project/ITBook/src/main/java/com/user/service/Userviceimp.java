package com.user.service;

import java.util.Hashtable;
import java.util.List;

import com.user.dao.*;
import com.user.Newuser.*;;

public class Userviceimp implements Uservice{
	@Override
	public void s_delete(int id) {
		// TODO Auto-generated method stub
		UDao sy=new UDao();
		sy.u_delete(id);
	}

	@Override
	public User s_search(int id) {
		// TODO Auto-generated method stub
		UDao sy=new UDao();
		return sy.u_search(id);
	}

	@Override
	public void s_add(User user) {
		// TODO Auto-generated method stub
		UDao sy=new UDao();
		sy.u_add(user);
	}

	@Override
	public List<User> s_findAll() {
		// TODO Auto-generated method stub
		UDao sy=new UDao();
		return sy.u_findAll();
	}

	@Override
	public void s_update(User user) {
		// TODO Auto-generated method stub
		UDao sy=new UDao();
	    sy.u_update(user);
	}

	@Override
	public int s_num() {
		// TODO Auto-generated method stub
		UDao sy=new UDao();
		return sy.u_num();
	}

	@Override
	public List<User> s_page(int start, int end) {
		// TODO Auto-generated method stub
		UDao sy=new UDao();
		return sy.u_page(start,end);
	}
	
	
}
