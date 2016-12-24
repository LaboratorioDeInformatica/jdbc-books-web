
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Authors</title>


  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <script src=" https://code.jquery.com/jquery-1.12.4.js"></script>
 <script src="  https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
 
	<script type="text/javascript">
	
	 $(document).ready(function() {
		    $('#example').DataTable( {
		        "pagingType": "full_numbers"
		    } );
		} );
	


	function linkCadastrar() {
	
		$("#frm").attr("action","executa?tarefa=IniciaCadastraAuthor");
		$("#frm").submit();
		}	
	
	</script>

<style>

.navbar {
      margin-bottom: 10px;
	   
	  background-color:  #f2f2f2;
    color: #F2FFFC;
      border-radius: 0px;
	  high:15px;
    }
</style>


</head>



<body>
<div class="navbar ">
     
   <a href="executa?tarefa=RetornaMenu">Menu</a>
              
    </div>

<br>
<div class="container">
	
	<h3>Auhors</h3>
	<form action="executa" method="post" id="frm">
	<div class="form-group">
    First Name: <input type="text" class="form-control" name="firstName" /><br />
   
    </div>
    <div class="form-group">
     Last Name : <input type="text" class="form-control" name="lastName" /><br />
     </div>
    <input type="hidden" name="tarefa" value="BuscaAuthors">
    <input type="submit" value="Buscar" class="btn btn-default" />
    <input type="button" class="btn btn-default" onclick="linkCadastrar()" value="Novo">
 
</form>


<hr>
<h3>Lista Authors</h3>	
	<table id="example" class=" table table-striped display" width="100%" cellspacing="0">
	<thead>
	 <tr>
	    <th>Número de Identificação</th>
	    <th>Nome</th>
	    <th>Sobrenome</th>
	    <th>Opções</th>
	    <th></th>
    </tr>
 	</thead>
		
			<c:forEach var="author" items="${authors}" varStatus="count" >
			<tr>
				<td>${count.index}</td> 
				<td> ${author.getFirstName()}</td>
				<td>${author.lastname}</td>
				<td>	<a href="executa?tarefa=DeletaAuthor&idAuthor=${author.getAuthorId()}">Delete</a> </td>
				<td> <a href="executa?tarefa=EditaAuthor&idAuthor=${author.getAuthorId()}&firstName=${author.getFirstName()}&lastName=${author.lastname}">Editar</a>     </td>
			</tr>
			</c:forEach>
		
	</table>
	</div>
	
	<br><br>
<footer class="container-fluid " style="background-color: #f2f2f2; padding: 25px;">
  <p>Laboratório de Informática</p>
</footer>
	
</body>
</html>