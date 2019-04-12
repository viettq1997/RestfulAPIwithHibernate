package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.SecutityDao;
import com.demo.model.Staff;

@RestController
public class LoginController {
	@Autowired
	SecutityDao secutityDao;
	

	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="User/checkLogIn2", method= RequestMethod.GET)
	public String checkLogin2(@RequestParam("userName") String userName , @RequestParam("passWord") String passWord)
	{
		return secutityDao.checkLogin2(userName, passWord);
	}
	@CrossOrigin
	@RequestMapping(value = "/User/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Staff getById(@PathVariable("id") int id) {
		Staff staff = secutityDao.getById(id);
		return staff;
	}
	
	

}
