<%@ page import="java.util.List" %>
<%@ page import="dormitory.models.Student" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.02.2024
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Rooms</title>
</head>
<% List<Student> students = (List<Student>) request.getAttribute("rooms"); %>
<body>
<h1>Welcome to our Dormitory
</h1>
<br/>
<table class="table">
    <thead>
    <tr>
        <th>NAME</th>
        <th>SURNAME</th>
        <th>END DATE</th>
        <th>REMAINING DAYS</th>
        <th>ROOM INFO</th>

        <%  if (students != null && !students.isEmpty()) {   %>
                <%for (Student student : students) {%>

    </tr>
    </thead>
    <tbody>
    <tbody>
    <tr>
        <td><%=student.getName()%>
        </td>
        <td><%=student.getSurname()%></td>
        <td><%=student.getDate()%></td>
        <td><%=student.getDaysUntil(student.getDate())%></td>
        <td><a href="/roomsList" class="gradient-button">Room</a> </td>
        <%}%>
        <%}%>

    </tr>
    </tbody>
</table>
<style type="text/css">
    .table {
        width: 100%;
        margin-bottom: 20px;
        border: 5px solid #fff;
        border-top: 5px solid #fff;
        border-bottom: 3px solid #fff;
        border-collapse: collapse;
        outline: 3px solid #ffd300;
        font-size: 15px;
        background: #fff !important;
    }

    .table th {
        font-weight: bold;
        padding: 7px;
        background: #ffd300;
        border: none;
        text-align: left;
        font-size: 15px;
        border-top: 3px solid #fff;
        border-bottom: 3px solid #ffd300;
    }

    .table td {
        padding: 7px;
        border: none;
        border-top: 3px solid #fff;
        border-bottom: 3px solid #fff;
        font-size: 15px;
    }

    .table tbody tr:nth-child(even) {
        background: #f8f8f8 !important;
    }
</style>
<style>
.gradient-button {
text-decoration: none;
display: inline-block;
color: white;
padding: 10px 20px;
margin: 5px 15px;
border-radius: 10px;
font-family: 'Montserrat', sans-serif;
text-transform: uppercase;
letter-spacing: 2px;
background-image: linear-gradient(to right, #fdd100 0%, #f09630 51%, #f1c700 100%);
background-size: 200% auto;
box-shadow: 0 0 20px rgba(0, 0, 0, .1);
transition: .5s;
}
.gradient-button:hover {
background-position: right center;
}
</style>
</body>
</html>