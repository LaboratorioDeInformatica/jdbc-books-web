package com.br.labdeinf.servlet;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.labdeinf.dao.PublishersDAO;
import com.br.labdeinf.modelo.Publisher;
import com.br.labdeinf.utils.ConectaBanco;

public class DeletaPublisher implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
	
		try (Connection connection = new ConectaBanco().abreConexao()){
			
			PublishersDAO dao =  new PublishersDAO(connection);
			
			int publihserId = Integer.parseInt(req.getParameter("publisherID"));
			
			dao.remove(publihserId);
			
			List<Publisher> listaPublisher = dao.listarTodos(); 
			
			req.setAttribute("listaPublisher", listaPublisher);
			
		} catch (Exception e) {
			System.out.println("metodo executa da classe DeletaPublisher"+e);
		}
		
		 return "/WEB-INF/paginas/publisher.jsp";
		
	}
	
	

}
