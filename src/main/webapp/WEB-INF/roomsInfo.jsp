<%@ page import="dormitory.models.Dormitory" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24.02.2024
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Room Info</title>
</head>
<% Dormitory dormitory = (Dormitory) request.getAttribute("dormitory"); %>
<%Date releaseDate = (Date) request.getAttribute("date");
String isFree = (String) request.getAttribute("timer");%>
<body>

<div class="wave"></div>
<div class="wave"></div>
<div class="wave"></div>

<div class="container">
    <h1>About Room</h1>

    <br/>
    <table class="table">
        <thead>
        <tr>
            <th>FLOOR</th>
            <th>ROOM NUMBER</th>
            <th>RELEASE DATE</th>
        </tr>
        </thead>
        <tbody>
        <% if (dormitory != null && releaseDate != null){%>
        <tr>
            <td><%= dormitory.getFloor() %>
            </td>
            <td><%= dormitory.getRoomNum() %>
            </td>
            <% if (isFree == 0 + "d " + 0 + "h" ){%>
            <td style="color: #830505"><%= releaseDate %>
            </td>
            <%}else {%>
            <td><%= releaseDate %>
            </td>
            <%}%>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>


</body>
<style type="text/css">
    .container {
        max-width: 800px;
        width: 100%;
        background-color: #80caff;
        padding: 25px 30px;
        border-radius: 5px;
        box-shadow: 0 5px 10px rgba(0, 0, 0, 0.15);
    }

    .table {
        width: 100%;
        margin-bottom: 50px;
        border-radius: 5px;
        border: 0px solid #ffffff;
        border-top: 0px solid #ffffff;
        border-bottom: 0px solid #fff;
        border-collapse: collapse;
        outline: 5px solid #ffd300;
        font-size: 20px;
        background: #ffffff !important;
    }

    .table th {
        font-weight: bold;
        padding: 3px 16px;
        background: #ffd300;
        border: 6px none;
        text-align: left;
        font-size: 15px;
        border-top: 3px solid #ffd300;
        border-bottom: 3px solid #ffd300;
    }

    .table td {
        padding-left: 20px;
        border: 30px;
        font-size: 16px;
        background: linear-gradient(135deg, #fdd100, #428af6);
    }

    .table tbody tr:nth-child(even) {
        background: #4c698d !important;
    }

    .wave {
        background: rgb(255 255 255 / 25%);
        border-radius: 1000% 1000% 0 0;
        position: fixed;
        width: 200%;
        height: 12em;
        animation: wave 10s -3s linear infinite;
        transform: translate3d(0, 0, 0);
        opacity: 0.8;
        bottom: 0;
        left: 0;
        z-index: -1;
    }

    .wave:nth-of-type(2) {
        bottom: -1.25em;
        animation: wave 18s linear reverse infinite;
        opacity: 0.8;
    }

    .wave:nth-of-type(3) {
        bottom: -2.5em;
        animation: wave 20s -1s reverse infinite;
        opacity: 0.9;
    }

    @keyframes wave {
        2% {
            transform: translateX(0%);
        }

        25% {
            transform: translateX(-25%);
        }

        50% {
            transform: translateX(-50%);
        }

        75% {
            transform: translateX(-25%);
        }

        100% {
            transform: translateX(0%);
        }
    }
</style>
<style>
    body {
        font-family: -apple-system, BlinkMacSystemFont, sans-serif;
        overflow: auto;
        background: linear-gradient(315deg, rgba(101, 0, 94, 1) 3%, rgba(60, 132, 206, 1) 38%, rgba(48, 238, 226, 1) 68%, rgba(255, 25, 25, 1) 98%);
        animation: gradient 15s ease infinite;
        background-size: 400% 400%;
        background-attachment: fixed;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        margin: 0;
    }

    @keyframes gradient {
        0% {
            background-position: 0% 0%;
        }
        50% {
            background-position: 100% 100%;
        }
        100% {
            background-position: 0% 0%;
        }
    }

    .gradient-button {
        text-decoration: none;
        display: inline-block;
        padding: 10px 20px;
        margin: 5px 15px;
        border-radius: 10px;
        font-family: 'Montserrat', sans-serif;
        text-transform: uppercase;
        letter-spacing: 2px;
        background-image: linear-gradient(to right, #fdd100 0%, #f09630 51%, #f1c700 100%);
        background-size: 200% auto;
        box-shadow: 0 0 20px rgba(0, 0, 0, .1);

        transition: text-shadow 0.5s ease;
        transition: .5s;
    }

    .gradient-button:hover {
        background-position: right center;
        color: #000;
        text-shadow: 0 0 10px #f519f5;
    }
</style>
</html>
