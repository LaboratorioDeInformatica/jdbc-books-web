package com.br.labdeinf.servlet;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.labdeinf.dao.ISBNDAO;
import com.br.labdeinf.modelo.AuthorISBN;
import com.br.labdeinf.utils.ConectaBanco;

public class ListaIsbn implements Tarefa{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		
		try(Connection connection = new ConectaBanco().abreConexao()){
			
			ISBNDAO isbndao = new ISBNDAO(connection);
			List<AuthorISBN> listaIsbn = isbndao.listaISBN();
			
			req.setAttribute("listaIsbn", listaIsbn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "/WEB-INF/paginas/isbn.jsp";
	}

}
