<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu</title>
</head>
<body>


<p>${usuarioLogado}</p>

<input type="hidden" value="${usuarioLogado}" name="usuarioLogado">

<h1>MENU</h1>
<h3>Authors</h3>
<a href="executa?tarefa=BuscaAuthors" >Pesquisa Author</a><br>
<a href="executa?tarefa=CadastraAuthor" >Cadastra Author</a><br>
<a href="executa?tarefa=BuscaAuthors" >Edita Author</a><br>
<a href="executa?tarefa=BuscaAuthors" >CRUD Author</a><br>
</body>
</html>