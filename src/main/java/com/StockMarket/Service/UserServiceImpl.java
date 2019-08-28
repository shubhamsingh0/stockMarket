package com.StockMarket.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StockMarket.DAO.UserDao;
import com.StockMarket.Entity.User;
import com.StockMarket.Exception.StockMarketExceptionHandler;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userdao;
	@Override
	public boolean SignUp(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		if(userdao.login(username, password).getUserId()>0)
			return true;
		return false;
		
	}

	@Override
	public boolean checkForVerifiedUser(String username, String password) {
		// TODO Auto-generated method stub
		if(userdao.checkForVerifiedUser(username, password)==1){
			return true;
		}
		return false;
	}

	@Override
	public User fetchUser(String username, String password)  {
		// TODO Auto-generated method stub
		return userdao.login(username, password);
	}

	@Override
	public boolean adduserRegistration(User user) {
		// TODO Auto-generated method stub
		return userdao.addUser(user);
		
	}

}
