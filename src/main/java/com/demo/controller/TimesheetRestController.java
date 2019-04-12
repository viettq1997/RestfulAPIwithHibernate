package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.TimesheetDAO;
import com.demo.model.Timesheet;

@RestController
@RequestMapping("/timesheet")
public class TimesheetRestController {

	@Autowired
	TimesheetDAO timesheetDAO;

// 	get all list
	@CrossOrigin
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Timesheet> getAllNews() {
		List<Timesheet> list = timesheetDAO.getAllReportList();
		return list;
	}

// 	delete
	@CrossOrigin
	@RequestMapping(value = "/delete/{idTimesheet}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteReport(@PathVariable("idTimesheet") int idTimesheet) {
		timesheetDAO.deleteTimeSheet(idTimesheet);
	}

//	get by id
	@CrossOrigin
	@RequestMapping(value = "/getTimesheetById/{idTimesheet}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Timesheet getReportsById(@PathVariable("idTimesheet") int idTimesheet) {
		return timesheetDAO.getTimeSheetById(idTimesheet);
	}

//	add
	@CrossOrigin
	@RequestMapping(value = "/add/{idProject}/{idStaff}/{task}/{times}/{results}/{note}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addReports(@PathVariable("idStaff") int idStaff, @PathVariable("idProject") int idProject,
			@PathVariable("task") String task, @PathVariable("times") String times,
			@PathVariable("results") boolean results, @PathVariable("note") String note) {
		timesheetDAO.addTimesheet(idProject, idStaff, task, times, results, note);
	}

//	update
	@CrossOrigin
	@RequestMapping(value = "/update/{idTs}/{idProject}/{idStaff}/{task}/{times}/{results}/{note}/{status}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateReports(@PathVariable("idTs") int idTs, @PathVariable("idStaff") int idStaff,
			@PathVariable("idProject") int idProject, @PathVariable("task") String task,
			@PathVariable("times") String times, @PathVariable("results") boolean results,
			@PathVariable("note") String note, @PathVariable("status") boolean status) {
		timesheetDAO.updateTimesheet(idTs, idProject, idStaff, task, times, results, note, status);
	}

//	count member miss timesheet
	@CrossOrigin
	@RequestMapping(value = "/countmisstimesheet", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Object> memMissTS() {
		return timesheetDAO.countMissTimesheet();
	}
//	list member miss timesheet
	@CrossOrigin
	@RequestMapping(value = "/listmisstimesheet", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Object> listMemMissTS() {
		return timesheetDAO.listMissTimesheet();
	}
}
