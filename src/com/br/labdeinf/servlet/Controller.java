package com.br.labdeinf.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (urlPatterns="/executa")
public class Controller  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String tarefa = req.getParameter("tarefa");
		
		if(tarefa == null){
			throw new IllegalArgumentException("Tarefa não passada");
		}
		
		String nomeDaClasse= "com.br.labdeinf.servlet." + tarefa;
		
		Class type;
		try {
			type = Class.forName(nomeDaClasse);
			Tarefa instancia = (Tarefa) type.newInstance();
			//instancia.executa(req, resp);
			
			String pagina = instancia.executa(req, resp);
			
			RequestDispatcher dispatcher =req.getRequestDispatcher(pagina);
			dispatcher.forward(req, resp);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
