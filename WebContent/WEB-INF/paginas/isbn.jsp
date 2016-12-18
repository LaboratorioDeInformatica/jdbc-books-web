<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ISBN</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
<a href="executa?tarefa=RetornaMenu">Menu</a><br>

<h3>ISBN</h3>
	<form action="executa" method="post" id="frm">
	<div class="form-group">
    First Name: <input type="text" class="form-control" name="firstName" /><br />
    Last Name : <input type="text" class="form-control" name="lastName" /><br />
   	ISBN: <input type="text" class="form-control" name="isbn" />
     </div>
    <input type="hidden" name="tarefa" value="BuscaISBN">
    <input type="submit" value="Buscar" class="btn btn-default" />
    </form>

<hr>
<h3>Lista ISBN</h3>	
	<table  class="table table-striped">
	 <tr>
   
    <th>Nome</th>
    <th>Sobrenome</th>
    <th>ISBN</th>
    <th>Opções</th>

    
 	</tr>
		
			<c:forEach var="isbn" items="${listaIsbn}" varStatus="count" >
			<tr>
				<td>${isbn.author.firstName}</td> 
				<td>${isbn.author.lastname} </td>
				<td>${isbn.isbn}</td>
				<td> Teste</td>
			</tr>
			</c:forEach>
		
	</table>
</div>

</body>
</html>