<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous" />
<title>Insert title here</title>
</head>
<body>

<form class="form-signin" action="LogarServlet" method="post">
	
		<div class="text-center mb-4">
			<img class="mb-4" src="" alt="" width="72" height="72" />
				<h1 class="h3 mb-3 font-weight-normal">Faça seu login</h1>
				<br />
		</div>
		
		<div class="form-label-group">
			<div class="col-md-4 offset-md-4">
				<label for="inputEmail">Endereço de email</label>
				<input type="text" id="inputEmail"  class="form-control" placeholder="Email" name="login"></input>
			</div>
		</div>
		
		<div class="form-label-group">
			<div class="col-md-4 offset-md-4">
				<label for="inputPassword">Senha</label>
				<input type="password" id="inputPassword" class="form-control" placeholder="Senha" name="senha" ></input>
			</div>	
		</div>
		<br/>
		
		<div class="col-md-4 offset-md-4 text-center">
			<input class="btn btn-primary" type="submit" value="login"/>
		</div>
	

	</form>

</body>
</html>