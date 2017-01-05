package com.br.labdeinf.servlet;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.labdeinf.dao.ISBNDAO;
import com.br.labdeinf.modelo.AuthorISBN;
import com.br.labdeinf.utils.ConectaBanco;

public class DeletaIsbn implements Tarefa{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		try(Connection connection = new ConectaBanco().abreConexao()) {
			ISBNDAO isbndao = new ISBNDAO(connection);
			int authorId = Integer.parseInt(req.getParameter("idAuthor"));
			String isbn = req.getParameter("isbn");
			isbndao.delete(authorId, isbn);
			
			List<AuthorISBN> listaIsbn = isbndao.listaISBN();
			req.setAttribute("listaIsbn",listaIsbn );
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return "/WEB-INF/paginas/isbn.jsp";
	}

}
