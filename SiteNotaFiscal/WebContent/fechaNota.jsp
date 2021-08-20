<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="br.senai.sp.servlet.FechaNotaFiscalServlet"%> <%--Diretiva --%>
<%@page import="br.senai.sp.model.Cliente"%> <%--Diretiva --%>
<%@page import="br.senai.sp.model.FecharNota"%> <%--Diretiva --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
</style>
<title>Insert title here</title>
</head>
<body>

<div class="content">
<h1>Finalizar Pedido</h1>
</div>

<section class="content">


<form action="/SiteNotaFiscal/SalvarNotaServlet" method="post">
<div>

	<table class="table table-bordered">
		
		<tr>
		<th>ID do cliente</th>
		<th>Nome do Cliente</th>
		<th>Sobrenome</th>
		<th>CPF</th>
	
	
		</tr>
		
		<% Cliente cliente = (Cliente) request.getAttribute("clienteFinal"); %>
			
				<tr>
					<td><%= cliente.getId_cliente()%></td>
					<td><%= cliente.getNome() %></td>
					<td><%= cliente.getSobrenome()%></td>
					<td><%= cliente.getCpf() %></td>
					
				</tr>
				
			
	
	</table>
</div>

<div>
	<table class="table table-bordered">
		
		<tr>
		<th>Código pedidos</th>
		<th>Descrição</th>
		<th>Quantidade</th>
		<th>Valor Unitario</th>
		<th>Valor Total</th>
		</tr>
		
			<c:forEach var="itens" items="${itensComprados}">
			
				<tr>
					<td>${itens.cod_pedidos}</td>
					<td>${itens.descricao}</td>
					<td>${itens.quantidade}</td>
					<td>${itens.valor_unitario}</td>
					<td>${itens.valor_total}</td>
					
				</tr>
				
			</c:forEach>
	
	</table>
</div>



		
<label>Total da Compra</label>
<% String codd = (String) request.getAttribute("codd"); %>
<% int idd = (int) request.getAttribute("idCli"); %>

<input  class="field" type="hidden" name="codd" value="<%= codd %>"/>
<input  class="field" type="hidden" name="cli" value="<%= idd %>"/>
<input  class="field" type="text" name="cod_pedido" value="${ValorTotal}"/>

<button class="field"type="submit">Finalizar</button>

</form>
</section>
</body>
</html>