package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.BugsDAO;
import com.demo.model.Bugs;

@RestController
@RequestMapping(value = "/bugs")
public class BugsRestController {

	@Autowired
	BugsDAO bugsDAO;

//	get all list bug
	@CrossOrigin
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Bugs> getListBugs() {
		List<Bugs> list = bugsDAO.getListBug();
		return list;
	}

//	delete bug
	@CrossOrigin
	@RequestMapping(value = "/delete/{idBug}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable("idBug") int idBug) {
		bugsDAO.deleteBug(idBug);
	}

//	add bug
	@CrossOrigin
	@RequestMapping(value = "/add/{idStaff}/{names}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void add(@PathVariable("idStaff") int idStaff, @PathVariable("names") String names) {
		bugsDAO.addBug(idStaff, names);
	}

//	update bug
	@CrossOrigin
	@RequestMapping(value = "/update/{idBugs}/{idStaff}/{names}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void update(@PathVariable("idBugs") int idBugs, @PathVariable("idStaff") int idStaff,
			@PathVariable("names") String names) {
		bugsDAO.updateBug(idBugs, idStaff, names);
	}
}
