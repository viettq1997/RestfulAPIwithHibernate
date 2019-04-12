package com.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.Request;
import com.demo.model.Staff;
@Transactional
@Repository
public class RequestDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Request> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Request> list = session.createQuery("from Request").list();
		return list;
	}
	public Request info(int Id) {
		Session session = this.sessionFactory.getCurrentSession();
		Request request = (Request) session.get(Request.class, Id);
		return request;
	}

	public boolean save(int idstaff,int requestType) {
		Session session = this.sessionFactory.getCurrentSession();
		Staff sta = session.get(Staff.class,idstaff);
		Request aa = new Request();
		aa.setStaff(sta);
		aa.setRequestType(requestType);
		aa.setStatus(false);
		session.save(aa);
		return true;
	}

	public void delete(int Id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(info(Id));
		
	}

	public boolean update(int id ,int idstaff,int requestType,boolean status) {
		Session session = this.sessionFactory.getCurrentSession();
		Staff sta = session.get(Staff.class,idstaff);
		Request aa = new Request();
		aa.setIdRequest(id);
		aa.setStaff(sta);
		aa.setRequestType(requestType);
		aa.setStatus(status);
		session.update(aa);
		return true;
	}
	@SuppressWarnings("rawtypes")
	public boolean dongy(int id) {
		Session ses = sessionFactory.getCurrentSession();
		Query query = (Query) ses.createQuery("update Request set status = true where idRequest = '" + id + "'");
		query.executeUpdate();
		return true;
	}
	@SuppressWarnings("rawtypes")
	public boolean tuchoi(int id) {
		Session ses = sessionFactory.getCurrentSession();
		Query query = (Query) ses.createQuery("update Request set status = false where idRequest = '" + id + "'");
		query.executeUpdate();
		return true;
	}
}
