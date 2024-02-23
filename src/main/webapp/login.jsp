<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22.02.2024
  Time: 1:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <title>Login RECEPTIONIST</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="wave"></div>
<div class="wave"></div>
<div class="wave"></div>
<div class="wrapper">
    <div class="title">
        RECEPTION
    </div>
    <form action="/login" method="post">
        <div class="field">
            <input type="text" required>
            <label>Email Address</label>
        </div>
        <div class="field">
            <input type="password" required>
            <label>Password</label>
        </div>
        <div class="content">
            <div class="pass-link">
                <a style="right:5px " href="/forgetPassword" s> Forgot password?</a>
            </div>
        </div>
        <div class="field">
            <input type="submit" value="Login">
        </div>
        <div class="signup-link">
            Register <a href="/singin.jsp">SingIn up </a>
        </div>
    </form>

    </form>
</div>
</body>
<style>
    @import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');

    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Poppins', sans-serif;
    }

    html, body {
        font-family: -apple-system, BlinkMacSystemFont, sans-serif;
        overflow: hidden;
        background: linear-gradient(315deg, rgb(255, 96, 12) 3%, rgba(60, 132, 206, 1) 38%, rgba(48, 238, 226, 1) 68%, rgb(255, 182, 25) 98%);
        animation: gradient 15s ease infinite;
        background-size: 400% 400%;
        background-attachment: fixed;
        height: 600px;
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
        z-index: 1;
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

    ::selection {
        background: #4158d0;
        color: #ffffff;
    }

    .wrapper {
        width: 380px;
        background:  linear-gradient(135deg, #a536ef, #00878c);
        border-radius: 15px;
        box-shadow: 0px 15px 20px rgba(0, 0, 0, 0.1);
    }

    .wrapper .title {
        font-size: 35px;
        font-weight: 600;
        text-align: center;
        line-height: 100px;
        color: #fff;
        user-select: none;
        border-radius: 15px 15px 0 0;
        background:linear-gradient(135deg, #a436ed, #36b7ef); );
    }

    .wrapper form {
        padding: 10px 30px 50px 30px;
    }

    .wrapper form .field {
        height: 50px;
        width: 100%;
        margin-top: 20px;
        position: relative;
    }

    .wrapper form .field input {
        height: 100%;
        width: 100%;
        outline: none;
        font-size: 17px;
        padding-left: 20px;
        border: 1px solid lightgrey;
        border-radius: 25px;
        transition: all 0.3s ease;
        background: rgba(157, 241, 217, 0.29);
    }

    .wrapper form .field input:focus,
    form .field input:valid {
        border-color: #c7af62;
    }

    .wrapper form .field label {
        position: absolute;
        top: 50%;
        left: 20px;
        color: #151b2c;
        font-weight: 400;
        font-size: 17px;
        pointer-events: none;
        transform: translateY(-50%);
        transition: all 0.3s ease;
    }

    form .field input:focus ~ label,
    form .field input:valid ~ label {
        top: 0%;
        font-size: 14px;
        color: rgba(30, 2, 166, 0.4);
        background:linear-gradient(135deg, #a436ed, #36b7ef);
        border-radius: 7px;
        transform: translateY(-50%);
    }

    form .content {
        display: flex;
        width: 100%;
        height: 50px;
        font-size: 16px;
        align-items: center;
        justify-content: space-around;
    }

    form .content .checkbox {
        display: flex;
        align-items: center;
        justify-content: center;
    }

    form .content input {
        width: 15px;
        height: 15px;
        background: red;
    }

    form .content label {
        color: #1b50a2;
        user-select: none;
        padding-left: 5px;
    }

    form .content .pass-link {
        color: darkblue;
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
        background-size:200% auto;
        transition: all 0.5s ease;
    }
    form .field input[type =  "submit"]:hover{
        background-position: right center;
        color: #6ee547;
    }

    form .field input[type="submit"]:active {
        transform: scale(0.95);
    }

    form .signup-link {
        color: #000000;
        margin-top: 20px;
        text-align: center;
    }

    form .pass-link a,
    form .signup-link a {
        color: rgba(172, 208, 65, 0.76);
        text-decoration: none;
    }

    form .pass-link a:hover,
    form .signup-link a:hover {
        text-decoration: underline;
    }
</style>
</html>
