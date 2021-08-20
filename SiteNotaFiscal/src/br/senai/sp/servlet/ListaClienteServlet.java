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



@WebServlet("/ListaClienteServlet/*")
public class ListaClienteServlet extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		
		String retiraBarra [] = pathInfo.split("/");
		
		ClienteDao clienteDao = new ClienteDao();
		List<Cliente> listagem = clienteDao.listarCliente();
		
		String valorTotal = clienteDao.BuscarPorCodigo(retiraBarra[1]);
		
		
		RequestDispatcher dispa = request.getRequestDispatcher("/index.jsp");
		
		request.setAttribute("listaCliente", listagem);
		request.setAttribute("Valor", valorTotal);
		
		request.setAttribute("cod_pedido", retiraBarra[1]);
		
		dispa.forward(request, response);
	}


}
