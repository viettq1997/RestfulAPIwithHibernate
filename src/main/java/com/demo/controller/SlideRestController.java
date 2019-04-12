package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.dao.*;
import com.demo.model.*;

@RestController
@RequestMapping(value = "/slide")
public class SlideRestController {

	@Autowired
	SlideDAO slidesDao;
	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Slide> getAllSlide() {
		List<Slide> list = slidesDao.getAllSlideList();
		return list;
	}
	@CrossOrigin
	@RequestMapping(value = "/delete/{idSlide}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Slide> deleteSlide(@PathVariable("idSlide") int idSlide) {
		slidesDao.deleteSlide(idSlide);
		List<Slide> list = slidesDao.getAllSlideList();
		return list;

	}
	@CrossOrigin
	@RequestMapping(value = "/getSlideById/{idSlide}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Slide getSlideById(@PathVariable("idSlide") int idSlide) {
		Slide slides = slidesDao.getSlideById(idSlide);
		return slides;
	}
	@CrossOrigin
	@RequestMapping(value = "/addSlide/{contentt}/{image}/{staff}", method = RequestMethod.GET)
	public List<Slide> getAddSlide(@PathVariable("image") String image, @PathVariable("contentt") String contentt,
			@PathVariable("staff") int idStaff) {
		System.out.println("==" + idStaff);
		System.out.println("==" + contentt);
		System.out.println("==" + image);
		Staff staff = slidesDao.getStaffById(idStaff);
		slidesDao.addSlide(new Slide(contentt, image, staff));
		List<Slide> list = slidesDao.getAllSlideList();
		return list;
	}
	@CrossOrigin
	@RequestMapping(value = "updateSlide/{idSlide}/{staff}/{image}/{contentt}", method = RequestMethod.GET)
	public List<Slide> updatSlides(@PathVariable("idSlide") int idSlide, @PathVariable("image") String image,
			@PathVariable("contentt") String contentt, @PathVariable("staff") int idStaff) {
		Staff staff = slidesDao.getStaffById(idStaff);
		slidesDao.updateSlide(new Slide(idSlide, staff, image, contentt));
		List<Slide> list = slidesDao.getAllSlideList();
		return list;

	}

}
