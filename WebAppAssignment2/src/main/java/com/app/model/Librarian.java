package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="LibrarianTable")
public class Librarian {

	private String librarianUserName;
	private String librarianPassword;
	private Admin admin;
	private List<Book> bookList;
	
	@Id
	public String getLibrarianUserName() {
		return librarianUserName;
	}
	public void setLibrarianUserName(String librarianUserName) {
		this.librarianUserName = librarianUserName;
	}
	
	public String getLibrarianPassword() {
		return librarianPassword;
	}
	public void setLibrarianPassword(String librarianPassword) {
		this.librarianPassword = librarianPassword;
	}
	
	/*@ManyToOne
	@JoinColumn(name="Admin_Username")
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}*/

	@OneToMany(mappedBy="bookLibrarian")
	public List<Book> getBookList() {
		return bookList;
	}
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
}
