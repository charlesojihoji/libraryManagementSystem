package com.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="AdminTable")
public class Admin {

	private String adminUserName;
	private String adminPassword;
	private List<Librarian> librarianList;
	
	@Id
	public String getAdminUserName() {
		return adminUserName;
	}
	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	//@OneToMany(mappedBy="admin")
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="adminUserName")
	public List<Librarian> getLibrarianList() {
		return librarianList;
	}
	public void setLibrarianList(List<Librarian> librarianList) {
		this.librarianList = librarianList;
	}

}
