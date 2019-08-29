package com.StockMarket.DAO;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.StockMarket.Entity.User;
import com.StockMarket.Model.Admin;
import com.StockMarket.Model.NormalUser;

@Repository
public class UserDaoImpl implements UserDao {

//	@PersistenceContext
//	EntityManager em;
	@Autowired
	SessionFactory sessionfactory;

	@Override
	@Transactional
	public boolean SignUp(String username, String password) {
		/*
		 * try { jdbcTemplateObject=(JdbcTemplate) datasource.getConnection(); }
		 * catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */return false;
	}

	@Override
	@Transactional
	public int checkForVerifiedUser(String username, String password) {
		// TODO Auto-generated method stub
		int status = 0;
		User user=new User();
		Session session=sessionfactory.getCurrentSession();
		try {
//			String sql = "select statusUser from User where nameUser='" + username + "' and passwordUser='" + password
//					+ "'";
			
			Query query=session.createQuery("from User where username=? and password=?");
			query.setParameter(0,username);
			query.setParameter(1,password);
			user=(User)query.getSingleResult();
			status=user.getStatusConfirmed();
			System.out.println("*************************status:" + status);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

		return status;
	}

	@Override
	@Transactional
	public User login(String username, String password) {
		// TODO Auto-generated method stub

		User user = null;
		User useris = null;
		Session session=sessionfactory.getCurrentSession();
		
		try {
			Query query=session.createQuery("from User where username=? and password=?");
			query.setParameter(0,username);
			query.setParameter(1,password);
			user=(User)query.getSingleResult();
			if (user.getUserType().equals("admin")) {
				
				useris = new User(user.getUserId(), user.getUsername(), user.getUserType(), user.getEmail(),
						user.getMobileNumber());
			}
			if (user.getUserType().equals("normal")) {
				useris = new User(user.getUserId(), user.getUsername(), user.getUserType(), user.getEmail(),
						user.getMobileNumber());
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(useris);
		return useris;
	}

	@Override
	@Transactional
	public boolean addUser(User user) {
		try{
			Session session=null;
			session=sessionfactory.getCurrentSession();
			session.persist(user);
		}
		catch(Exception e)
    	{
    		e.printStackTrace();
    		return false;
    	}
		return true;
	}

}
