<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
    <head>
        <title>Customer</title>
    </head>
    <body>
        <div>
            <div>
                <h2>Customer</h2>
            </div>
        </div>

        <div>
            <h3>Save Customer</h3>
            <form:form action="save-customer" modelAttribute="customer" method="POST">
                <form:hidden path="id"/>
                <table>
                    <tbody>
                        <tr>
                            <td><label>First name:</label></td>
                            <td><form:input path="firstName" /></td>
                        </tr>
                        <tr>
                            <td><label>Last name:</label></td>
                            <td><form:input path="lastName" /></td>
                        </tr>
                        <tr>
                            <td><label>Email:</label></td>
                            <td><form:input path="email" /></td>
                        </tr>
                        <tr>
                            <td><label>Phone:</label></td>
                            <td><form:input path="phone" /></td>
                        </tr>
                        <tr>
                            <td><label></label></td>
                            <td><input type="submit" value="Save"/></td>
                        </tr>
                    </tbody>
                </table>
            </form:form>
            <div/>
            <p>
                <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
            </p>
        </div>
    </body>
</html>