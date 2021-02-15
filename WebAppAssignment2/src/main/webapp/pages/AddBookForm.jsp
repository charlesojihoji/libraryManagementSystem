<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
	<meta charset="ISO-8859-1">
	<title>Add Book Page</title>
    </head>
    <body>
        <h3>Please add the new book</h3>
        <form:form method="POST" 
          action="/secondAddBook" modelAttribute="book">
             <table>
                <tr>
                    <td><form:label path="bookId">Book ID</form:label></td>
                    <td><form:input path="bookId"/></td><!-- name of property in Book.java which will hold data of this text field -->
                </tr>
                <tr>
                    <td><form:label path="bookName">The Book's Name</form:label></td>
                    <td><form:input path="bookName"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>