package com.br.labdeinf.servlet;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.labdeinf.dao.PublishersDAO;
import com.br.labdeinf.modelo.Publisher;
import com.br.labdeinf.utils.ConectaBanco;

public class ListarPublisher implements Tarefa{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		try(Connection connection = new ConectaBanco().abreConexao()){
			PublishersDAO dao = new PublishersDAO(connection);
			List<Publisher> listaPublisher = dao.listarTodos(); 
			
			req.setAttribute("listaPublisher", listaPublisher);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/WEB-INF/paginas/publisher.jsp";
	}

}
