<html>
<head>
    <title>Create Location</title>
</head>
<body>
<table border="1" cellpadding="10">
    <form action="saveloc" method="POST">
        <tr>
            <td>Code:</td>
            <td><input type="text" name="code"/></td>
        </tr>
        <tr>
            <td>Name: </td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>Type:</td>
            <td>Type: Urban<input type="radio" name="type" value="URBAN"/>
                Rural<input type="radio" name="type" value="RURAL"/></td>
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