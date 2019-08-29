package com.StockMarket.DAO;

import java.util.List;

import com.StockMarket.Entity.Company;
import com.StockMarket.Entity.Directors;
import com.StockMarket.Entity.IPO;
import com.StockMarket.Entity.StockExchange;

public interface AdminDao {
	public StockExchange addStockExchanges();
	public Company addCompany(Company company);
	boolean AddBod(Directors director);
	public List<Directors> fetchDirectors(int lastIndex,int counter);
	public int fetchDirectorsLastId();
	public boolean deactivateCompany(String CompanyId);
	public List<Company> showAllCompany();
	public boolean updateCompanyName(String companyName,String CompanyId);
	public boolean updateCompanyCeo(String companyCeo,String CompanyId);
	public boolean updateCompanyTurnOver(int companyTurnOver,String CompanyId);
	public boolean updateCompanyBrief(String companyBrief,String CompanyId);
	public boolean updateCompanySector(String companySector,String CompanyId);
	public boolean updateCompanyDirector(List<Directors> director,String CompanyId); 
	public IPO addIPO(IPO ipo); 
	public Company fetchCompanyById(String companyId);
}
