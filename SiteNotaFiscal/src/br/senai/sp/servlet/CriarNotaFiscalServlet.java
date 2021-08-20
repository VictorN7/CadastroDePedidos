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


@WebServlet("/CriarNotaFiscalServlet")
public class CriarNotaFiscalServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
			String codigo = request.getParameter("codigo");
			int prod = Integer.parseInt(request.getParameter("prod")) ;
			int quant = Integer.parseInt(request.getParameter("quant"));
			
			DetalheDaNota detNota = null; 
			
			detNota = new DetalheDaNota(codigo, prod, quant);
			
			
			ClienteDao dao = new ClienteDao();
			List<DetalhePedido> listaDetPedido;
			
			if (dao.novoDetItem(detNota)) {
				
				
				ClienteDao clienteDao = new ClienteDao();
				List<Item> listagem = clienteDao.listarItens();

				RequestDispatcher dis = request.getRequestDispatcher("/itensnotafiscal.jsp");
				
				request.setAttribute("listaItem", listagem);
			
				
				listaDetPedido = dao.listarDetItens(detNota.getCod_pedidos());
				
			
				
				String ocodigo = detNota.getCod_pedidos();
				
				request.setAttribute("oCodigo", ocodigo);
				
				request.setAttribute("listaPedido", listaDetPedido);
				
				dis.forward(request, response);
			}
			else {

				System.out.println("Error");
			}
			
			
	}

}
