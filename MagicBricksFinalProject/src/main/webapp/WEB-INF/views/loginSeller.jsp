<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>MagicBricks</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	    integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
		integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="resources/css/style.css" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="css/bootstrapex3.css" rel="stylesheet">
  <script type="text/javascript" src="script/registration_validator.js"></script>

 <style>

table.table1.table-condensed {
    border: 1px solid white;
	width: 600px;
	height:250px;
	align: center;
}
</style>
  


  <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>

</head>


<body>
  <div class="body"></div>
		<div class="header">
			<div>Magic<span>Bricks</span></div>
			<h3 class="h4">Boston's No. 1 Property Site</h3>
			<h3 class="h4">Buy or Sell Property</h3>
		</div>
		<br>
		<br>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

<br>

<h2> Login Page</h2>
<hr style="width: 100%; color: black; height: 5px; background-color:black;" />
<form:form action="loginseller.htm" commandName="seller" method="post">
<div class="container col-md-12">
<table class="table1 table-condensed" align="center">

<tr>
    <td style="text-align:center;font-size: 40px;font-family: 'Exo', sans-serif;">User Name:</td>
    <td style="text-align:center;font-size: 20px;font-family: 'Exo', sans-serif;"><font color="black"><form:input path="user.userName" size="30" style="-align:center;font-size: 20px;font-family: 'Exo', sans-serif;"/></font></td>
    <td ><font color="red"> <form:errors path="user.userName"/></font></td>
       
</tr>
<tr>
    <td style="text-align:center;font-size: 40px;font-family: 'Exo', sans-serif;">Password:</td>
    <td style="text-align:center;font-size: 20px;font-family: 'Exo', sans-serif;"><font color="black"><form:password path="user.password" size="30" /></font> </td>
    <td><font color="red"> <form:errors path="user.password"/></font></td>
</tr>
<tr>
    <td colspan="2" style="text-align:center"><font color="black"><input type="submit" value="Login" style="margin-left: = 300px; font-size: 40px;font-family: 'Exo', sans-serif;"></font></td>
</tr>
</table>
</div>
</form:form>
</body>
</html>