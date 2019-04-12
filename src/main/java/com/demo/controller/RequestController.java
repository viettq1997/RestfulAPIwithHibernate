package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.demo.dao.RequestDAO;
import com.demo.model.Request;



@RestController
@RequestMapping(value = "/Request")
public class RequestController {
	@Autowired
	RequestDAO request;
	@CrossOrigin
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Request> getcar() {
		List<Request> list = request.list();
		return list;
	}
	@CrossOrigin
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public void delete(@PathVariable("id") int id) {
		request.delete(id);
	}
	@CrossOrigin
	@RequestMapping(value = "/save/{Staff}/{requesttype}", method = RequestMethod.GET)
	public void them(@PathVariable("Staff") int Staff, @PathVariable("requesttype") int requesttype) {
		 request.save(Staff, requesttype);;
	}
	@CrossOrigin
	@RequestMapping(value = "/update/{id}/{Staff}/{requesttype}/{stutus}", method = RequestMethod.GET)
	public void update(@PathVariable("id") int id,@PathVariable("Staff") int Staff, @PathVariable("requesttype") int requesttype,
			@PathVariable("stutus") boolean status) {
		 request.update(id, Staff, requesttype, status);
	}
	@CrossOrigin
	@RequestMapping(value = "/tuchoi/{id}", method = RequestMethod.GET)
	public void tuchoi(@PathVariable("id") int id) {
		request.tuchoi(id);
	}
	@CrossOrigin
	@RequestMapping(value = "/dongy/{id}", method = RequestMethod.GET)
	public void dongy(@PathVariable("id") int id) {
		request.dongy(id);
	}
}
