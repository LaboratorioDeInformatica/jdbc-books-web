package com.br.labdeinf.servlet;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.labdeinf.dao.AuthorDAO;
import com.br.labdeinf.modelo.Author;
import com.br.labdeinf.utils.ConectaBanco;

public class DeletaAuthor implements Tarefa {

	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
	
		try(Connection connection = new ConectaBanco().abreConexao()) {
		    	AuthorDAO dao = new AuthorDAO(connection);
		    	int authorId = Integer.parseInt(req.getParameter("idAuthor"));
		    	dao.delete(authorId);
		    	
		    	List<Author> authors = dao.lista("", "");
		    	req.setAttribute("authors", authors);
		    	
		    	
		   } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return "/WEB-INF/paginas/lista_authors.jsp";
		
	}
	
}
