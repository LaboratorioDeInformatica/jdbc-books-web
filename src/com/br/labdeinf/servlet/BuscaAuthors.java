package com.br.labdeinf.servlet;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

import com.br.labdeinf.dao.AuthorDAO;
import com.br.labdeinf.modelo.Author;
import com.br.labdeinf.modelo.Usuario;
import com.br.labdeinf.utils.ConectaBanco;
//@WebServlet(urlPatterns="/buscaAuthor")
//public class BuscaAuthors extends HttpServlet{
public class BuscaAuthors implements Tarefa{

	
	 public BuscaAuthors() {
		System.out.print("Instanciando a servlet"+this);
	}

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		
		
		 HttpSession session = req.getSession(true);
		
		
		String fName = req.getParameter("firstName");
		String lName = req.getParameter("lastName");
		
		if(fName == null){
			fName = "";
		}
		
		if(lName == null){
			lName = "";
		}
	
		try(Connection connection = new ConectaBanco().abreConexao()) {
		    	AuthorDAO dao = new AuthorDAO(connection);
		    	List<Author> authors = dao.lista(fName, lName);
		    	
		    	req.setAttribute("authors", authors);
				
		    } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("usuario buscado com sucesso");
		
		return "/WEB-INF/paginas/lista_authors.jsp";
	}
	 
/*	 @Override
	 public void init() throws ServletException {
	     System.out.println("Inicializando a Servlet " + this);
	 }

	 @Override
	 public void destroy() {
	     System.out.println("Destruindo a Servlet " + this);
	 }*/
/*
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {
		
	    PrintWriter writer = resp.getWriter();
	    writer.println("<html>");
	    writer.println("<body>");
	    writer.println("Resultado da busca Authors:<br/>");
	    
	    try(Connection connection = new ConectaBanco().abreConexao()) {
	    	AuthorDAO dao = new AuthorDAO(connection);
	    	List<Author> authors = dao.lista();
	    	
	    	req.setAttribute("authors", authors);
	    	
	    	RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/lista_authors.jsp");
	    	dispatcher.forward(req, resp);
	    	
	    	writer.println("<ul>");
	    	
			for (Author author2 : authors) {
				 writer.println("<li>" + author2.getAuthorId() + ": " + author2.getFirstName() + ":"+ author2.getLastname()+"</li>");
			}
			 writer.println("</ul>");
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    writer.println("</body>");
	    writer.println("</html>");
		
		
	}*/
}
