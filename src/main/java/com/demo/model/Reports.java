package com.demo.model;
// Generated Mar 2, 2019 4:10:03 PM by Hibernate Tools 5.1.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Reports generated by hbm2java
 */
@SuppressWarnings({ "serial" })
@Entity
@Table(name = "REPORTS", schema = "c##nguyenquan")
public class Reports implements java.io.Serializable {

	private int idReport;
	private Project project;
	private Staff staff;
	private String calendarEffort;
	private String reportEffort;
	private String aprprovedEffort;

	public Reports() {
	}

	
	public Reports(Project project, Staff staff, String calendarEffort, String reportEffort,
			String aprprovedEffort) {
		super();
		this.project = project;
		this.staff = staff;
		this.calendarEffort = calendarEffort;
		this.reportEffort = reportEffort;
		this.aprprovedEffort = aprprovedEffort;
	}
//	public Reports(int idReport, Project project) {
//		this.idReport = idReport;
//		this.project = project;
//	}

	public Reports(int idReport, Project project, Staff staff, String calendarEffort, String reportEffort,
			String aprprovedEffort) {
		super();
		this.idReport = idReport;
		this.project = project;
		this.staff = staff;
		this.calendarEffort = calendarEffort;
		this.reportEffort = reportEffort;
		this.aprprovedEffort = aprprovedEffort;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "report_seq")
	@SequenceGenerator(name = "report_seq", sequenceName = "report_seq")
	@Column(name = "ID_REPORT", unique = true, nullable = false, precision = 22, scale = 0)
	public int getIdReport() {
		return this.idReport;
	}

	public void setIdReport(int idReport) {
		this.idReport = idReport;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_PROJECT", nullable = false)
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_STAFF", nullable = false)
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	@Column(name = "CALENDAR_EFFORT", length = 225)
	public String getCalendarEffort() {
		return this.calendarEffort;
	}

	public void setCalendarEffort(String calendarEffort) {
		this.calendarEffort = calendarEffort;
	}

	@Column(name = "REPORT_EFFORT", length = 225)
	public String getReportEffort() {
		return this.reportEffort;
	}

	public void setReportEffort(String reportEffort) {
		this.reportEffort = reportEffort;
	}

	@Column(name = "APRPROVED_EFFORT", length = 225)
	public String getAprprovedEffort() {
		return this.aprprovedEffort;
	}

	public void setAprprovedEffort(String aprprovedEffort) {
		this.aprprovedEffort = aprprovedEffort;
	}

}
