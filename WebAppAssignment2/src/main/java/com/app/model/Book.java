package com.app.model;

import javax.persistence.*;

@Entity
@Table(name="TheBookTable")
public class Book {

	private int bookId;
	private String bookName;
	private Librarian bookLibrarian;
	
	@Id
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	@ManyToOne
	@JoinColumn(name="Librarian_Username")
	public Librarian getBookLibrarian() {
		return bookLibrarian;
	}
	public void setBookLibrarian(Librarian bookLibrarian) {
		this.bookLibrarian = bookLibrarian;
	}	
	
}
