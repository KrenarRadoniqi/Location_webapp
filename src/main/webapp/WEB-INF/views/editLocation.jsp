<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.locationsweb.util.Mappings"%>

<html>
<head>
    <title>Edit Location</title>
</head>
<body>
<table border="1" cellpadding="10">
    <form action="updateloc" method="POST">
        <tr>
            <td>ID:</td>
            <td><input type="text" name="id" value="${location.id}" readonly/></td>
        </tr>

        <tr>
            <td>Code:</td>
            <td><input type="text" name="code" value="${location.code}" readonly/></td>
        </tr>
        <tr>
            <td>Name: </td>
            <td><input type="text" name="name" value="${location.name}"/></td>
        </tr>
        <tr>
            <td>Type:</td>
            <td>Type: Urban<input type="radio" name="type" value="URBAN" ${location.type=='URBAN'?'checked':''}/>
                Rural<input type="radio" name="type" value="RURAL" ${location.type=='RURAL'?'checked':''}/></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="Save"></td>
        </tr>
        <tr>
            <td colspan="2">${msg}</td>
        </tr>
        <tr>
            <td><a href="displayLocations">View All Locations</a></td>
        </tr>
    </form>
</table>
</body>
</html>