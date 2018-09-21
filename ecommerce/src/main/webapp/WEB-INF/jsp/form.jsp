<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
 <script src="js/lib/angular.min.js"></script>
 <link rel="stylesheet" href="css/style.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script src="js/bootstrap.min.js"></script>

   
    <!-- Website Font style -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
    <link rel="stylesheet" href="style.css">
    <!-- Google Fonts -->
    <link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>

    <title>Admin</title>

    <style>
        label.required:after{
            content:"*";
            color: red;

        }

    </style>
    <script>

    var app= angular.module("myapp",[]);
    app.controller("validationController",function($scope,$http,$log)
        {
          $scope.user={}
          $scope.signup=function(user)
          {
        	  $scope.msg="";
              $log.debug(user.name);
              $scope.user=user;
              $http.post("user",user).then(function(response){
                  if(response.data)
                      $scope.msg="request Send successfully";

              },function(response){
                  $scope.status=response.status;
                  $scope.msg="requestFailed";
              })
          }
        }
    );
    app.directive("compareTo", function ()
    {
        return {
            require: "ngModel",
            scope:
                {
                    confirmPassword: "=compareTo"
                },
            link: function (scope, element, attributes, modelVal)
            {
                modelVal.$validators.compareTo = function (val)
                {
                    return val == scope.confirmPassword;
                };
                scope.$watch("confirmPassword", function ()
                {
                    modelVal.$validate();
                });
            }
        };
    });
    </script>
</head>
<body>
<nav class=" navbar navbar-inverse">
    <div container="container-fluid">
        <span class="navbar-brand" style="color:red">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SHIVA's FACEBOOKAPP&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <ul class="nav navbar-nav">
            <li class="active"><a href='#'>Home</a><li>
            <li><a href="#">About Us</a></li>
            <li><a href="#">Contact US</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="form2.html" class="glyphicon glyphicon-user" disabled="true">Sign Up</a></li>
            <li><a href="form2.html" class="glyphicon glyphicon-log-in">Login</a></li>
            <li><span>&nbsp;&nbsp;&nbsp;&nbsp;</span></li>
        </ul>
    </div>
</nav>
<div class="container" ng-app="myapp" ng-controller="validationController">
    <div class="row main">
        <div class="main-login main-center">
            <h4>Sign up once </h4>
            <h5 style="color:red">"*" fileds are manadatory</h5>
            <form class="" method="post" action="user" name="myform" autocomplete="off" novalidate>

                <div class="form-group">
                    <label for="name" class="cols-sm-2 control-label required">Your Name</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                           <input type="text" class="form-control"  name="name" ng-model="user.name" maxlength="20" minlength="3"  ng-pattern="/^([A-Z\s]{3,20})$/" id="name"  placeholder="Enter your Name"/>

                        </div>
                        <div class="error" ng-show="myform.name.$invalid">
                        <p>Name must be  in capital letters </p>
                        <p >Name should be greater than 3 </p>
                        </div>

                    </div>
                </div>

                <div class="form-group">
                    <label for="email" class="cols-sm-2 control-label required">Your Email</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                            <input type="text" class="form-control"   ng-model="user.email" ng-pattern="/^[a-zA-Z]+[a-zA-Z0-9_-]*@([a-zA-Z0-9]+){1}(\.[a-zA-Z0-9]+){1,2}/" name="email" id="email"  placeholder="Enter your Email"/>
                        </div>
                        <div class="error" ng-show="myform.email.$invalid">
                            <p>Please provide valid email address</p>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="username" class="cols-sm-2 control-label required">Username</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" maxlength="8" name="user.username" id="username" ng-model="username" ng-pattern="/^[a-zA-Z0-9]{8}$/"  placeholder="Enter your Username"/>
                        </div>
                        <div class="error" ng-show="myform.username.$invalid">
                           <ul>
                            <li>Username can be Alphanumeric</li>
                            <li>username must be 8 characters</li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="password" class="cols-sm-2 control-label required">Password</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                            <input type="password" ng-model="user.password" maxlength="15" ng-pattern="/(?=^.{6,255}$)((?=.*\d)(?=.*[A-Z])(?=.*[a-z])|(?=.*\d)(?=.*[^A-Za-z0-9])(?=.*[a-z])|(?=.*[^A-Za-z0-9])(?=.*[A-Z])(?=.*[a-z])|(?=.*\d)(?=.*[A-Z])(?=.*[^A-Za-z0-9]))^.*/" class="form-control" name="password" id="password"  placeholder="Enter your Password"/>
                        </div>

                        <div class="error" ng-show="myform.password.$invalid">
                            <p> Password Must contain</p>
                            <ul>
                                <li> At least 1 upper case character</li>
                                <li> At least 1 lower case character</li>
                                <li> At least 1 numerical character</li>
                                <li> At least 1 special character</li>
                            </ul>
                        </div>

                    </div>
                </div>

                <div class="form-group">
                    <label for="confirm" class="cols-sm-2 control-label required">Confirm Password</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                            <input type="password" class="form-control" name="confirm" id="confirm"  ng-model="user.confirm" compare-to="password" placeholder="Confirm your Password"/>
                        </div>
                        <div class="error" ng-show="myform.confirm.$invalid">
                            <p>Password didnn't match</p>
                        </div>
                    </div>
                </div>
                <div class="form-goup">
                    <label for="gender" class="cols-sm-2 control-label required">Gender </label>
                   <div class="cols-sm-10">
                       <div class="col-sm-offset-4">
                      <input type="radio" name="gender" value="male" class="radio-inline" ng-model="user.gender" checked>Male
                       <input type="radio" name="gender"  class="radio-inline" ng-model="user.gender" value="female">Female
                       <input type="radio" name="gender" value="others"  ng-model="user.gender"  class="radio-inline">other
                       </div>
                   </div>
                </div>
                <div class="form-group ">
                    <button type="submit"  ng-submit="signup(user)"class="btn btn-primary btn-lg btn-block login-button"  >Register</button>
                </div>
            </form>
        </div>
        {{msg}}
    </div>
</div>
</body>
</html>