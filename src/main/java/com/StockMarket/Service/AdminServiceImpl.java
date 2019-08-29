package com.StockMarket.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StockMarket.DAO.AdminDao;
import com.StockMarket.DAO.UserDao;
import com.StockMarket.Entity.Company;
import com.StockMarket.Entity.StockExchange;
import com.StockMarket.Entity.Directors;
import com.StockMarket.Entity.IPO;
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminDao adminDao;
	@Override
	public StockExchange addStockExchanges() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company manageCompany() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company addCompany(Company company) {
		// TODO Auto-generated method stub
		return adminDao.addCompany(company);
	}

	@Override
	public boolean AddBod(Directors director) {
		// TODO Auto-generated method stub
		return adminDao.AddBod(director);
	}

	@Override
	public List<Directors> fetchDirectors(int lastIndex,int counter) {
		
		return adminDao.fetchDirectors(lastIndex,counter);
	}

	@Override
	public int fetchDirectorsLastId() {
		// TODO Auto-generated method stub
		return adminDao.fetchDirectorsLastId();
	}

	

	@Override
	public boolean deactivateCompany(String CompanyId) {
		// TODO Auto-generated method stub
		return adminDao.deactivateCompany(CompanyId);
	}

	@Override
	public List<Company> showAllCompany() {
		// TODO Auto-generated method stub
		return adminDao.showAllCompany();
	}

	@Override
	public boolean updateCompanyName(String companyName, String CompanyId) {
		// TODO Auto-generated method stub
		return adminDao.updateCompanyName(companyName, CompanyId);
	}

	@Override
	public boolean updateCompanyCeo(String companyCeo, String CompanyId) {
		// TODO Auto-generated method stub
		return adminDao.updateCompanyCeo(companyCeo, CompanyId);
	}

	@Override
	public boolean updateCompanyTurnOver(int companyTurnOver, String CompanyId) {
		// TODO Auto-generated method stub
		return adminDao.updateCompanyTurnOver(companyTurnOver, CompanyId);
	}

	@Override
	public boolean updateCompanyBrief(String companyBrief, String CompanyId) {
		// TODO Auto-generated method stub
		return adminDao.updateCompanyBrief(companyBrief, CompanyId);
	}

	@Override
	public boolean updateCompanySector(String companySector, String CompanyId) {
		// TODO Auto-generated method stub
		return adminDao.updateCompanySector(companySector, CompanyId);
	}

	@Override
	public boolean updateCompanyDirector(List<Directors> director, String CompanyId) {
		// TODO Auto-generated method stub
		return adminDao.updateCompanyDirector(director, CompanyId);
	}

	@Override
	public IPO addIPO(IPO ipo) {
		// TODO Auto-generated method stub
		return adminDao.addIPO(ipo);
	}

	@Override
	public Company fetchCompanyById(String companyId) {
		// TODO Auto-generated method stub
		return adminDao.fetchCompanyById(companyId);
	} 
	
}
