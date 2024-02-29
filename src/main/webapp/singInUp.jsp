

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <title> Responsive Registration Form | CodingLab </title>
    <link rel="stylesheet" href="style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div class="container">
    <div class="title">Registration</div>
    <div class="content">
        <form action="#">
            <div class="user-details">
                <div class="input-box">
                    <span class="details">Name</span>
                    <input type="text" placeholder="Enter your name" required>
                </div>
                <div class="input-box">
                    <span class="details">Surname</span>
                    <input type="text" placeholder="Enter your username" required>
                </div>
                <div class="input-box">
                    <span class="details">Email</span>
                    <input type="text" placeholder="Enter your email" required>
                </div>
                <div class="input-box">
                    <span class="details">Phone Number</span>
                    <input type="text" placeholder="Enter your number" required>
                </div>
                <div class="input-box">
                    <span class="details">Password</span>
                    <input type="text" placeholder="Enter your password" required>
                </div>
                <div class="input-box">
                    <span class="details">Confirm Password</span>
                    <input type="text" placeholder="Confirm your password" required>
                </div>
            </div>
            <div class="button">
                <input type="submit" value="Register">
            </div>
        </form>
    </div>
</div>
</body>

<style>
    body {
        font-family: -apple-system, BlinkMacSystemFont, sans-serif;
        overflow: auto;
        background: linear-gradient(315deg, rgba(101,0,94,1) 3%, rgba(60,132,206,1) 38%, rgba(48,238,226,1) 68%, rgba(255,25,25,1) 98%);
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

*{
margin: 0;
padding: 0;
box-sizing: border-box;
font-family: 'Poppins',sans-serif;
}

.container{
    max-width: 700px;
    width: 100%;
    background: linear-gradient(135deg, #ef7636, #f1c700);
    padding: 25px 30px;
    border-radius: 5px;
    box-shadow: 0 5px 10px rgba(0,0,0,0.15);
}
.container .title{
font-size: 25px;
font-weight: 500;
position: relative;
}
.container .title::before{
content: "";
position: absolute;
left: 0;
bottom: 0;
height: 3px;
width: 30px;
border-radius: 5px;
background: linear-gradient(135deg, #71b7e6, #161c2d);
}
.content form .user-details{
display: flex;
flex-wrap: wrap;
justify-content: space-between;
margin: 20px 0 12px 0;
}
form .user-details .input-box{
margin-bottom: 15px;
width: calc(100% / 2 - 20px);
}
form .input-box span.details{
display: block;
font-weight: 500;
margin-bottom: 5px;
}
.user-details .input-box input{
height: 45px;
width: 100%;
outline: none;
font-size: 16px;
border-radius: 5px;
padding-left: 15px;
border: 1px solid #ccc;
border-bottom-width: 2px;
transition: all 0.3s ease;
}
.user-details .input-box input:focus,
.user-details .input-box input:valid{
border-color: #eada3d;
}
form .gender-details .gender-title{
font-size: 20px;
font-weight: 500;
}
form .category{
display: flex;
width: 80%;
margin: 14px 0 ;
justify-content: space-between;
}
form .category label{
display: flex;
align-items: center;
cursor: pointer;
}
form .category label .dot{
height: 18px;
width: 18px;
border-radius: 50%;
margin-right: 10px;
background: #d9d9d9;
border: 5px solid transparent;
transition: all 0.3s ease;
}
#dot-1:checked ~ .category label .one,
#dot-2:checked ~ .category label .two,
#dot-3:checked ~ .category label .three{
background: #e0ec60;
border-color: #a2b9e0;
}
form input[type="radio"]{
display: none;
}
form .button{
height: 45px;
margin: 35px 0
}
form .button input{
height: 100%;
width: 100%;
border-radius: 5px;
border: none;
color: #fff;
font-size: 18px;
font-weight: 500;
letter-spacing: 1px;
cursor: pointer;
    background-image: linear-gradient(to right, rgba(255, 216, 31, 0.7) 0%, #ffd825 51%, rgba(133, 253, 53, 0.6) 100%);
    background-size: 200% auto;
    transition: 0.5s;

}
form .button input:hover{
    background-position: right center;
}
@media(max-width: 584px){
.container{
max-width: 100%;
}
form .user-details .input-box{
margin-bottom: 15px;
width: 100%;
}

.content form .user-details{
max-height: 300px;
overflow-y: scroll;
}
.user-details::-webkit-scrollbar{
width: 5px;
}
}
@media(max-width: 459px){
.container .content .category{
flex-direction: column;
}
}
</style>
</html>