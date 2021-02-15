<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
	<meta charset="ISO-8859-1">
	<title>Admin Login Page</title>
    </head>
    <body>
        <h3>Welcome Admin.</h3>
        <h3>Please log in</h3>
        <form:form method="POST" 
          action="/adminLogin" modelAttribute="admin">
             <table>
                <tr>
                    <td><form:label path="adminUserName">Admin Username</form:label></td>
                    <td><form:input path="adminUserName"/></td><!-- name of property in Admin.java which will hold data of this text field -->
                </tr>
                <tr>
                    <td><form:label path="adminPassword">Password</form:label></td>
                    <td><form:input path="adminPassword"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>