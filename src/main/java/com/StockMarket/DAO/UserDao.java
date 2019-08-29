package com.StockMarket.DAO;


import com.StockMarket.Entity.User;

public interface UserDao {
	public boolean SignUp(String username,String password);
	public User login(String username,String password);
	public int checkForVerifiedUser(String username,String password);	
	public boolean addUser(User user);
}
