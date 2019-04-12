package com.demo.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.Project;
import com.demo.model.Staff;
import com.demo.model.Timesheet;

@Transactional
@Repository
public class TimesheetDAO {

	@Autowired
	private SessionFactory sessionFactory;

//	get all list
	@SuppressWarnings("unchecked")
	public List<Timesheet> getAllReportList() {
		Session ses = sessionFactory.getCurrentSession();
		List<Timesheet> list = ses.createQuery("From Timesheet").list();
		return list;
	}

//	delete
	public boolean deleteTimeSheet(int idTimesheet) {
		Session ses = sessionFactory.getCurrentSession();
		Timesheet delete = ses.get(Timesheet.class, idTimesheet);
		ses.delete(delete);
		return true;
	}

//	delete foreign key 
//	public boolean deleteTs(int idTimesheet) {
//		Session ses = sessionFactory.getCurrentSession();
//		Query query1 = ses.createQuery("delete Reports where timesheet.idTs = '" + idTimesheet + "'");
//		query1.executeUpdate();
//		Query query2 = ses.createQuery("delete Timesheet where idTs = '" + idTimesheet + "'");
//		query2.executeUpdate();
//		return true;
//	}

// get by id
	public Timesheet getTimeSheetById(int idTimesheet) {
		Session ses = sessionFactory.getCurrentSession();
		Timesheet timesheet = ses.get(Timesheet.class, idTimesheet);
		return timesheet;
	}

// add
	public boolean addTimesheet(int idProject, int idStaff, String task, String times, boolean results, String note) {
		Session ses = sessionFactory.getCurrentSession();
		Staff staff = ses.get(Staff.class, idStaff);
		Project project = ses.get(Project.class, idProject);
		Timesheet timesheet = new Timesheet();
		timesheet.setProject(project);
		timesheet.setStaff(staff);
		timesheet.setTask(task);
		timesheet.setTimes(times);
		timesheet.setResults(results);
		timesheet.setNote(note);
		timesheet.setStatus(false);
		ses.save(timesheet);
		return true;
	}

// update
	public boolean updateTimesheet(int idTs, int idProject, int idStaff, String task, String times, boolean results,
			String note, boolean status) {
		Session ses = sessionFactory.getCurrentSession();
		Staff staff = ses.get(Staff.class, idStaff);
		Project project = ses.get(Project.class, idProject);
		Timesheet timesheet = new Timesheet();
		timesheet.setIdTs(idTs);
		timesheet.setProject(project);
		timesheet.setStaff(staff);
		timesheet.setTask(task);
		timesheet.setTimes(times);
		timesheet.setResults(results);
		timesheet.setNote(note);
		timesheet.setStatus(status);
		ses.update(timesheet);
		return true;
	}

//	select count member miss timesheet
	@SuppressWarnings("unchecked")
	public List<Object> countMissTimesheet() {
		Session ses = sessionFactory.getCurrentSession();
		String hql = "select count (ts.idTs) from Timesheet ts where results = 0 ";
		List<Object> list = (List<Object>) ses.createQuery(hql).list();
		return list;
	}

//	select member miss timesheet
	@SuppressWarnings("unchecked")
	public List<Object> listMissTimesheet() {
		Session ses = sessionFactory.getCurrentSession();
		String hql = "select ts.project , ts.staff,ts.times from Timesheet ts where results = 0 ";
		List<Object> list = (List<Object>) ses.createQuery(hql).list();
		return list;
	}
}
