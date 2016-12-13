package com.br.labdeinf.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.br.labdeinf.dao.AuthorDAO;
import com.br.labdeinf.modelo.Author;
import com.br.labdeinf.utils.ConectaBanco;



public class CadastraAuthorTeste {

	public static void main(String args[]) throws SQLException{
		
		Author author = new Author("Bryan","Bashan");
		
		try(Connection connection = new ConectaBanco().abreConexao()) {
			AuthorDAO dao = new AuthorDAO(connection);
			dao.salva(author);
			List<Author> authors = dao.lista(null, null);
			for (Author author2 : authors) {
				System.out.println("Autor cadastrado " +author2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
