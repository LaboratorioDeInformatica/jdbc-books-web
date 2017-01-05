package com.br.labdeinf.servlet;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.labdeinf.dao.PublishersDAO;
import com.br.labdeinf.modelo.Publisher;
import com.br.labdeinf.utils.ConectaBanco;

public class UpdatePublisher implements Tarefa{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		
		String pagina = null;
		
		String publisherID = req.getParameter("publisherID");
		String publisherName = req.getParameter("publisherName");
		
		try (Connection connection = new ConectaBanco().abreConexao()){
			
			PublishersDAO dao = new PublishersDAO(connection);
			
			dao.update(Integer.parseInt(publisherID), publisherName);
			
			List<Publisher> listaPublisher = dao.listarTodos(); 
			req.setAttribute("listaPublisher", listaPublisher);
			
			pagina = "/WEB-INF/paginas/publisher.jsp";
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return pagina;
	}

	
}
