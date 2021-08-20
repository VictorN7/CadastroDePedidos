<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style>
body .content{display: flex; justify-content: center}
.contato{width:100%; max-width: 500px;}
.form{display:flex; flex-direction:column}
.field{ padding:10px; margin-bottom: 15px; border:1px solid #DDD; border-radius: 5px; font-size:16px;}
.titulo{margin-top:10%;}
.enviar{font-weight:900; padding:10px; margin-bottom: 15px; border:1px solid #DDD; border-radius: 5px; font-size:16px;}
</style>
<title>Nota Fiscal - Final</title>
</head>
<body>
<div class="content titulo">
<h2>Nota incluida com sucesso!!</h2>
</div>

<section class="content">

	<a class="enviar" href="/SiteNotaFiscal/PedidoClienteServlet">Novo Pedido</a>
</section>
</body>
</html>