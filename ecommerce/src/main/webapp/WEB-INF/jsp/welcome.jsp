<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="angular.min.js"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>

        var app=angular.module("myapp");
        app.config()
        app.controller()
    </script>



</head>
<body>
<nav class="navbar navbar-inverse">
    <div container="container-fluid">
        <span class="navbar-brand" style="color:red">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SHIVA's FACEBOOKAPP&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <ul class="nav navbar-nav">
        <li class="active"><a href='#'>Home</a><li>
        <li><a href="#">About Us</a></li>
        <li><a href="#">Contact US</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <!--<li><button type="button"><span class="glyphicon glyphicon-user"></span>Sign Up</button></li>
            <li><button type="button"><span class="glyphicon glyphicon-log-in"></span>Login</button></li>
            -->
            <li><a href="form" class="glyphicon glyphicon-user">Sign Up</a></li>
            <li><a href="form" class="glyphicon glyphicon-log-in">Login</a></li>
            <li><span>&nbsp;&nbsp;&nbsp;&nbsp;</span></li>
        </ul>
    </div>
</nav>
</body>
</html>

