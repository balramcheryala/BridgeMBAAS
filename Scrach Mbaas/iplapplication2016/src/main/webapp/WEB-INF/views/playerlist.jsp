<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
    <link href="http://netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.min.css" rel="stylesheet">
	<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.3.min.js"></script>

	  <script type="text/javascript">
	  
		(function($){
		$.fn.tableSearch = function(options){
		if(!$(this).is('table')){
			return;
		}
		var tableObj = $(this),
			searchText = (options.searchText)?options.searchText:' ',
			searchPlaceHolder = (options.searchPlaceHolder)?options.searchPlaceHolder:'',
			divObj = $('<div style="float:right;">'+searchText+'</div><br /><br />'),
			inputObj = $('<input type="text" placeholder="'+searchPlaceHolder+'" />'),
			caseSensitive = (options.caseSensitive===true)?true:false,
			searchFieldVal = '',
			pattern = '';
		inputObj.off('keyup').on('keyup', function(){
			searchFieldVal = $(this).val();
			pattern = (caseSensitive)?RegExp(searchFieldVal):RegExp(searchFieldVal, 'i');
			tableObj.find('tbody tr').hide().each(function(){
				var currentRow = $(this);
				currentRow.find('td').each(function(){
					if(pattern.test($(this).html())){
						currentRow.show();
						return false;
					}
				});
			});
		});
		tableObj.before(divObj.append(inputObj));
		return tableObj;
	}
}(jQuery));
</script>
		<script type="text/javascript">
			$(document).ready(function(){
				$('table.search-table').tableSearch({
					searchText:'',
					searchPlaceHolder:'Search Anything Here'
				});
			});
		</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DD Player List</title>
</head>
<style>
table {
  font-family: 'Arial';
  margin: 25px auto;
  border-collapse: collapse;
  border: 1px solid #eee;
  border-bottom: 2px solid #00cccc;
  box-shadow: 0px 0px 20px rgba(0,0,0,0.10),
     0px 10px 20px rgba(0,0,0,0.05),
     0px 20px 20px rgba(0,0,0,0.05),
     0px 30px 20px rgba(0,0,0,0.05);
  tr {
     &:hover {
      background: #f4f4f4;
      
      td {
        color: #555;
      }
    }
  }
  th, td {
    color: #999;
    border: 1px solid #eee;
    padding: 12px 35px;
    border-collapse: collapse;
  }
  th {
    background: #00cccc;
    color: #fff;
    text-transform: uppercase;
    font-size: 12px;
    &.last {
      border-right: none;
    }
  }
} 

</style>
</head>
<body>
	<form action="playerlist" method="post">
		<table border="1" cellpadding="2" width="70%" class="search-table">
		<thead>
			<tr>
				<th><h4 style="color:#00cccc;"><I><!-- <a href="search?by=name&q="> -->NAME</I></h4></th>
				<th><h4 style="color:#00cccc;"><I><!-- <a href="search?by=role&q="> -->ROLE</I></h4></th>
				<th><h4 style="color:#00cccc;"><I><!-- <a href="search?by=batting&q="> -->BATTING</I></h4></th>
				<th><h4 style="color:#00cccc;"><I><!-- <a href="search?by=bowler&q="> -->BOWLING</I></h4></th>
				<th><h4 style="color:#00cccc;"><I><!-- <a href="search?by=nation&q="> -->NATION</I></h4></th>
				<th><h4 style="color:#00cccc;"><I><!-- <a href="search?by=dob&q="> -->DATE OF BIRTH</I></h4></th>
			</tr>
			</thead>
			<c:forEach var="playerlist" items="${playerlist}">

				<tr>
					<td>${playerlist.name}</td>
					<td>${playerlist.role}</td>
					<td>${playerlist.batting}</td>
					<td>${playerlist.bowler}</td>
					<td>${playerlist.nation}</td>
					<td>${playerlist.dob}</td>

				</tr>

			</c:forEach>
		</table>
		<br />
		</form>
</body>
</html>