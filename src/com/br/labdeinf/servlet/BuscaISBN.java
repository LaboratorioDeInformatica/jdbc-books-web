package com.br.labdeinf.servlet;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.labdeinf.dao.ISBNDAO;
import com.br.labdeinf.modelo.AuthorISBN;
import com.br.labdeinf.utils.ConectaBanco;

public class BuscaISBN implements Tarefa{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		
		String firstName = req.getParameter("firstName");
		if(firstName.equals(null)){
			firstName = "";
		}
		String lastName = req.getParameter("lastName");
		if(lastName.equals(null)){
			lastName = "";
		}
		String isbn = req.getParameter("isbn");
		if(isbn.equals(null)){
			isbn = "";
		}
		
		try(Connection connection = new ConectaBanco().abreConexao()){
			
			List<AuthorISBN> listaISBN = new ArrayList<AuthorISBN>();
			ISBNDAO dao = new ISBNDAO(connection);
			listaISBN = dao.buscaSimilaridade(firstName, lastName, isbn); 
			
			req.setAttribute("listaIsbn", listaISBN);
			
		} catch (SQLException e) {
			System.out.println("BuscaISBN->Problema ao executar busca no banco de dados"+e);
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("BuscaISBN->"+e);
			e.printStackTrace();
		}
		
		return "/WEB-INF/paginas/isbn.jsp";
	}

}
