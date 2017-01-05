package com.br.labdeinf.servlet;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.labdeinf.dao.PublishersDAO;
import com.br.labdeinf.modelo.Publisher;
import com.br.labdeinf.utils.ConectaBanco;

public class CadastraPublisher implements Tarefa{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String pagina = "/WEB-INF/paginas/publisher.jsp";
		
		String publisherName =  req.getParameter("publisherName");
		
		if(!publisherName.equals("")){
			try(Connection connection = new ConectaBanco().abreConexao()) {
				PublishersDAO dao = new PublishersDAO(connection);
				dao.salva(publisherName);
				
				List<Publisher> listaPublisher = dao.listarTodos(); 
				
				req.setAttribute("listaPublisher", listaPublisher);
				
			} catch (Exception e) {
				System.out.println("problemas no metodo executa da classe CadastraPublisher: "+e);
			}
			
		}else{
			req.setAttribute("mensagem", "Publihser é Obrigatorio");
			pagina = "/WEB-INF/paginas/cadastra_publisher.jsp";
		}
		
		return pagina;
		
	}

}
