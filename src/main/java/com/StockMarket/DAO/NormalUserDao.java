package com.StockMarket.DAO;

import java.util.List;

import com.StockMarket.Entity.Company;
import com.StockMarket.Entity.IPO;
import com.StockMarket.Model.NormalUser;

public interface NormalUserDao {

	public NormalUser updateProfile();
	public Company SearchComapny();
	public List<IPO> viewIPO();
}
