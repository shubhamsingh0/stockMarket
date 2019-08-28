<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add company</title>
</head>
<body>
User Details:
<br>
${User}
<br/>
<br/>
<hr/>

<form action="addBod">
Add Board Of Directors : 
<br>
<input type="text" name="companyBod"  /><br/>
<input type="submit"/>
</form>

<form action="addCompany" method="post">
<label>Add Company</label>
Name: <input type="text" name="companyName"  /><br />
TurnOver: <input type="text" name="companyTurnOver"  /><br />
CEO: <input type="text" name="companyCeo"  /><br />
Brief : <input type="text" name="companyBrief"  /><br />
code : <input type="text" name="companyStockCode"  /><br />
Sector : <input type="text" name="companySector"  /><br />
<input type="submit" name="savedetails"/><br />
</form>
<form action = "deactivateAccount">
companyName=<input type="text" name="companyName"/>
stockCode=<input type="text" name="companyStockCode"/>
<input type="submit">deactivate account</input>
</form>
<form action = "showAllCompanies">
<input type="submit">show all companies</input>
</form>
</body>
</html>