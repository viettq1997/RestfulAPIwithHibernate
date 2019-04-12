package com.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.Staff;
import com.demo.security.JwtTokenProvider;

@Transactional
@Repository
public class SecutityDao {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	JwtTokenProvider token;

	public Staff getStaff(String StaffName) {
		Staff Staff = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			Staff user = (Staff) session.createQuery("from Staff where username = :username ")
					.setParameter("username", StaffName).uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return Staff;
	}

	public String checkLogin(String userName, String passWord) {
		String result = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			Staff user = (Staff) session.createQuery("from Staff where username = :username ")
					.setParameter("username", userName).uniqueResult();
			if (user != null) {
				if (user.getSchool().equals(passWord.trim())) {
					result = token.createToken(user.getUsername());
				} else {
					result = "error password";
				}

			} else {
				result = "error username";
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return result;
	}

	public String checkLogin2(String userName, String passWord) {
		String result = "";
		Session session = sessionFactory.getCurrentSession();
		try {
			Staff user = (Staff) session.createQuery("from Staff where username = :username ")
					.setParameter("username", userName).uniqueResult();
			if (user != null) {
				if (user.getSchool().equals(passWord.trim())) {
					result = Integer.toString(user.getIdStaff()); 
					return result;
				} else {
					result = "Sai username hoặc password";
					return result;
				}

			} else {
				result = "Username không tồn tại";
				return result;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return result;

	}
	
	public Staff getById(int  id) {
		Session session = sessionFactory.getCurrentSession();
		Staff staff = session.get(Staff.class, id);
		return staff;
	}

}
