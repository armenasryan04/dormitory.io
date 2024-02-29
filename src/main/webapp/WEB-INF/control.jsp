<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="dormitory.models.Student" %>
<html>
<head>
    <title>List of Rooms</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<% List<Student> students = (List<Student>) request.getAttribute("students"); %>
<body>

<div class="wave"></div>
<div class="wave"></div>
<div class="wave"></div>

<div class="container">
    <h1>Welcome to our Dormitory </h1>
    <form id="searchForm" action="/control" method="get">
        <div class="search-box">
            <div class="input-search-background">
                <div class="btn-search">
                    <input type="text" name="search" class="input-search animate" placeholder="🔍 search..."
                           id="searchInput" value="${not empty param.search ? param.search : ''}">
                </div>
            </div>
        </div>
    </form>
    <script>
        document.getElementById('searchInput').addEventListener('keypress', function (event) {
            if (event.key === 'Enter') {
                event.preventDefault();
                document.getElementById('searchForm').submit();
            }
        });
        $(document).ready(function () {
            $('.menu').click(function () {
                $('.overlay').toggleClass('anim');
                $(this).toggleClass('open');
                $('.blurry-background').toggleClass('blurry');
            });
            $(document).click(function (event) {
                if (!$(event.target).closest('.overlay').length && !$(event.target).closest('.menu').length) {
                    $('.overlay').removeClass('anim');
                    $('.menu').removeClass('open');
                    $('.blurry-background').removeClass('blurry');
                }
            });
        });
    </script>

    <br/>
    <table class="table">
        <thead>
        <tr>
            <th>NAME</th>
            <th>SURNAME</th>
            <th>PHONE</th>
            <th>END DATE</th>
            <th style="padding-left: 10px">REMAINING DAYS</th>
            <th>ROOM INFO</th>
        </tr>
        </thead>
        <tbody>
        <% if (students != null && !students.isEmpty()) { %>
        <% for (Student student : students) { %>
        <tr>
            <td><%= student.getName() %>
            </td>
            <td><%= student.getSurname() %>
            </td>
            <td><%=student.getPhoneNum()%>
            </td>

            <%if (student.getDaysUntil(student.getDate()).equals(0 + "d " + 0 + "h")) {%>
            <td style="color: #650404"><%= student.getDate() %>
            </td>
            <td style="padding: 5px; color: #5d0202"><%= student.getDaysUntil(student.getDate()) %>
                    <%}else {%>

            <td><%=student.getDate()%>
            </td>
            <td style="padding: 5px;"><%= student.getDaysUntil(student.getDate()) %>
            </td>
            <%}%>
            <td style="padding-left: 2px "><a href="/roomsInfo?id=<%=student.getId()%>" class="gradient-button">Room</a>
            </td>
        </tr>
        <% } %>
        <% } %>
        </tbody>
    </table>
</div>
<div class="wrapper">
    <span class="menu"></span>
    <div class="overlay">

        <ul>
            <li><a href="#">FREE ROOMS</a></li>
            <li><a href="#">ADD STUDENT</a></li>
            <li><a href="#">AR</a></li>
            <li><a href="#">Contact</a></li>
        </ul>
        <button style="position: absolute" class="gradient-button" >lOG OUT</button>
    </div>
    <div class="blurry-background"></div>
</div>


</body>
<style type="text/css">
    .container {
        max-width: 800px;
        width: 100%;
        max-height: 90%;
        background: linear-gradient(1355deg, rgba(66, 246, 231, 0.87), #69d7ff);
        padding: 25px 30px;
        border-radius: 5px;
        box-shadow: 0 5px 10px rgba(0, 0, 0, 0.15);
        overflow-y: auto;
        z-index: 100;
    }

    .container::-webkit-scrollbar {
        width: 10px;
        border-radius: 5px;
    }

    .container::-webkit-scrollbar-track {
        background: linear-gradient(1355deg, #428af6, #fdd100);
        border-radius: 5px;
    }

    .container::-webkit-scrollbar-thumb {
        background: linear-gradient(1355deg, #00fde8, #428af6);
        background-size: 12px;
        border-radius: 5px;
        transition: background .5s;
    }

    .container::-webkit-scrollbar-thumb:hover {
        background: linear-gradient(135deg, #00fd9c, #428af6);
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
        top: 20px;
        right: 20px;
        text-decoration: none;
        color: #4907bb;
        display: inline-block;
        padding: 10px 20px;
        margin: 5px 15px;
        border-radius: 10px;
        text-transform: uppercase;
        letter-spacing: 2px;
        background-image: linear-gradient(to right, #428af6 0%, #fdd100 51%, #5000f1 100%);
        background-size: 200% auto;
        box-shadow: 0 0 20px rgba(0, 0, 0, .1);

        transition: text-shadow 0.5s ease;
        transition: .5s;
    }

    .gradient-button:hover {
        background-position: right center;
        color: rgb(0, 0, 0);
        text-shadow: 0 0 10px #f519f5;
    }

    * {
        box-sizing: border-box;
    }

    body {
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        background-color: #6259e7;
        font-family: 'Lato', sans-serif;
    }

    .search-box {
        position: relative;
    }


    .input-search {
        color: black;
        width: 63px;
        height: 40px;
        padding: 10px 20px;
        border: none;
        background: linear-gradient(135deg, #fdd100, #428af6);
        border-radius: 40px;
        outline: none;
        font-size: 18px;
        -webkit-background-clip: text;
        background-clip: text;
        transition: all 0.5s ease-in-out;
    }

    .input-search-background {
        width: 63px;
        height: 40px;
        border: none;
        border-radius: 40px;
        outline: none;
        font-size: 18px;
        background: linear-gradient(135deg, #fdd100, #428af6);
        transition: all 0.5s ease-in-out;

    }

    .input-search::placeholder {
        color: rgb(2, 0, 0);
        font-size: 16px;
        font-weight: 100;
    }


    .btn-search i {
        margin-top: 5px;
    }

    .input-search-background:focus-within {
        width: 300px;
    }

    .btn-search:focus + .input-search,
    .input-search:focus {
        width: 300px;
        border-radius: 40px;
        background-color: transparent;
        border-bottom: 2px solid rgb(255, 149, 59);
        animation: textColorChange 0.5s ease-in-out forwards;
    }

    .input-search:hover {
        caret-color: #f1c700;
        width: 300px;
    }

    .input-search-background:hover {
        width: 300px;
    }

    * {
        padding: 0;
        margin: 0;
    }

    .wrapper {
        width: 100%;
        height: 100vh;
        position: absolute;
        overflow: hidden;
    }

    .wrapper span {
        z-index: 999955887;
        position: absolute;
        top: 20px;
        left: 20px;
        width: 35px;
        height: 4px;
        background: rgba(5, 45, 147, 0.84);
        padding-bottom: 2px;
        border-radius: 5px;
        cursor: pointer;
    }

    .wrapper span:before,
    .wrapper span:after {
        display: block;
        position: absolute;
        content: '';
        left: 0;
        height: 2px;
        width: 35px;
        background: rgba(3, 41, 166, 0.89);
        padding-bottom: 4px;
        border-radius: 5px;
    }

    .wrapper span:before {
        top: -8px;
    }

    .wrapper span:after {
        bottom: -8px;
    }

    .wrapper .overlay {
        position: absolute;
        bottom: -100%;
        height: 100%;
        background: linear-gradient(rgba(0, 241, 76, 0.82), rgba(73, 7, 187, 0.84));
        left: 0;
        width: 100%;
        transition: all 0.5s ease;
    }

    .blurry-background {
        position: absolute;
        top: 0;
        right: 0;
        width: 100%;
        height: 100%;
        backdrop-filter: blur(10px);
        -webkit-backdrop-filter: blur(10px);
        z-index: 99;
        opacity: 0;
        transition: opacity 0.5s ease;
    }
    .blurry {
        z-index: 100;
        opacity: 1;
    }

    .wrapper .overlay.anim {
        left: 0;
        bottom: 0;
        animation: menu-anim 1.5s 1 ease-out forwards;
        width: 25%;
        right: 75%;
        z-index: 9955;
        transition: all 0.5s ease;

    }

    .wrapper .overlay ul {
        width: 100%;
        text-align: center;
        margin-top: 100px;
        padding-left: 0;
        margin-left: -10px;
        font-size: 1em;
        font-weight: 800;
    }

    .wrapper .overlay ul li {
        margin: 10px 0;
    }

    .wrapper .overlay ul li a {
        text-decoration: none;
        color: #000000;
        position: relative;
        display: inline-block;
        padding: 20px 0;
        overflow: hidden;
    }

    .wrapper .overlay ul li a:after {
        display: block;
        border-radius: 2px;
        content: '';
        left: 0;
        bottom: -10px;
        height: 5px;
        background: #4e00ce;
        transform: translateX(-101%);
    }

    .wrapper .overlay ul li a:hover:after {
        animation: border-anim 0.5s 1 ease normal;
        transform: translateX(0);
    }

    @keyframes menu-anim {
        0% {
            left: -99.5%;
            bottom: -99%;
            width: 100%;
        }

        50% {
            left: -99.5%;
            bottom: 0;
            width: 100%;
        }

        100% {
            bottom: 0;
            left: 0;
            width: 25%;
        }
    }

    @-webkit-keyframes border-anim {
        0% {
            transform: translateX(-100%);
        }

        100% {
            transform: translateX(0);
        }
    }
</style>
</style>
</html>