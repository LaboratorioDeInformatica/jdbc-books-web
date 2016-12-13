package com.br.labdeinf.servlet;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.labdeinf.dao.AuthorDAO;
import com.br.labdeinf.modelo.Author;
import com.br.labdeinf.utils.ConectaBanco;

//@WebServlet(urlPatterns="/novoAuthor")
//public class CadastraAuthor extends HttpServlet{
	public class CadastraAuthor implements Tarefa{	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/*
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		
		Author author = new Author(firstName, lastName);
		
		try(Connection connection = new ConectaBanco().abreConexao()) {
			AuthorDAO dao = new AuthorDAO(connection);
			dao.salva(author);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/author_cadastrado.jsp");
			req.setAttribute("author", author);
			dispatcher.forward(req, resp);
			
			PrintWriter writer = resp.getWriter();
			writer.println("<html><body>Empresa " + author.getFirstName() + " adicionada!</body></html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		 String firstName = req.getParameter("firstName");
		 String lastName = req.getParameter("lastName");
		
		 
		
		
		 if((firstName != null && firstName != "") && (lastName != null && lastName != "")){
		
			Author author = new Author(firstName, lastName);
		
			try(Connection connection = new ConectaBanco().abreConexao()) {
				AuthorDAO dao = new AuthorDAO(connection);
				dao.salva(author);
				
				
				req.setAttribute("author", author);
				
				List<Author> authors = dao.lista("", "");
		    	req.setAttribute("authors", authors);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			req.setAttribute("mensagem", "First Name e Last Name são campos obrigatorios");
		}
		 
		 return "/WEB-INF/paginas/lista_authors.jsp"; 
			
}
	}
