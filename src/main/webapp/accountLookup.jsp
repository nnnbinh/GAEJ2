<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="gaej2.Entity.*"%>

<%
List<Account> accounts = (List<Account>) request.getAttribute("accounts");
%>
<!DOCTYPE html>
<html ng-app="TelesalesApp">
<head>
<meta charset="ISO-8859-1">
<title>Google App Engine Servlet Example with Bigtable</title>
<link rel="stylesheet" type="text/css" href="/public/css/styles.css" />
<script src="/public/js/angular.js"></script>
<script src="/public/js/accountLookup.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<script>
	const AccountName = "<%= request.getParameter("accountName")%>"
</script>
<body ng-controller="ToDoCtrl">
	<div class="container mt-2">
		<span class="title">Google App Engine Servlet Example with Bigtable</span> 
		<a href="telesales?action=Count" />Count</a>
		<p>
			Before creating a new Opportunity, ensure that the Account does not already
			exist. You can also <a href="telesales?action=accountCreate" />create a new
			account</a>.
		</p>
		<p />
		<form method="post" action="telesales">
			<input type="hidden" name="action" value="accountLookup" /> <span
				class="heading">Search by Account Name:</span>
			<p />
			<input type="text" name="accountName"
				value="{{AccountName}}"
				style="width: 300px" /> &nbsp <input type="submit" value="Search" /> &nbsp
		</form>
		
		<p />
		<%
		if (accounts.size() > 0) {
		%>
		<span class="heading"><%=accounts.size()%> accounts matching your search criteria:</span>
		<p />
		<table border="0" cellspacing="1" cellpadding="5" bgcolor="#CCCCCC" width="50%">
			<tr bgcolor="#407BA8">
				<td style="color: #ffffff; font-weight: bold;">Name</td>
				<td style="color: #ffffff; font-weight: bold;">City</td>
				<td style="color: #ffffff; font-weight: bold;">State</td>
				<td style="color: #ffffff; font-weight: bold;">Phone</td>
			</tr>
			<%
			for (int i = 0; i < accounts.size(); i++) {
			%>
			<%
			Account a = (Account) accounts.get(i);
			%>
			<tr style="background: #ffffff" ng-mousedown="this.style.background='#eeeeee';"
				ng-mouseleave="this.style.background='#ffffff';">
				<td><a href="telesales?action=accountDisplay&accountId=<%=a.getId()%>"><%=a.getName()%></a></td>
				<td><%=a.getCity()%></td>
				<td><%=a.getState()%></td>
				<td><%=a.getPhone()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<%
		} else {
		%>
		<span class="heading">No matching accounts found.</span>
		<%
		}
		%>
		<p />
	</div>
</body>
</html>