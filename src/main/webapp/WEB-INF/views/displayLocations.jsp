<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.locationsweb.util.Mappings"%>

<html>
<head>
    <title>Create Location</title>
</head>
<body>
<h1>Locations</h1>
<table border="1" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>Code</th>
        <th>Name</th>
        <th>Type</th>
    </tr>
    <c:forEach items="${locations}" var="location">
        <c:url var="editUrl" value="${Mappings.EDIT_LOCATION}">
            <c:param name="id" value="${location.id}"/>
        </c:url>
        <c:url var="deleteUrl" value="${Mappings.DELETE_LOCATION}">
            <c:param name="id" value="${location.id}"/>
        </c:url>

        <tr>
            <td>${location.id}</td>
            <td>${location.code}</td>
            <td>${location.name}</td>
            <td>${location.type}</td>
            <td><a href="${editUrl}">Edit</a> </td>
            <td><a href="${deleteUrl}">Delete</a> </td>
        </tr>
    </c:forEach>
    <tr>
        <td><a href="showCreate">Create New Location</a></td>
    </tr>
</table>
</body>
</html>