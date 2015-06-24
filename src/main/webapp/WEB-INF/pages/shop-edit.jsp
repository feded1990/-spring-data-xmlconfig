<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Edit Shop page</title>
</head>
<body>
<h1>Edit Shop page</h1>
<form:form method="POST" commandName="shop" action="${pageContext.request.contextPath}/shop/edit/${shop.id}.html" >
    <table>
        <tbody>
            <tr>
                <td>Shop name:</td>
                <td><form:input path="name" /></td>
                <td><form:errors path="name" cssStyle="color: red;"/></td>
            </tr>
            <tr>
                <td>Employee id:</td>
                <td><form:input path="employee.id" readonly="readonly" /></td>
                <td><form:errors path="employee.id" cssStyle="color: red;"/></td>
            </tr>
            <tr>
                <td>Employee name:</td>
                <td><form:input path="employee.name" /></td>
                <td><form:errors path="employee.name" cssStyle="color: red;"/></td>
            </tr>
            <tr>
                <td>Employee last name:</td>
                <td><form:input path="employee.lastName" /></td>
                <td><form:errors path="employee.lastName" cssStyle="color: red;"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Update" /></td>
                <td></td>
                <td></td>
            </tr>
        </tbody>
    </table>
</form:form>
<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html>