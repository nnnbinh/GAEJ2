<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.List"%> 
<%@ page import="java.text.SimpleDateFormat"%> 
<%@ page import="gaej2.Entity.*"%>


<% 
 Account account = (Account)request.getAttribute("account"); 
 List<Opportunity> opportunities = (List<Opportunity>)request.getAttribute("opportunities"); 
 SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy"); 
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Telesales Demo (Google App Engine for Java)</title> 
 	<link rel="stylesheet" type="text/css" href="/stylesheets/styles.css"/>
</head>
<body>
	<span class="nav"><a href="/index.html">Search</a></span><p/> 
	<span class="title">Account Display</span> 
	<p/> 
	
	<table border="0" cellspacing="1" cellpadding="5" bgcolor="#CCCCCC"> 
		<tr bgcolor="#407BA8"> 
			<td style="color: #ffffff; font-weight: bold;">Name</td> 
			<td bgcolor="#ffffff"><%= account.getName() %></td> 
		</tr> 
		<tr bgcolor="#407BA8"> 
			<td style="color: #ffffff; font-weight: bold;">City</td> 
			<td bgcolor="#ffffff"><%= account.getCity() %></td> 
		</tr> 
		<tr bgcolor="#407BA8"> 
			<td style="color: #ffffff; font-weight: bold;">State</td> 
			<td bgcolor="#ffffff"><%= account.getState() %></td> 
		</tr> 
		<tr bgcolor="#407BA8"> 
			<td style="color: #ffffff; font-weight: bold;">Phone</td> 
			<td bgcolor="#ffffff"><%= account.getPhone() %></td> 
		</tr> 
		<tr bgcolor="#407BA8"> 
			<td style="color: #ffffff; font-weight: bold;">Website</td> 
			<td bgcolor="#ffffff"><%= account.getWebsite() %></td> 
		</tr> 
	</table> 
	
	<br><a href="telesales?action=opportunityCreate&accountId=<%= account.getId() %>">Create a new Opportunity</a><p/> 
	
	<% if (opportunities.size() > 0) { %> 
		<p/><span class="heading">Opportunities for <%= account.getName() %></span><br><p/> 
		 
		<table border="0" cellspacing="1" cellpadding="5" bgcolor="#CCCCCC"> 
			<tr bgcolor="#407BA8">
				<td style="color: #ffffff; font-weight: bold;">Name</td> 
				<td style="color: #ffffff; font-weight: bold;">Amount</td> 
				<td style="color: #ffffff; font-weight: bold;">Stage</td> 
				<td style="color: #ffffff; font-weight: bold;">Probability</td> 
				<td style="color: #ffffff; font-weight: bold;">Close Date</td> 
				<td style="color: #ffffff; font-weight: bold;">Order</td> 
			</tr> 
		<% for (int i = 0;i<opportunities.size();i++) { %> 
			<% Opportunity o = (Opportunity)opportunities.get(i); %> 
			<tr style="background:#ffffff" onMouseOver="this.style.background='#eeeeee';" onMouseOut="this.style.background='#ffffff';"> 
				<td nowrap><%= o.getName() %></td> 
				<td>$<%= o.getAmount() %></td> 
				<td><%= o.getStageName() %></td> 
				<td><%= o.getProbability() %>%</td> 
				<td><%= sdf.format(o.getCloseDate()) %></td> 
				<td><%= o.getOrderNumber() %></td> 
			</tr> 
		<% } %> 
		</table> 
	<% } else { %> 
		<p/><span class="heading">No Opportunities found for <%= account.getName() %></span> 
	<% } %>
</body>
</html>