package com.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.*;

@Transactional
@Repository
public class SlideDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Slide> getAllSlideList() {
		Session ses = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Slide> list = ses.createQuery("From Slide").list();
		return list;
	}
	
	public boolean deleteSlide(int idSlide) {
		Session ses = sessionFactory.getCurrentSession();
		Slide delete = ses.get(Slide.class, idSlide);
		ses.delete(delete);
		return true;
	}
	
	public Slide getSlideById(int idSlide) {
		Session ses = sessionFactory.getCurrentSession();
		Slide slide = ses.get(Slide.class, idSlide);
		return slide;
	}
	
	public Staff getStaffById(int idStaff) {
		Session ses = sessionFactory.getCurrentSession();
		Staff staff = ses.get(Staff.class, idStaff);
		return staff;
	}
	
	public boolean addSlide(Slide slides) {
		Session ses = sessionFactory.getCurrentSession();
		ses.save(slides);
		return true;
	}
	
	public boolean updateSlide(Slide slides) {
		Session ses = sessionFactory.getCurrentSession();
		ses.update(slides);
		return true;
	}
}
