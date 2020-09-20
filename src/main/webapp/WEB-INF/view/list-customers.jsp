<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
    <head>
        <title>Customers base</title>

    </head>

    <body>
        <div>
            <div>
                <h2>Customers base</h2>
            </div>
        </div>

        <div>
            <div>
                <input type="button" value="Add new"
                    onclick="window.location.href='new'; return false;"
                />
                <table border="1">
                    <tr>
                        <th>Last name</th>
                        <th>First name</th>
                        <th>Phone</th>
                        <th>Email</th>
                        <th>Action</th>
                    </tr>

                    <c:forEach var="customer" items="${customers}">
                        <c:url var="updateLink" value="/customers/${customer.id}/edit">
                        </c:url>
                        <c:url var="deleteLink" value="/customers/${customer.id}/delete">
                        </c:url>
                        <tr>
                            <td>${customer.lastName}</td>
                            <td>${customer.firstName}</td>
                            <td>${customer.phone}</td>
                            <td>${customer.email}</td>

                            <td>
                                <a href="${updateLink}">Update</a>
                                |
                                <a href="${deleteLink}"
                                    onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>