<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    <meta charset="ISO-8859-1">
	<title>View Book Page</title>
    </head>
    <body>
        <h3>Please enter the ID of the book you want to view</h3>
        <form:form method="POST" 
          action="/secondViewBook" modelAttribute="book">
             <table>
                <tr>
                    <td><form:label path="bookId">The Book's ID</form:label></td>
                    <td><form:input path="bookId"/></td><!-- name of property in Book.java which will hold data of this text field -->
                </tr>
     
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>