package com.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.Project;
@Transactional
@Repository
public class ProjectDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Project> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Project> list = session.createQuery("from Project").list();
		return list;
	}
	public Project info(int Id) {
		Session session = this.sessionFactory.getCurrentSession();
		Project project = (Project) session.get(Project.class, Id);
		return project;
	}

	public void save(String name) {
		Session session = this.sessionFactory.getCurrentSession();
			Project pro = new Project();
			pro.setName(name);
			session.save(pro);
	}

	public void delete(int Id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(info(Id));
		
	}
	public void update(int id, String name) {
		Session session = this.sessionFactory.getCurrentSession();
		Project pro = new Project();
		pro.setIdProject(id);
		pro.setName(name);
		session.update(pro);
		
		
	}
	
	// đếm menber theo dự án...
	
}
