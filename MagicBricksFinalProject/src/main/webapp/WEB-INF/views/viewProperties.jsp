<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    border: 0px solid white;
	width: 600px;
	height:250px;
	align: center;
	
}
</style>
  


  <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>



</head>


   <script type="text/javascript">
    var xmlHttp;
    xmlHttp = GetXmlHttpObject();
    function applyProperty(id){
    	
    	if (xmlHttp == null) {
            alert("Your browser does not support AJAX");
            return;
        }
    	
    	var propertyID=document.getElementById("propertyID"+id).innerText;
      	
    	var query= "action=apply&propertyID=" + propertyID;
    	
    	xmlHttp.onreadystatechange = function stateChanged() {

            if (xmlHttp.readyState == 4) {
                
                //document.getElementById("row" + id).style.backgroundColor = "#00FF00";
                document.getElementById("apply" + id).innerText="Liked";
                document.getElementById("apply" + id).disabled = true;
                
            }
        };
        xmlHttp.open("POST", "apply.htm", true);
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
   
<body>
  <div class="body"></div>
		<div class="header">
			<div>Magic<span>Bricks</span></div>
			<h3 class="h4">Boston's No. 1 Property Site</h3>
			<h3 class="h4">Buy or Sell Property</h3>
			<br>
			<h3 class="h4">View Details</h3>
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
        <table border="1" cellpadding="5" cellspacing="5" class="table1 table-condensed" align="center">
            <tr>
            	<td style="text-align:center;font-size: 20px;font-family: 'Exo', sans-serif;"><b>Property ID</b></td>
                <td style="text-align:center;font-size: 20px;font-family: 'Exo', sans-serif;"><b>Location</b></td>
                <td style="text-align:center;font-size: 20px;font-family: 'Exo', sans-serif;"><b>Property Type</b></td>
                <td style="text-align:center;font-size: 20px;font-family: 'Exo', sans-serif;"><b>Property Area</b></td>
                <td style="text-align:center;font-size: 20px;font-family: 'Exo', sans-serif;"><b>Description</b></td>
                <td style="text-align:center;font-size: 20px;font-family: 'Exo', sans-serif;"><b>Status</b></td>
                <td style="text-align:center;font-size: 20px;font-family: 'Exo', sans-serif;"><b>Contact Seller</b>
                <td style="text-align:center;font-size: 20px;font-family: 'Exo', sans-serif;"><b>Like ?</b>
            </tr>
            <c:forEach var="property" items="${properties}" begin="0" varStatus="counter" >
                <tr id="row${counter.index}">
                	<td style="text-align:center;font-size: 20px;font-family: 'Exo', sans-serif;" id="propertyID${counter.index}" align="center">${property.propertyId}</td>
                    <td style="text-align:center;font-size: 20px;font-family: 'Exo', sans-serif;" id="location${counter.index}" align="center">${property.location}</td>
                    <td style="text-align:center;font-size: 20px;font-family: 'Exo', sans-serif;" id="propertyType${counter.index}" align="center">${property.propertyType}</td>
                    <td style="text-align:center;font-size: 20px;font-family: 'Exo', sans-serif;" id="propertyArea${counter.index}" align="center">${property.propertyArea}</td>
                    <td style="text-align:center;font-size: 20px;font-family: 'Exo', sans-serif;" id="description${counter.index}" align="center">${property.description}</td>
                    <td style="text-align:center;font-size: 20px;font-family: 'Exo', sans-serif;" id="status${counter.index}" align="center">${property.status}</td>
                    <td style="text-align:center;font-size: 20px;font-family: 'Exo', sans-serif;" id="phoneNumber${counter.index}" align="center">${property.seller.user.phoneNumber}
                   
                    <td><button onclick="return applyProperty(${counter.index})" id="apply${counter.index}" align="center"><font color="black"> Like</font></button> 
                    </tr>
            </c:forEach>
        </table>
        </div>
        <div class="container col-md-12" style="margin-left: 650px">
<form:form action="logout.htm" method="POST" commandName="buyer">

      <button style="text-align:center;font-size: 20px;font-family: 'Exo', sans-serif;align-content:center" type="submit"><font color="black">Logout</font></button>

</form:form>
</div>
    </body>
</html>