package com.demo.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.Bugs;
import com.demo.model.Staff;

@Transactional
@Repository
public class BugsDAO {
	@Autowired
	private SessionFactory sessionFactory;

// get all list bug
	@SuppressWarnings("unchecked")
	public List<Bugs> getListBug() {
		Session ses = sessionFactory.getCurrentSession();
		List<Bugs> list = ses.createQuery("From Bugs").list();
		return list;
	}

//	delete bug
	public boolean deleteBug(int idBug) {
		Session ses = sessionFactory.getCurrentSession();
		Query query1 = ses.createQuery("delete Commentbugs where bugs.idBugs = '" + idBug + "'");
		query1.executeUpdate();
		Query query = ses.createQuery("delete Bugs where idBugs = '" + idBug + "'");
		query.executeUpdate();
		return true;
	}

//	add bug
	public boolean addBug(int idStaff, String names) {
		Session ses = sessionFactory.getCurrentSession();
		Staff staff = ses.get(Staff.class, idStaff);
		Bugs bugs = new Bugs();
		bugs.setStaff(staff);
		bugs.setNames(names);
		ses.save(bugs);
		return true;
	}

//	update bug
	public boolean updateBug(int idBugs, int idStaff, String names) {
		Session ses = sessionFactory.getCurrentSession();
		Staff staff = ses.get(Staff.class, idStaff);
		Bugs bugs = new Bugs();
		bugs.setIdBugs(idBugs);
		bugs.setStaff(staff);
		bugs.setNames(names);
		ses.update(bugs);
		return true;
	}
}
