package com.StockMarket.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.StockMarket.Entity.Company;
import com.StockMarket.Entity.Directors;
import com.StockMarket.Entity.IPO;
import com.StockMarket.Entity.StockExchange;
@Repository(value="AdminDao")
public class AdminDaoImpl implements AdminDao{

	@Autowired
	SessionFactory sessionFactory;
//	@Autowired
//	Company company;
	static int count=0;
	@Override
	@Transactional
	public StockExchange addStockExchanges() {
		
		return null;
	}

	@Override
	@Transactional
	public Company addCompany(Company company) {
		
		Session session=sessionFactory.getCurrentSession();
		try{
			session.persist(company);
		}
		catch(Exception e)
    	{
    		e.printStackTrace();	
    	}
		return company;
	}

	
	
	@Override
	@Transactional
	public boolean AddBod(Directors director) {
		Session session=sessionFactory.getCurrentSession();
		try{
			session.persist(director);
			return true;
		}
		catch(Exception e)
    	{
    		e.printStackTrace();	
    	}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Directors> fetchDirectors(int lastIndex,int counter) {
		Session session=sessionFactory.getCurrentSession();
		System.out.println("In fetchDirectors LastIndex->"+lastIndex);
		System.out.println("In fetchDirectors Counter->"+counter);
		String sql="from Directors d where d.directorsId>"+counter;
		String sql1="from Directors d where d.directorsId<"+lastIndex+1;
		List<Directors> directors=null;
		if(counter==1&&lastIndex!=0){
		Query query=session.createQuery(sql1);
		directors=query.getResultList();}
		else if(counter>1&&lastIndex!=0)
		{
			Query query=session.createQuery(sql);
			directors=query.getResultList();
		}
		else
			return  new ArrayList<Directors>();
		System.out.println("Directors---->"+directors);
		return directors;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public int fetchDirectorsLastId() {
		Session session=sessionFactory.getCurrentSession();
//		Query query=session.createQuery("from Directors order by d.directorsId DESC");
//		query.setMaxResults(1);
		Query query=session.createQuery("from Directors");
		List<Directors> director=new ArrayList<Directors>();
		director=(List<Directors>)query.getResultList();
		int max=0;
		for(Directors l:director)
		{
			if(max<l.getdirectorsId())
			{
				max=l.getdirectorsId();
			}
		}
		if(director.size()!=0)
		return max;
		return 0;
	}

	

	@Override
	@Transactional
	public boolean deactivateCompany(String companyId) {
		// TODO Auto-generated method stub
				++count;
				Session session=sessionFactory.getCurrentSession();
				Query query=session.createQuery("from Company c where c.companyId=?");
				query.setParameter(0,companyId);
				Company company=(Company)query.getSingleResult();
				Company dummyCompany=new Company();
				dummyCompany.setCompanyId("deactivated_"+count);
				dummyCompany.setCompanyName(company.getCompanyName());
				dummyCompany.setCompanyTurnOver(company.getCompanyTurnOver());
				dummyCompany.setCompanyCeo(company.getCompanyCeo());
				dummyCompany.setCompanyBrief(company.getCompanyBrief());
				dummyCompany.setCompanySector(company.getCompanySector());
				dummyCompany.setDirectorName(company.getDirectorName());
				dummyCompany.setCompanyStockCode(company.getCompanyStockCode());
				session.persist(dummyCompany);
				session.delete(company);
				
				return true;
	}

	@Override
	@Transactional
	public List<Company> showAllCompany() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Company");
		@SuppressWarnings("unchecked")
		List<Company> companyList=(List<Company>)query.getResultList();
		System.out.println(companyList);
		return companyList;
	}

	@Override
	public boolean updateCompanyName(String companyName, String companyId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Company c where c.companyId=?");
		query.setParameter(0,companyId);
		Company company=(Company)query.getSingleResult();
		company.setCompanyName(companyName);
		session.update(company);
		return true;
	}

	@Override
	public boolean updateCompanyCeo(String companyCeo, String companyId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Company c where c.companyId=?");
		query.setParameter(0,companyId);
		Company company=(Company)query.getSingleResult();
		company.setCompanyCeo(companyCeo);
		session.update(company);
		return true;
	}

	@Override
	public boolean updateCompanyTurnOver(int companyTurnOver, String companyId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Company c where c.companyId=?");
		query.setParameter(0,companyId);
		Company company=(Company)query.getSingleResult();
		company.setCompanyTurnOver(companyTurnOver);
		session.update(company);
		return true;
	}

	@Override
	public boolean updateCompanyBrief(String companyBrief, String companyId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Company c where c.companyId=?");
		query.setParameter(0,companyId);
		Company company=(Company)query.getSingleResult();
		company.setCompanyBrief(companyBrief);
		session.update(company);
		return true;
	}

	@Override
	public boolean updateCompanySector(String companySector, String companyId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Company c where c.companyId=?");
		query.setParameter(0,companyId);
		Company company=(Company)query.getSingleResult();
		company.setCompanySector(companySector);
		session.update(company);
		return true;
	}

	@Override
	public boolean updateCompanyDirector(List<Directors> director, String companyId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Company c where c.companyId=?");
		query.setParameter(0,companyId);
		Company company=(Company)query.getSingleResult();
		company.setDirectorName(director);
		session.update(company);
		return true;
	}

	@Override
	public IPO addIPO(IPO ipo) {
		// TODO Auto-generated method stub

		Session session=sessionFactory.getCurrentSession();
		try{
			session.persist(ipo);
		}
		catch(Exception e)
    	{
    		e.printStackTrace();	
    	}
		return ipo;
	}

	@Override
	public Company fetchCompanyById(String companyId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Company c where c.companyId=?");
		query.setParameter(0,companyId);
		Company company=(Company)query.getSingleResult();
		return company;
	}
	
	
	

}
