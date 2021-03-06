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
 * News generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "NEWS", schema = "c##nguyenquan")
public class News implements java.io.Serializable {

	private int idNew;
	private Staff staff;
	private String title;
	private String image;
	private String dates;
	private String contentt;

	public News() {
	}

	public News(String contentt, String dates, String image, Staff staff, String title) {
		super();
		this.staff = staff;
		this.title = title;
		this.image = image;
		this.dates = dates;
		this.contentt = contentt;
	}

	public News(int idNew, Staff staff, String title, String dates) {
		this.idNew = idNew;
		this.staff = staff;
		this.title = title;
		this.dates = dates;
	}

	public News(int idNew, Staff staff, String title, String image, String dates, String contentt) {
		this.idNew = idNew;
		this.staff = staff;
		this.title = title;
		this.image = image;
		this.dates = dates;
		this.contentt = contentt;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "news_seq")
	@SequenceGenerator(name = "news_seq", sequenceName = "news_seq")
	@Column(name = "ID_NEW", unique = true, nullable = false, precision = 22, scale = 0)
	public int getIdNew() {
		return this.idNew;
	}

	public void setIdNew(int idNew) {
		this.idNew = idNew;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_STAFF", nullable = false)
	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	@Column(name = "TITLE", nullable = false, length = 225)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "IMAGE", length = 225)
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "DATES", nullable = false, length = 225)
	public String getDates() {
		return this.dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	@Column(name = "CONTENTT", length = 225)
	public String getContentt() {
		return this.contentt;
	}

	public void setContentt(String contentt) {
		this.contentt = contentt;
	}

}
