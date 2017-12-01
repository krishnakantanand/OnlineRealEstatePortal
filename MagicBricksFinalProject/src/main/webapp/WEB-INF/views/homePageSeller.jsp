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


<script type="text/javascript">
	
    var xmlHttp;
    xmlHttp = GetXmlHttpObject();
    function addProperty(){
    	
    	if (xmlHttp == null) {
            alert("Your browser does not support AJAX");
            return;
        }
    	var location = document.getElementById("location").value;
    	var propertyType = document.getElementById("propertyType").value;
    	var propertyArea = document.getElementById("propertyArea").value;
    	var description = document.getElementById("description").value;
    	var status = document.getElementById("status").value;
    	
    	var query="action=property&location=" + location + "&propertyType=" + propertyType +
    	"&propertyArea=" + propertyArea + "&description=" + description + "&status=" + status;
    	
    	xmlHttp.onreadystatechange = function stateChanged() {

            if (xmlHttp.readyState == 4) {
                
            	document.getElementById("results").innerHTML = "Property posted";
                
            }
        };
        xmlHttp.open("POST", "property.htm", true);
        xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlHttp.send(query);
        return false;
    }

    	
    	
    	function GetXmlHttpObject()
        {
            var xmlHttp = null;
            try
            {

                xmlHttp = new XMLHttpRequest();
            } catch (e)
            {

                try
                {
                    xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                } catch (e)
                {
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
            }
            return xmlHttp;
        }

</script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>



</head>

<body>
  <div class="body"></div>
		<div class="header">
			<div>Magic<span>Bricks</span></div>
			<h3 class="h4">Boston's No. 1 Property Site</h3>
			<h3 class="h4">Buy or Sell Property</h3>
			<br>
			<h3 class="h4">Post the property</h3>
			
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




<div class="container col-md-12">

<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
<br>

<table class="table1 table-condensed" align="center">

<tr>
    <td style="text-align:center;font-size: 15px;font-family: 'Exo', sans-serif;">Location:</td>
    <td style="text-align:center;font-size: 15px;font-family: 'Exo', sans-serif;"><font color="black"><input type="text" path="location" name="location" size="30" id="location"/></font></td>
    <td><font color="red"> <form:errors path="location"/></font></td>
</tr>
<tr>
<td style="text-align:center;font-size: 15px;font-family: 'Exo', sans-serif;">Property Type:</td>
    <td style="text-align:center;font-size: 15px;font-family: 'Exo', sans-serif;"><font color="black"><input type="text" path="propertyType" name="propertyType" size="30" id="propertyType"/></font> </td>
    <td><font color="red"> <form:errors path="propertyType"/></font></td>
</tr>
<tr>
    <td style="text-align:center;font-size: 15px;font-family: 'Exo', sans-serif;">Property Area:</td>
    <td style="text-align:center;font-size: 15px;font-family: 'Exo', sans-serif;"><font color="black"><input type="text"  size="30" name="propertyArea" id="propertyArea"/></font> </td>
    <td><font color="red"> <form:errors path="propertyArea"/></font></td>
</tr>
<tr>
    <td style="text-align:center;font-size: 15px;font-family: 'Exo', sans-serif;">Description:</td>
    <td style="text-align:center;font-size: 15px;font-family: 'Exo', sans-serif;"><font color="black"><input type="text"  size="30" name="description" id="description"/></font> </td>
    <td><font color="red"> <form:errors path="description"/></font></td>
</tr>
<tr>
    <td style="text-align:center;font-size: 15px;font-family: 'Exo', sans-serif;">Status:</td>
    <td style="text-align:center;font-size: 15px;font-family: 'Exo', sans-serif;"><font color="black"><input type="text"  size="30" name="status" id="status"/></font> </td>
    <td><font color="red"> <form:errors path="status"/></font></td>
</tr>

<tr><form:form action="property.htm" commandName="property" method="POST">
    <td colspan="2" style="text-align:center;font-size: 20px;font-family: 'Exo', sans-serif;"><font color="black"><input type="submit" value="Create Property" onclick="return addProperty() "/></font></td>

</form:form></tr>
</table>
</div>
<div id="results" class="container col-md-12" align="center" style="text-align:center;font-size: 20px;font-family: 'Exo', sans-serif;" >

</div>
<form action="viewPostedProperty.htm" method="POST">

<div class="container col-md-6" align="center" style="margin-left: 360px;font-size: 20px;font-family: 'Exo', sans-serif;">
<br><font color="black">
<input type="submit" value="View Posted Property" ></font>

</div>
</form>
<br>

<div class="container col-md-6" style="margin-left: 670px">
<br>
<br>
<form:form action="logoutSeller.htm" method="POST" commandName="seller">

      <button style="text-align:center;font-size: 20px;font-family: 'Exo', sans-serif;align-content:center" type="submit"><font color="black">Logout</font></button>

</form:form>
</div>
</div>

</body>
</html>
