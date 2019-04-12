package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.StaffDAO;
import com.demo.model.Staff;

@RestController
@RequestMapping(value = "/Staff")
public class StaffController {
	@Autowired
	StaffDAO staff;
	@Autowired(required = true)
	public JavaMailSender emailSender;
	@CrossOrigin
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Staff> get() {
		List<Staff> list = staff.liststaff();
		return list;
	}
	@CrossOrigin
	@RequestMapping(value = "/list1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Object> getcar() {
		List<Object> list = staff.listproject();
		return list;
	}
	@CrossOrigin
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public void delete(@PathVariable("id") int id) {
		staff.deleteStaff(id);
	}
	@CrossOrigin
	@RequestMapping(value = "/tuchoi/{id}", method = RequestMethod.GET)
	public void tuchoi(@PathVariable("id") int id) {
		staff.tuchoi(id);
	}
	@CrossOrigin
	@RequestMapping(value = "/dongy/{id}", method = RequestMethod.GET)
	public void dongy(@PathVariable("id") int id) {
		staff.dongy(id);
	}
	@CrossOrigin
	@RequestMapping(value = "/menber/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Object> menber(@PathVariable("id") int id) {

		List<Object> list = staff.listmenber(id);
		return list;
	}
	@CrossOrigin
	@RequestMapping(value = "/save/{username}/{name}/{email}/{phone}/{avatar}/{addrSky}/{addrFb}/{address}/{levelss}/{major}/{finishs}", method = RequestMethod.GET)
	public void them(@PathVariable("username") String username,

			@PathVariable("name") String names, @PathVariable("email") String email,
			@PathVariable("phone") String phone, @PathVariable("avatar") String avatar,
			@PathVariable("addrSky") String addrSky, @PathVariable("addrFb") String addrFb,
			@PathVariable("address") String address, @PathVariable("levelss") int levelss,
			@PathVariable("major") String major, @PathVariable("finishs") String finishs) {
		// @PathVariable("school") String school) {
		staff.save(username, names, email, phone, avatar, addrSky, addrFb, address, levelss, major, finishs);

	}
	@CrossOrigin
	@RequestMapping(value = "/update/{id}/{Project}/{username}/{roless}/{stutus}/{name}/{email}/{phone}/{avatar}/{addrSky}/{addrFb}/{address}/{levelss}/{major}/{finishs}/{school}", method = RequestMethod.GET)
	public void update(@PathVariable("id") int id, @PathVariable("Project") int Project,
			@PathVariable("username") String username, @PathVariable("roless") int roless,
			@PathVariable("stutus") boolean status, @PathVariable("name") String names,
			@PathVariable("email") String email, @PathVariable("phone") String phone,
			@PathVariable("avatar") String avatar, @PathVariable("addrSky") String addrSky,
			@PathVariable("addrFb") String addrFb, @PathVariable("address") String address,
			@PathVariable("levelss") int levelss, @PathVariable("major") String major,
			@PathVariable("finishs") String finishs, @PathVariable("school") String school) {
		staff.update(id, Project, username, roless, status, names, email, phone, avatar, addrSky, addrFb, address,
				levelss, major, finishs, school);
	}

//	get staff by id
	@CrossOrigin
	@RequestMapping(value = "/getStaffById/{id}", method = RequestMethod.GET)
	public Staff getstaffByid(@PathVariable("id") int id) {
		return staff.info(id);
	}
}
