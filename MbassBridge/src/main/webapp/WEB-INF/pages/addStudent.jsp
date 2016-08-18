<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	  <head><style>
button {
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
    
}</style>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>mbass </title>
	</head>
	<body>
		<h1 style="color:#4CAF50">Data</h1>
		<form:form method="POST" action="save">
	   		<table>
			    <tr>
			        <td><form:label path="id"> ID:</form:label></td>
			        <td><form:input path="id" value="${crud.id}" readonly="true"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="email">Email:</form:label></td>
			        <td><form:input path="email" value="${crud.email}"/></td>
			    </tr>
			     <tr>
			        <td><form:label path="providers">Providers:</form:label></td>
			        <td><form:input path="providers" value="${crud.providers}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="created">Created:</form:label></td>
			        <td><form:input path="created" value="${crud.created}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="signedin">Signed In:</form:label></td>
			        <td><form:input path="signedin" value="${crud.signedin}"/></td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="useruid"> User UID:</form:label></td>
                    <td><form:input path="useruid" value="${crud.useruid}"/></td>
			    </tr>
			    <tr>
			      <td colspan="2"><button type="submit"  class="button">Sumbit</button></td>
		      </tr>
			</table> 
		</form:form>
	</body>
</html>