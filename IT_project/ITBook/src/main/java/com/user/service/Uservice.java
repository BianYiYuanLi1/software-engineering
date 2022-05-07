package com.user.service;


import java.util.List;

import com.user.Newuser.*;

public interface Uservice {
	public User s_search(int id);
	public void s_add(User user);
	public List<User> s_findAll();
	public void s_update(User user);
	public void s_delete(int id);
	public int s_num();
	public List<User>s_page(int start,int end);
}
