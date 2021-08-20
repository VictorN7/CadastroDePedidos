<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="br.senai.sp.servlet.ListaClienteServlet"%> <%--Diretiva --%>
<%@page import="java.util.List"%> <%--Diretiva --%>
<%@page import="br.senai.sp.model.Cliente"%> <%--Diretiva --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style>
body .content{display: flex; justify-content: center}
.contato{width:100%; max-width: 800px;}
.form{display:flex; flex-direction:column}
.field{ padding:10px; margin-bottom: 15px; border:1px solid #DDD; border-radius: 5px; font-size:16px;}
</style>


<title>Nota Fiscal</title>
</head>
<body>


<div class="content">
<h1>Nota Fiscal</h1>
</div>

<section class="content">
<div class="form">

<form class="field" action="/SiteNotaFiscal/FechaNotaFiscalServlet" method="get">

<div class="form">
<label>Codigo do Pedido</label>
<input type="text" name="cod_pedido" value="${cod_pedido}"/>
</div>

<div class="form">
<label >Valor da Compra:</label>
<input class="field" type="text" name="Valor" value="${Valor}"/>
</div>
<div class="form">
	<select class="field" name="id_cliente">
	
	<c:forEach var="cliente" items="${listaCliente}">
	
		<option value="${cliente.id_cliente}">${cliente.nome}${cliente.sobrenome}</option>
		
	</c:forEach>
	</select>
</div>
<button class="field" type="submit">Enviar</button>
</form>
</div>
	
	</section>
</body>
</html>