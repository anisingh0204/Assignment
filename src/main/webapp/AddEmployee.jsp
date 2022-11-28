<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <div>
    	<form action="insert" method="post">
	        <table>
	            <tr>
	                <td>Employee ID:</td>
	                <td><input type="text" name="id"></td>
	            </tr>
	            <tr>
	                <td>Employpee Name:</td>
	                <td><input type="text" name="name"></td>
	            </tr>
	            <tr>
	                <td>Year Of Experience:</td>
	                <td><input type="number" name="exp"></td>
	            </tr>
	            <tr>
	                <td>Designation:</td>
	                <td><input type="text" name="degn"></td>
	            </tr>
	            <tr>
	                <td colspan="2"><input type="submit" value="ADD"></td>
	            </tr>
	        </table>
        </form>
    </div>
</body>
</html>