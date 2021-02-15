<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
	<meta charset="ISO-8859-1">
	<title>Add Librarian Page</title>
    </head>
    <body>
        <h3>Please add the new librarian</h3>
        <form:form method="POST" 
          action="/secondAddLibrarian" modelAttribute="librarian">
             <table>
                <tr>
                    <td><form:label path="librarianUserName">Librarian Username</form:label></td>
                    <td><form:input path="librarianUserName"/></td><!-- name of property in Librarian.java which will hold data of this text field -->
                </tr>
                <tr>
                    <td><form:label path="librarianPassword">Password</form:label></td>
                    <td><form:input path="librarianPassword"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>