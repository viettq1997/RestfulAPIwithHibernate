package com.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.News;
import com.demo.model.Staff;

@Transactional
@Repository
public class NewsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<News> getAll() {
		Session ses = sessionFactory.getCurrentSession();
		List<News> list = ses.createQuery("From News").list();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<News> getTop4Leader() {
		Session ses = sessionFactory.getCurrentSession();
		List<News> list = ses.createQuery("From News").list();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<News> getTop3New() {
		Session ses = sessionFactory.getCurrentSession();
		List<News> list = ses.createQuery("From News").list();
		return list;
	}

	public Staff getStaffByiD(int id) {
		Session session = sessionFactory.getCurrentSession();
		Staff staff = session.get(Staff.class, id);
		return staff;
	}

	public boolean addNew(News news) {
		Session ses = sessionFactory.getCurrentSession();
		ses.save(news);
		return true;

	}

	public News getById(int id) {
		Session ses = sessionFactory.getCurrentSession();
		News news = ses.get(News.class, id);
		return news;
	}

	public List<News> getByTitle(String key) {
		Session session = sessionFactory.getCurrentSession();
		String sql = " From News where image like '" + key + "'";
		List<News> list = session.createQuery(sql).list();
		System.out.println("===" + list.size());
		return list;
	}
	
	public boolean UpdateNew(News news) {
		Session  session = sessionFactory.getCurrentSession();
		session.update(news);
		return true;
	}

	public boolean deleteById(int id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			News news = session.get(News.class, id);
			session.delete(news);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public List<News> getTo3() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from News where ROWNUM <= 3 order by dates desc";
		List<News> list = session.createQuery(sql).list();
		System.out.println("===" + list.size());
		return list;
	}
	
}
