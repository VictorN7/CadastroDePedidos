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
import br.senai.sp.model.DetalheDaNota;
import br.senai.sp.model.DetalhePedido;
import br.senai.sp.model.Item;


@WebServlet("/PedidoClienteServlet")
public class PedidoClienteServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		ClienteDao clienteDao = new ClienteDao();
		List<Item> listagem = clienteDao.listarItens();

		RequestDispatcher dispa = request.getRequestDispatcher("/itensnotafiscal.jsp");
		
		request.setAttribute("listaItem", listagem);
		
		dispa.forward(request, response);
		
		
		
		

	}

}
