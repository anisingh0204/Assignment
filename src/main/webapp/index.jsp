<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import = "java.util.ArrayList" %>
<%@page import = "bo.Employee" %>
<%@page import = "javax.servlet.RequestDispatcher" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
    body {
  background-image: url('https://img.freepik.com/free-photo/maple-leaf-border-background-orange-watercolor-autumn-season_53876-128735.jpg?w=2000');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
   
}
    .styled-table {
    border-collapse: collapse;
    margin: 20px 170px;
    margin-top:150px;
    font-size: 1.6em;
    font-family: sans-serif;
    min-width: 500px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}
.styled-table thead tr {
    background-color: #009879;
    color: #ffffff;
    text-align: left;
}
.styled-table th,
.styled-table td {
    padding: 12px 15px;
}
.styled-table tbody tr {
    border-bottom: 1px solid #dddddd;
}

.styled-table tbody tr:nth-of-type(even) {
    background-color: #f3f3f3;
}

.styled-table tbody tr:last-of-type {
    border-bottom: 2px solid #009879;
}
.styled-table tbody tr.active-row {
    font-weight: bold;
    color: #009879;
}
.add{
	float:right;
	margin-top:-30px;
	margin-right:400px;
}
.nav{
	font-size:50px;
          margin-left:400px;
            
}
    </style>
</head>
<body>
	<%
		ArrayList<Employee> allEmp = null;
		if(request.getAttribute("allEmp") == null){
			RequestDispatcher r = request.getRequestDispatcher("fetch");
			r.forward(request, response);
		}else{
			allEmp = (ArrayList<Employee>)request.getAttribute("allEmp");
		}
	%>
    <nav>
     <div class="nav">
    	<form action = "search" method = "post">
    		<input type="text" name="id" placeholder="Search">
	        <input type="submit" value="search">
    	</form>
    	</div>
    	<div class="add">
	    <button ><a href="AddEmployee.jsp" >Example</a></button>
	    </div>
	    
    </nav>
    <div>
    <table class="styled-table">
    <thead>
        <tr>
           	    <th> ID </th>
	    		<th> Name </th>
	    		<th> Date Of Joining </th>
	    		<th> Year Of Experience </th>
	    		<th> Designation </th>
        </tr>
    </thead>
    <tbody>
       
        <tr class="active-row">
            
        </tr>
        <!-- and so on... -->
    </tbody>
    <%for(int i = 0; i < allEmp.size(); i++){ 
    			Employee emp = allEmp.get(i);
    		%>
    			<tr>
    				<td> <%=emp.getEid() %> </td>
		    		<td> <%=emp.getEname() %> </td>
		    		<td> <%=emp.getDoj() %> </td>
		    		<td> <%=emp.getYearOfExperience() %> </td>
		    		<td> <%=emp.getDesignation() %> </td>
    			</tr>
    		<%} %>
</table>
    	
    </div>
</body>
</html>