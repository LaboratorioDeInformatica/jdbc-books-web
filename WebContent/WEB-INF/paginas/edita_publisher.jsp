<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Edit Author</title>
 
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
		  $("#publisherNameMessage").html("Publisher Name é obrigatório");
	  }
	  
	  if(($("#publisherID").val()!="") && ($("#publisherName").val()!="")){
		  $("#frm").submit();
	  }
	
  }
  
  </script>
  
</head>
<body>

<div class="navbar ">
     
   <a href="executa?tarefa=RetornaMenu">Menu</a>
              
    </div>

<br>

<div class="container">

	<h3>Publisher Update</h3>
	<form action="executa" method="post" id="frm">
	<div class="form-group">
    Publisher ID: <input class="form-control" type="text"  readonly="true" id="publisherID" name="publisherID" value="${publisherID}"/><br />
    </div>
    <div class="form-group">
    Publisher Name : <input class="form-control" type="text" id="publisherName" name="publisherName" value="${publisherName}"/><br />
    </div>
    <input type="hidden" name="tarefa" value="UpdatePublisher">
    <input type="button" onclick="validaCampos()" value="Editar"  class="btn btn-default" />
</form>
<span id="publisherNameMessage" style="color: red"></span><br>

</div>

<br><br>
<footer class="container-fluid " style="background-color: #f2f2f2; padding: 25px;">
  <p>Laboratório de Informática</p>
</footer>
	
</body>
</html>