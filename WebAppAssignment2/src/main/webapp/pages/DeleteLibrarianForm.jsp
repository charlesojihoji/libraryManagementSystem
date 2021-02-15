<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    <meta charset="ISO-8859-1">
	<title>Delete Librarian Page</title>
    </head>
    <body>
        <h3>Please enter the username of the librarian to be deleted</h3>
        <form:form method="POST" 
          action="/secondDeleteLibrarian" modelAttribute="librarian">
             <table>
                <tr>
                    <td><form:label path="librarianUserName">Librarian Username</form:label></td>
                    <td><form:input path="librarianUserName"/></td><!-- name of property in Librarian.java which will hold data of this text field -->
                </tr>
     
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>