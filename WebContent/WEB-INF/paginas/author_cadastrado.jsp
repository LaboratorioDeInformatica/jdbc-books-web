<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Author</title>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="text/javascript">
  	
  function validaCampos(){
	  
	  if($("#firstName").val()==""){
		  $("#firsNameMessage").html("Fisrt Name é obrigatório");
	  }
	  
	  if($("#lastName").val()==""){
		  $("#lastaNameMessage").html("Last Name é obrigatório");
	  }
	  
	  if(($("#firstName").val()!="") && ($("#lastName").val()!="")){
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
    First Name: <input  class="form-control" type="text" name="firstName"  id="firstName"/><br />
    Last Name : <input  class="form-control" type="text" name="lastName" id="lastName"/><br />
    <input type="hidden" name="tarefa" value="CadastraAuthor">
    <input type="button" value="Enviar" onclick="validaCampos()" class="btn btn-default" />
    </div>
  
</form>
<span id="firsNameMessage" style="color: red"></span><br>
<span id="lastaNameMessage" style="color: red" ></span>
</div>

</body>
</html>