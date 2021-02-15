package com.app.controller;

import com.app.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {
	
	 @Autowired
	 AdminRepository adminrep;
	
	 @Autowired
	 LibrarianRepository librarianrep;
	 
	 @Autowired
	 BookRepository bookrep;
	 
	 @RequestMapping(value = "/welcome", method = RequestMethod.GET)
	 public String showForm() {
	        return "WelcomePage";
	 }
	 
	 @RequestMapping(value = "/admin", method = RequestMethod.GET)
	 public ModelAndView showAdminLogin() {
    	return new ModelAndView("AdminLoginForm", "admin", new Admin());
	 }
	 
	 @RequestMapping(value = "/firstViewAllLibrarians", method = RequestMethod.GET)
	 public ModelAndView getLibList() {
		 
		 List<Librarian> librarianList = librarianrep.findAll();
		 
		 return new ModelAndView("ViewAllLibrarians", "LibrarianData", librarianList);
	 }
	 
	 @RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
	 public String submit(@ModelAttribute("admin")Admin admin, BindingResult result, ModelMap model)
	 {
        if (result.hasErrors()) {
            return "AdminLoginError";
        }
        System.out.println("Data saved");
        adminrep.save(admin);
        
        if((admin.getAdminUserName()).equals("Admin") && (admin.getAdminPassword()).equals("Admin")) {
        	return "SuccessfulAdminLogin";
        }
        
        return "AdminLoginError";
	 }
	 
	 @RequestMapping(value = "/firstAddLibrarian", method = RequestMethod.GET)
	 public ModelAndView addLibrarian() {
    	return new ModelAndView("AddLibrarianForm", "librarian", new Librarian());
	 }
	 
	 
	 @RequestMapping(value = "/secondAddLibrarian", method = RequestMethod.POST)
	 public String addLibrarian(@ModelAttribute("librarian")Librarian librarian, BindingResult result, ModelMap model)
	 {
        if (result.hasErrors()) {
            return "GeneralError";
        }
        System.out.println("Data saved");
        librarianrep.save(librarian);
        model.addAttribute("librarianUN", librarian.getLibrarianUserName());
        model.addAttribute("librarianPWD", librarian.getLibrarianPassword());
        return "AddedLibrarianData";
	 }
	 
	 @RequestMapping(value = "/firstViewLibrarian", method = RequestMethod.GET)
	 public ModelAndView viewLibrarian() {
    	return new ModelAndView("ViewLibrarianForm", "librarian", new Librarian());
	 }
	 
	 @RequestMapping(value = "/secondViewLibrarian", method = RequestMethod.POST)
	 public String viewLibrarian(@ModelAttribute("librarian")Librarian librarian, BindingResult result, ModelMap model)
	 {
        if (result.hasErrors()) {
            return "GeneralError";
        }
        
        Optional<Librarian> lib = librarianrep.findById(librarian.getLibrarianUserName());
        System.out.println("The value of lib is " + lib.isEmpty());
        
        if(lib.isEmpty()) 
        {	
        	return "GeneralError";
        }
        else {
        	Librarian librarian2 = lib.get(); //the get() method fully retrieves the lib object
        	model.addAttribute("librarianUN", librarian2.getLibrarianUserName());
            model.addAttribute("librarianPWD", librarian2.getLibrarianPassword());
        	return "ViewLibrarianData";
        }
        
	 }
	 
	 @RequestMapping(value = "/firstDeleteLibrarian", method = RequestMethod.GET)
	 public ModelAndView deleteLibrarian() {
    	return new ModelAndView("DeleteLibrarianForm", "librarian", new Librarian());
	 }
	 
	 @RequestMapping(value = "/secondDeleteLibrarian", method = RequestMethod.POST)
	 public String deleteLibrarian(@ModelAttribute("librarian")Librarian librarian, BindingResult result, ModelMap model)
	 {
        if (result.hasErrors()) {
            return "GeneralError";
        }
        
        Optional<Librarian> lib = librarianrep.findById(librarian.getLibrarianUserName());
        System.out.println("The value of lib is " + lib.isEmpty());
        
        if(lib.isEmpty()) 
        {	
        	return "GeneralError";
        }
        
        else {
        	System.out.println("This librarian has been deleted.");
        	model.addAttribute("librarianUN", librarian.getLibrarianUserName());
        	librarianrep.deleteById(librarian.getLibrarianUserName());
        	return "DeletedLibrarianData";
        }

	 }
	 
	 @RequestMapping(value = "/librarian", method = RequestMethod.GET)
	 public ModelAndView showLibrarianLogin() {
    	return new ModelAndView("LibrarianLoginForm", "librarian", new Librarian());
	 }
	 
	 @RequestMapping(value = "/librarianLogin", method = RequestMethod.POST)
	 public String librarianSubmit(@ModelAttribute("librarian")Librarian librarian, BindingResult result, ModelMap model)
	 {
        if (result.hasErrors()) {
            return "GeneralError";
        }
        
        List<Librarian> librarianList = librarianrep.findAll();
        
        for(int i = 0; i < librarianList.size(); i++) {
	        if((librarian.getLibrarianUserName()).equals((librarianList.get(i)).getLibrarianUserName()) && (librarian.getLibrarianPassword()).equals((librarianList.get(i)).getLibrarianPassword())) {
	        	return "SuccessfulLibrarianLogin";
	        }
        }
        
        return "GeneralError";
	 }
	 

	 @RequestMapping(value = "/firstViewAllBooks", method = RequestMethod.GET)
	 public ModelAndView getBookList() {
		 
		 List<Book> BookList = bookrep.findAll();
		 
		 return new ModelAndView("ViewAllBooks", "BookData", BookList);
	 }
	 
	 @RequestMapping(value = "/firstAddBook", method = RequestMethod.GET)
	 public ModelAndView addBook() {
    	return new ModelAndView("AddBookForm", "book", new Book());
	 }
	 
	 
	 @RequestMapping(value = "/secondAddBook", method = RequestMethod.POST)
	 public String addLibrarian(@ModelAttribute("book")Book book, BindingResult result, ModelMap model)
	 {
        if (result.hasErrors()) {
            return "GeneralError";
        }
        System.out.println("Data saved");
        bookrep.save(book);
        model.addAttribute("bookId", book.getBookId());
        model.addAttribute("bookName", book.getBookName());
        return "AddedBookData";
	 }
	 
	 @RequestMapping(value = "/firstViewBook", method = RequestMethod.GET)
	 public ModelAndView viewBook() {
    	return new ModelAndView("ViewBookForm", "book", new Book());
	 }
	 
	 @RequestMapping(value = "/secondViewBook", method = RequestMethod.POST)
	 public String viewLibrarian(@ModelAttribute("book")Book book, BindingResult result, ModelMap model)
	 {
        if (result.hasErrors()) {
            return "GeneralError";
        }
        
        Optional<Book> bk = bookrep.findById(book.getBookId());
        System.out.println("The value of bk is " + bk.isEmpty());
        
        if(bk.isEmpty()) 
        {	
        	return "GeneralError";
        }
        else {
        	Book book2 = bk.get(); //the get() method fully retrieves the bk object
        	model.addAttribute("bookId", book2.getBookId());
            model.addAttribute("bookName", book2.getBookName());
        	return "ViewBookData";
        }
        
	 }
	 
	 @RequestMapping(value = "/firstDeleteBook", method = RequestMethod.GET)
	 public ModelAndView deleteBook() {
    	return new ModelAndView("DeleteBookForm", "book", new Book());
	 }
	 
	 @RequestMapping(value = "/secondDeleteBook", method = RequestMethod.POST)
	 public String deleteLibrarian(@ModelAttribute("book")Book book, BindingResult result, ModelMap model)
	 {
        if (result.hasErrors()) {
            return "GeneralError";
        }
        
        Optional<Book> bk = bookrep.findById(book.getBookId());
        System.out.println("The value of bk is " + bk.isEmpty());
        
        if(bk.isEmpty()) 
        {	
        	return "GeneralError";
        }
        
        else {
        	System.out.println("This book has been deleted.");
        	model.addAttribute("bookId", book.getBookId());
        	bookrep.deleteById(book.getBookId());
        	return "DeletedBookData";
        }

	 }
	 
}

