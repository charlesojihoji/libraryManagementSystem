<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
   <head>
      <title>The List Of Books Is As Follows</title>
   </head>

   <body>
   <h1>Here is the list of Books</h1>
   <ul>
      <c:forEach var="mylist" items="${BookData}">
    
      <li>${mylist.bookName}</li>
	  </c:forEach> 
	  </ul>
   </body>
</html>