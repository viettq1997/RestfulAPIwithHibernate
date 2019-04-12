package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.ReportDAO;
import com.demo.model.Reports;

@RestController
@RequestMapping(value = "/reports")
public class ReportsRestController {
	@Autowired
	ReportDAO reportsDAO;

//	get all list
	@CrossOrigin
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Reports> getAllNews() {
		List<Reports> list = reportsDAO.getAllReportList();
		return list;
	}

// 	delete
	@CrossOrigin
	@RequestMapping(value = "/delete/{idReports}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteReport(@PathVariable("idReports") int idReports) {
		reportsDAO.deleteReport(idReports);
	}

//	get by id
	@CrossOrigin
	@RequestMapping(value = "/getReportsById/{idReports}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reports getReportsById(@PathVariable("idReports") int idReports) {
		return reportsDAO.getReportsById(idReports);
	}

//	add
	@CrossOrigin
	@RequestMapping(value = "/add/{idProject}/{idStaff}/{calendarEffort}/{reportEffort}/{approvedEffort}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addReports(@PathVariable("idProject") int idProject,
			@PathVariable("idStaff") int idStaff, @PathVariable("calendarEffort") String calendarEffort,
			@PathVariable("reportEffort") String reportEffort, @PathVariable("approvedEffort") String approvedEffort) {
		reportsDAO.addReports(idProject, idStaff, calendarEffort, reportEffort, approvedEffort);
	}

//	add object report
//	@CrossOrigin("http://localhost:8080")
//	@PostMapping(value = "/add")
//	public void addReports(@RequestBody Reports reports) {
//		reportsDAO.addReports(reports);
//	}

//	update
	@CrossOrigin
	@RequestMapping(value = "/update/{idReport}/{idProject}/{idStaff}/{calendarEffort}/{reportEffort}/{approvedEffort}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateReports(@PathVariable("idReport") int idReport, @PathVariable("idProject") int idProject, @PathVariable("idStaff") int idStaff,
			@PathVariable("calendarEffort") String calendarEffort, @PathVariable("reportEffort") String reportEffort,
			@PathVariable("approvedEffort") String approvedEffort) {
		reportsDAO.updateReports(idReport, idProject, idStaff, calendarEffort, reportEffort, approvedEffort);
	}

//	@RequestMapping(value = "/listBya/{aa}")
//	public List<Reports> updatReports(@PathVariable("aa") String aa) {
//		List<Reports> list = reportsDAO.getAllReportListBya(aa);
//		return list;
//	}
}
