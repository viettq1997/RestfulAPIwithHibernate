package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.NewsDAO;
import com.demo.model.News;
import com.demo.model.Staff;

@RestController
@RequestMapping(value = "/New")
public class NewRestController {
	@Autowired
	NewsDAO newsDao;

	@CrossOrigin
	@RequestMapping(value = "/List", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<News> getAllNews() {
		List<News> list = newsDao.getAll();
		return list;
	}

	@CrossOrigin
	@RequestMapping(value = "/List/Top3", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<News> getTopNews() {
		List<News> list = newsDao.getTo3();
		return list;
	}
	@CrossOrigin
	@RequestMapping(value = "/List/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public News getById(@PathVariable("id") int id) {
		News news = newsDao.getById(id);
		return news;
	}
	@CrossOrigin
	@RequestMapping(value = "/Add/{title}/{image}/{dates}/{content}/{staff_id}", method = RequestMethod.GET)
	public List<News> getAdd(@PathVariable("title") String title, @PathVariable("image") String image,
			@PathVariable("dates") String date, @PathVariable("content") String content,
			@PathVariable("staff_id") int staff_id) {
		Staff staff = newsDao.getStaffByiD(staff_id);
		newsDao.addNew(new News(content, date, image, staff, title));
		List<News> list = newsDao.getAll();
		return list;

	}
	@CrossOrigin
	@RequestMapping(value = "/Delete/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<News> deleteById(@PathVariable("id") int id) {
		newsDao.deleteById(id);
		List<News> list = newsDao.getAll();
		return list;
	}
	@CrossOrigin
	@RequestMapping(value = "/Updata/{id}/{staff_id}/{title}/{image}/{dates}/{content}", method = RequestMethod.GET)
	public List<News> updateNew(@PathVariable("id") int id, @PathVariable("title") String title,
			@PathVariable("image") String image, @PathVariable("dates") String date,
			@PathVariable("content") String content, @PathVariable("staff_id") int staff_id) {
		Staff staff = newsDao.getStaffByiD(staff_id);
		newsDao.UpdateNew(new News(id, staff, title, image, date, content));
		List<News> list = newsDao.getAll();
		return list;
	}

}
