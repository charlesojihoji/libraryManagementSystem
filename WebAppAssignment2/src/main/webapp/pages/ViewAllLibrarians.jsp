<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
   <head>
      <title>The List Of Librarians Is As Follows</title>
   </head>

   <body>
   <h1>Here is the list of Librarians</h1>
   <ul>
      <c:forEach var="mylist" items="${LibrarianData}">
    
      <li>${mylist.librarianUserName}</li>
	  </c:forEach> 
	  </ul>
   </body>
</html>