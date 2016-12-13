<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Books</title>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">

	<h1>CRUD - BOOKS</h1><br/>
		
	<form action="executa" method="post">
	<div class="form-group">
	    Email: <input type="text" name="email"  class="form-control"/><br />
	</div>    
	    <div class="form-group">
	    Senha: <input type="password" name="senha"  class="form-control"/><br />
	    </div>
	     <input type="hidden" name="tarefa" value="Login">
	    <input type="submit" value="Login"  class="btn btn-default" />
	</form>
	
	<br><br><br>
	<form action="executa" method="post">
		<input type="hidden" name="tarefa" value="Logout">
	    <input type="submit" value="Logout"  class="btn btn-default" />
	</form>

</div>
</body>
</html>