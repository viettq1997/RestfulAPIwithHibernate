package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.ProjectDAO;
import com.demo.model.Project;

@RestController
@RequestMapping(value="Project")
public class ProjectController {
	@Autowired
	ProjectDAO pro;
	@CrossOrigin
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Project> getproject() {
		List<Project> list = pro.list();
		return list;
	}
	@CrossOrigin
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public void delete(@PathVariable("id") int id) {
		pro.delete(id);
	}
	@CrossOrigin
	@RequestMapping(value = "/save/{name}", method = RequestMethod.GET)
	public void them(@PathVariable("name") String name) {
		pro.save(name);
	}
	@CrossOrigin
	@RequestMapping(value = "/update/{id}/{name}", method = RequestMethod.GET)
	public void update(@PathVariable("id") int id,@PathVariable("name") String name) {
		pro.update(id, name);
	}
	@CrossOrigin
	@RequestMapping(value = "/getByid/{Id}", method = RequestMethod.GET)
	public void getByid(@PathVariable("Id") int Id) {
		pro.info(Id);
	}
}
