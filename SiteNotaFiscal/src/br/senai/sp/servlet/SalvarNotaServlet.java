package br.senai.sp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.dao.ClienteDao;
import br.senai.sp.model.FecharNota;


@WebServlet("/SalvarNotaServlet")
public class SalvarNotaServlet extends HttpServlet {
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codigo_cli = Integer.parseInt(request.getParameter("cli"));
		String codigo = request.getParameter("codd");
		
		ClienteDao  dao = new ClienteDao();
		if (dao.salvarNota(codigo, codigo_cli)) {
		
		}
		
		RequestDispatcher dispa = request.getRequestDispatcher("/final.jsp");
		
		dispa.forward(request, response);
	

		
	}
}
