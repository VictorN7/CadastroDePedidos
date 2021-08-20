<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="br.senai.sp.servlet.PedidoClienteServlet"%> <%--Diretiva --%>


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
.titulo{align-items: center;}
.enviar{font-weight:900; padding:10px; margin-bottom: 15px; border:1px solid #DDD; border-radius: 5px; font-size:16px;}
</style>

    
<title>Itens da Nota Fiscal</title>
</head>

<body>
<div class="content">
<h1>Cadastro de Pedidos</h1>
</div>
<section class="content">
	
	

<div class="form">

	<form action="/SiteNotaFiscal/CriarNotaFiscalServlet" method="post" >
	
			<div class="form">
			<label for="codigo">Codigo do Pedido</label>
			<input class="field" type="text" name="codigo" id="codigo"/>
			</div>
		
			<div class="form">	
			<label>Itens</label>
			<select class="field" id="prod" name="prod">
			</div>
			<c:forEach var="item" items="${listaItem}">
			
				<option value="${item.id_item}">${item.descricao}</option>
				
			</c:forEach>
			</select>
			<label for="quant">Quantidade:</label>
			<input class="field" type="number" id="quant" name="quant" min="1" max="20">
		
			<input class="enviar" type="submit" name="btnGravar" />

	</form>
	

	
	<div class="container">
<h2>Tabela de Itens</h2>
<table class="table table-bordered">
	
	<tr>
	<th>Código pedidos</th>
	<th>Descrição</th>
	<th>Quantidade</th>
	<th>Valor Unitario</th>
	<th>Valor Total</th>
	</tr>
	
		<c:forEach var="pedido" items="${listaPedido}">
		
			<tr>
				<td>${pedido.cod_pedidos}</td>
				<td>${pedido.descricao}</td>
				<td>${pedido.quantidade}</td>
				<td>${pedido.valor_unitario}</td>
				<td>${pedido.valor_total}</td>
			</tr>
			
		</c:forEach>

		</table>
		
	<a class="enviar" href="/SiteNotaFiscal/ListaClienteServlet/${oCodigo}">Continue</a>
		</div>
	</section>
</body>
</html>