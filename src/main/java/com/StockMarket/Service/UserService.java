package com.StockMarket.Service;


import com.StockMarket.Entity.User;

public interface UserService {

	public boolean SignUp(String username,String password);
	public boolean login(String username,String password) ;
	public boolean checkForVerifiedUser(String username,String password);
	public User fetchUser(String username, String password) ;
	public boolean adduserRegistration(User user);
}
