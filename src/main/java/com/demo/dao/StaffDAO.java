package com.demo.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.config.Ramdompass;
import com.demo.model.Project;
import com.demo.model.Staff;

@Transactional
@Repository
public class StaffDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired(required = true)
	public JavaMailSender emailSender;

	@SuppressWarnings("unchecked")
	public List<Staff> liststaff() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Staff> list = session.createQuery("from Staff").list();
		return list;
	}

	public Staff info(int Id) {
		Session session = this.sessionFactory.getCurrentSession();
		Staff staff = (Staff) session.get(Staff.class, Id);
		return staff;
	}

	@SuppressWarnings("static-access")
	public void save(String username, String names, String email, String phone, String avatar, String addrSky,
			String addrFb, String address, int levelss, String major, String finishs) {
		Session session = this.sessionFactory.getCurrentSession();
		Project pro = session.get(Project.class, 1);
		Staff staff = new Staff();
		staff.setProject(pro);
		staff.setUsername(username);
		staff.setRoless(1);
		staff.setStatus(false);
		staff.setNames(names);
		staff.setEmail(email);
		staff.setPhone(phone);
		staff.setAvatar(avatar);
		staff.setAddrSky(addrSky);
		staff.setAddrFb(addrFb);
		staff.setAddress(address);
		staff.setLevelss(levelss);
		staff.setMajor(major);
		staff.setFinishs(finishs);
		SimpleMailMessage message = new SimpleMailMessage();
		Ramdompass a = new Ramdompass();
		String school = a.pass();
		message.setTo(email);
		message.setSubject("Mat khau dang nhap");
		message.setText("mật khau cua ban la:" + school);

		staff.setSchool(school);
		session.save(staff);
		this.emailSender.send(message);
	}

	public void delete(int Id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(info(Id));

	}

//	delete foreign key
	public boolean deleteStaff(int Id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query1 = session.createQuery("delete Reports where staff.idStaff = '" + Id + "'");
		query1.executeUpdate();
		Query query2 = session.createQuery("delete Request where staff.idStaff = '" + Id + "'");
		query2.executeUpdate();
		Query query3 = session.createQuery("delete Commentbugs where staff.idStaff = '" + Id + "'");
		query3.executeUpdate();
		Query query4 = session.createQuery("delete Bugs where staff.idStaff = '" + Id + "'");
		query4.executeUpdate();
		Query query5 = session.createQuery("delete Slide where staff.idStaff = '" + Id + "'");
		query5.executeUpdate();
		Query query6 = session.createQuery("delete News where staff.idStaff = '" + Id + "'");
		query6.executeUpdate();
		Query query7 = session.createQuery("delete Timesheet where staff.idStaff = '" + Id + "'");
		query7.executeUpdate();
		Query query8 = session.createQuery("delete Staff where idStaff = '" + Id + "'");
		query8.executeUpdate();
		return true;
	}

	public void update(int id, int Project, String username, int roless, boolean status, String names, String email,
			String phone, String avatar, String addrSky, String addrFb, String address, int levelss, String major,
			String finishs, String school) {
		Session session = this.sessionFactory.getCurrentSession();
		Project pro = session.get(Project.class, Project);
		Staff staff = new Staff();
		staff.setIdStaff(id);
		staff.setProject(pro);
		staff.setUsername(username);
		staff.setRoless(roless);
		staff.setStatus(status);
		staff.setNames(names);
		staff.setEmail(email);
		staff.setPhone(phone);
		staff.setAvatar(avatar);
		staff.setAddrSky(addrSky);
		staff.setAddrFb(addrFb);
		staff.setAddress(address);
		staff.setLevelss(levelss);
		staff.setMajor(major);
		staff.setFinishs(finishs);
		staff.setSchool(school);
		session.update(staff);
	}

	@SuppressWarnings({ "unchecked" })
	public List<Object> listproject() {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "SELECT r.project.idProject,r.project.name, count(r.idStaff)"
				+ " FROM Staff r  GROUP BY r.project.idProject, r.project.name"
				+ " Having r.project.idProject in (select idProject from Project) ";
//		String sql = "SELECT r.project.name,r.names"
//		+ " FROM Staff r  GROUP BY r.project.idProject, r.project.name,r.names"
//		+ " Having r.project.idProject in (select idProject from Project) ";
		List<Object> listkhen = session.createQuery(sql).list();
		return listkhen;
	}

	public boolean tuchoi(int id) {
		Session ses = sessionFactory.getCurrentSession();
		Query query = ses.createQuery("update Staff set status = false where idStaff = '" + id + "'");
		query.executeUpdate();
		return true;
	}

	public boolean dongy(int id) {
		Session ses = sessionFactory.getCurrentSession();
		Query query = (Query) ses.createQuery("update Staff set status = true where idStaff = '" + id + "'");
		query.executeUpdate();
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Object> listmenber(int id) {
		Session session = this.sessionFactory.getCurrentSession();
//		String sql = "SELECT r.project.name, count(r.idStaff)"
//				+ " FROM Staff r  GROUP BY r.project.idProject, r.project.name"
//				+ " Having r.project.idProject in (select idProject from Project) ";
		String sql = "SELECT r.project.name,r.names"
				+ " FROM Staff r  GROUP BY r.project.idProject, r.project.name,r.names"
				+ " Having r.project.idProject = '" + id + "' ";
		List<Object> listkhen = session.createQuery(sql).list();
		return listkhen;
	}

}
