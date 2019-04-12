package com.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.Project;
import com.demo.model.Reports;
import com.demo.model.Staff;

@Transactional
@Repository
public class ReportDAO {
	@Autowired
	private SessionFactory sessionFactory;
//	get all list
	@SuppressWarnings("unchecked")
	public List<Reports> getAllReportList() {
		Session ses = sessionFactory.getCurrentSession();
		List<Reports> list = ses.createQuery("From Reports").list();
		return list;
	}
//	delete
	public boolean deleteReport(int idReports) {
		Session ses = sessionFactory.getCurrentSession();
		Reports delete = ses.get(Reports.class, idReports);
		ses.delete(delete);
		return true;
	}
// 	get by id
	public Reports getReportsById(int idReports) {
		Session ses = sessionFactory.getCurrentSession();
		Reports reports = ses.get(Reports.class, idReports);
		return reports;
	}
//	add
	public boolean addReports(int idProject,int idStaff, String calendarEffort, String reportEffort,
			String approvedEffort) {
		Session ses = sessionFactory.getCurrentSession();
		Project project = ses.get(Project.class, idProject);
		Staff staff = ses.get(Staff.class, idStaff);
		Reports reports = new Reports();
		reports.setProject(project);
		reports.setStaff(staff);
		reports.setCalendarEffort(calendarEffort);
		reports.setReportEffort(reportEffort);
		reports.setAprprovedEffort(approvedEffort);
		ses.save(reports);
		return true;
	}

//	add object
//	public boolean addReports(Reports reports) {
//		Session ses = sessionFactory.getCurrentSession();
//		ses.save(reports);
//		return true;
//	}
// update 
	public boolean updateReports(int idReport, int idProject,int idStaff, String calendarEffort, String reportEffort,
			String approvedEffort) {
		Session ses = sessionFactory.getCurrentSession();
		Project project = ses.get(Project.class, idProject);
		Staff staff = ses.get(Staff.class, idStaff);
		Reports reports = new Reports();
		reports.setIdReport(idReport);
		reports.setProject(project);
		reports.setStaff(staff);
		reports.setCalendarEffort(calendarEffort);
		reports.setReportEffort(reportEffort);
		reports.setAprprovedEffort(approvedEffort);
		ses.update(reports);
		return true;
	}

//	@SuppressWarnings("unchecked")
//	public List<Reports> getAllReportListBya(String calendarEffort) {
//		Session ses = sessionFactory.getCurrentSession();
//		Query query = ses.createQuery("From Reports where calendarEffort = :calendarEffort");.
//		query.setParameter("calendarEffort", calendarEffort);
//		List<Reports> list = query.getResultList();
//		return list;
//	}

}
