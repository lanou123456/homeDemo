<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>163yun</title>
    <style>
        .right{
            /*float: right  ;*/
            background-color: white;
            position: absolute;
            height: 660px;
            width: 560px;
            left: 50%;
            top: 15%;
        }

        .left{
            float: left;
            margin-left: 250px;
            margin-top: 250px;
        }
        body{
            background-color: gainsboro;
        }
        .shuru1{
            margin-bottom: 25px;
            /*margin-top: 120px;*/
            margin-left: 52px;
            width: 450px;
            height: 50px;
        }
        .shuru2{
            margin-left: 52px;
            margin-top: 15px;
            width: 450px;
            height: 50px;
        }
        p{
            margin-left: 200px;
            margin-top: 130px;
            margin-bottom: 20px;
            font-size: 30px;
            font-weight: 100;
        }
        .aaa{
            position: absolute;
            left: 9%;
            top: 65%;
        }
        .bbb{
            background-color: blue;
            position: absolute;
            left: 9%;
            top: 75%;
            padding-top: 10px;
            padding-bottom: 10px;
            padding-right: 211px;
            padding-left: 211px;
            font-size: 20px;
            color: white;
        }
        .ccc{
            position: absolute;
            left: 9%;
            top: 85%;
        }


    </style>

</head>
<body >


<img src="img/163yun.png" class="left"/>
<div class="right">
    <p>网易云登录</p>
    <form action="login" method="post">
    <input class="shuru1" name="username" placeholder="网易云账号/网易云邮箱账号"> <br>
    <input class="shuru2" name="password" placeholder="登录密码">
    <input type="submit" class="bbb">
    </form>
    <br>
    <div class="aaa">
        <input type="checkbox"> 同意并遵守
        <a href="">《服务条款》</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="checkbox">15天免登陆
    </div>
    <div class="ccc">还没有账号？

        <a href="">免费注册</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="">忘记密码？</a>
    </div>
    <div  style="text-align: center">
        ${cookie.username.value}
    </div>
</div>

</body>

</html>