<%@ page import="dormitory.models.Dormitory" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 01.03.2024
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
</head>
<body>
<div>
    <div class="wave"></div>
    <div class="wave"></div>
    <div class="wave"></div>
</div>

<%Dormitory dormitory = (Dormitory) request.getAttribute("room");%>
<div class="container">
    <div class="title">Registration</div>
    <div class="content">
        <form action="/addStudent?roomId=<%=dormitory.getId()%>" method="post">
            <div class="user-details">
                <div class="input-box">
                    <span class="details">Name</span>
                    <input type="text" placeholder="Enter your name" required name="name">
                </div>
                <div class="input-box">
                    <span class="details">Surname</span>
                    <input type="text" placeholder="Enter your surname" required name="surname">
                </div>
                <div class="input-box">
                    <span class="details">Email</span>
                    <input type="text" placeholder="Enter your email" required name="email">
                </div>
                <div class="input-box">
                    <span class="details">Phone Number</span>
                    <input type="text" placeholder="Enter your number" required name="phone">
                </div>
                <div class="input-box">
                    <span class="input-box">Inspection Booklet</span>
                    <input type="text" placeholder="Enter num of booklet" required name="id">
                </div>
                <div class="input-box">
                    <span>Choose Date</span>
                    <input type="date" name="date">
                </div>

            </div>
            <div class="field">

                <input type="submit" value="add">
            </div>
        </form>
    </div>
</div>
</body>

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

    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Poppins', sans-serif;
    }

    .container {
        max-width: 800px;
        width: 100%;
        background-color: #80caff;
        padding: 25px 30px;
        border-radius: 5px;
        box-shadow: 0 5px 10px rgba(0, 0, 0, 0.15);
    }


    .container .title {
        font-size: 25px;
        font-weight: 500;
        position: relative;
    }

    .container .title::before {
        content: "";
        position: absolute;
        left: 0;
        bottom: 0;
        height: 3px;
        width: 30px;
        border-radius: 5px;
        background: linear-gradient(135deg, #71b7e6, #161c2d);
    }

    .content form .user-details {
        display: flex;
        flex-wrap: wrap;
        justify-content: space-between;
        margin: 20px 0 12px 0;
    }

    form .user-details .input-box {
        margin-bottom: 15px;
        width: calc(100% / 2 - 20px);
    }

    form .input-box span.details {
        display: block;
        font-weight: 500;
        margin-bottom: 5px;
    }

    .user-details .input-box input {
        height: 45px;
        width: 100%;
        outline: none;
        font-size: 16px;
        border-radius: 5px;
        padding-left: 15px;
        background:#000000 ;
        border: 1px solid #ff9c03;
        border-bottom-width: 2px;
        border-radius: 5px;
        transition: all 0.3s ease;
    }

    .user-details .input-box input:focus,
    .user-details .input-box input:valid {
        border-color: #eada3d;
    }

    form .category label {
        display: flex;
        align-items: center;
        cursor: pointer;
    }

    form .field input[type="submit"] {
        color: #4907bb;
        border: none;
        padding-left: 0;
        margin-top: -10px;
        font-size: 20px;
        font-weight: 500;
        cursor: pointer;
        background-image: linear-gradient(to right, #6ee547, #4158d0);
        background-size: 200% auto;
        transition: all 0.5s ease;
    }

    form .field input[type =  "submit"]:hover {
        background-position: right center;
        color: #6ee547;
    }


    @media (max-width: 584px) {
        .container {
            max-width: 100%;
        }

        form .user-details .input-box {
            margin-bottom: 15px;
            width: 100%;
        }

        .content form .user-details {
            max-height: 300px;
            overflow-y: scroll;
        }

        .user-details::-webkit-scrollbar {
            width: 5px;
        }
    }

    @media (max-width: 459px) {
        .container .content .category {
            flex-direction: column;
        }
    }
</style>
</html>