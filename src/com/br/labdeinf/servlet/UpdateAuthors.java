package com.br.labdeinf.servlet;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.labdeinf.dao.AuthorDAO;
import com.br.labdeinf.modelo.Author;
import com.br.labdeinf.utils.ConectaBanco;

public class UpdateAuthors implements Tarefa{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		
		String pagina = null;
		Integer idAuthor = Integer.parseInt( req.getParameter("idAuthor"));
		String fisrtName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		
		Author author = new Author(fisrtName, lastName);
		try(Connection connection = new ConectaBanco().abreConexao()) {
		AuthorDAO authorDAO =  new AuthorDAO(connection);
		
		authorDAO.edita(author, idAuthor);
		List<Author> authors = authorDAO.lista("", "");
    	req.setAttribute("authors", authors);
		pagina = "/WEB-INF/paginas/lista_authors.jsp";
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pagina;
	}
	
	

}
