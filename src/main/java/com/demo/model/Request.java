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
 * Request generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "REQUEST", schema = "c##nguyenquan")
public class Request implements java.io.Serializable {

	private int idRequest;
	private Staff staff;
	private int requestType;
	private boolean status;

	public Request() {
	}

	public Request(int idRequest, Staff staff, int requestType, boolean status) {
		this.idRequest = idRequest;
		this.staff = staff;
		this.requestType = requestType;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "request_seq")
	@SequenceGenerator(name = "request_seq", sequenceName = "request_seq")
	@Column(name = "ID_REQUEST", unique = true, nullable = false, precision = 22, scale = 0)
	public int getIdRequest() {
		return this.idRequest;
	}

	public void setIdRequest(int idRequest) {
		this.idRequest = idRequest;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_STAFF", nullable = false)
	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	@Column(name = "REQUEST_TYPE", nullable = false, precision = 22, scale = 0)
	public int getRequestType() {
		return this.requestType;
	}

	public void setRequestType(int requestType) {
		this.requestType = requestType;
	}

	@Column(name = "STATUS", nullable = false, precision = 1, scale = 0)
	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
