package br.senai.sp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.dao.ClienteDao;
import br.senai.sp.model.Cliente;
import br.senai.sp.model.DetalhePedido;
import br.senai.sp.model.FecharNota;


@WebServlet("/FechaNotaFiscalServlet")
public class FechaNotaFiscalServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	String codigo = request.getParameter("cod_pedido");
	String vlr_Total = request.getParameter("Valor");
	int idCliente = Integer.parseInt(request.getParameter("id_cliente"));
	
	ClienteDao dao = new ClienteDao();
	List<DetalhePedido> todosItens = dao.listarDetItens(codigo);
	
	Cliente cliente = new Cliente();
	cliente = dao.BuscarCliPorId(idCliente);
	
//	FecharNota fnota = new FecharNota(idCliente, codigo);
	
	RequestDispatcher dispa = request.getRequestDispatcher("/fechaNota.jsp");
	
	request.setAttribute("idCli", idCliente);
	request.setAttribute("codd", codigo);
	request.setAttribute("itensComprados", todosItens);
	request.setAttribute("clienteFinal", cliente);
	request.setAttribute("ValorTotal", vlr_Total);
	
	dispa.forward(request, response);
	
		
	}

	
}
