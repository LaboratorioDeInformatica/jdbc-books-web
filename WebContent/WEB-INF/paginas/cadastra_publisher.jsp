<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastra Publihser</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <script src=" https://code.jquery.com/jquery-1.12.4.js"></script>
 <script src="  https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
 
  <script type="text/javascript">
  	
  function validaCampos(){
	  
	  if($("#publisherName").val()==""){
		  $("#publisherNameMessage").html("Publisher é obrigatório");
	  }
	  
	  if(($("#publisherName").val()!="")){
		  $("#frm").submit();
	  }
  }
  
  </script>
 
</head>
<body>

<div class="container">

	<a href="executa?tarefa=RetornaMenu">Menu</a><br>
	<h4>${mensagem}</h4>
	
	<form action="executa" method="post" id="frm">
	<div class="form-group">
   
    Publisher : <input  class="form-control" type="text" name="publisherName" id="publisherName"/><br />
    <input type="hidden" name="tarefa" value="CadastraPublisher">
    <input type="button" value="Enviar" onclick="validaCampos()" class="btn btn-default" />
    </div>
  
</form>
<span id="publisherNameMessage" style="color: red"></span><br>

</div>

</body>
</html>