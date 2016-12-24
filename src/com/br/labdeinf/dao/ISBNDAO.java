package com.br.labdeinf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.br.labdeinf.modelo.Author;
import com.br.labdeinf.modelo.AuthorISBN;

public class ISBNDAO {
	
	private Connection connection;

	public ISBNDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public List<AuthorISBN> listaISBN () throws SQLException{
		
		List<AuthorISBN> lista = new ArrayList<AuthorISBN>();
		
		String sql =" SELECT  firstName , lastName , isbn , isbn.authorID FROM books.authors AS author INNER JOIN books.authorisbn AS isbn where author.authorID = isbn.authorID" ;
		
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			
			statement.execute();
			try (ResultSet rs = statement.getResultSet()){
				while(rs.next()){
					AuthorISBN authorIsbn = new AuthorISBN();
					Author author = new Author(rs.getString("firstName"),rs.getString("lastName"));
					authorIsbn.setAuthor(author);
					authorIsbn.setIsbn(rs.getString("isbn"));
					authorIsbn.setAuthorID(rs.getInt("isbn.authorID"));
					lista.add(authorIsbn);
				}
				
			} catch (Exception e) {
				System.out.println("Erro ao executar o metodo listaISBN :" +e);
			}
		}
		
		return lista;
		
		
	}
	
	public List<AuthorISBN> buscaSimilaridade(String firstName, String lastName , String isbn){
		
		List<AuthorISBN> lista = new ArrayList<AuthorISBN>();
		
		String sql ="Select  firstName , lastName , isbn, isbn.authorID from books.authors as author inner join books.authorisbn as isbn  where author.authorID = isbn.authorID " ;
		
		if(!firstName.equals("")){
			sql = sql + " and firstName LIKE '%"+firstName+"%' ";
		}
		
		if(!lastName.equals("")){
			sql = sql + " and lastName LIKE '%"+lastName+"%' ";
		}
		
		if(!isbn.equals("")){
			sql = sql + " and isbn LIKE '%"+isbn+"%' ";
		}
		
		
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.execute();
			
			try(ResultSet rs = statement.getResultSet()){
				while(rs.next()){
					AuthorISBN authorIsbn = new AuthorISBN();
					Author author = new Author(rs.getString("firstName"),rs.getString("lastName"));
					authorIsbn.setAuthor(author);
					authorIsbn.setIsbn(rs.getString("isbn"));
					authorIsbn.setAuthorID(rs.getInt("isbn.authorID"));
					lista.add(authorIsbn);
				}
			}
			
		} catch (SQLException e) {
			System.out.println("problemas ao executar o sql buscaSimilaridade"+e);
			e.printStackTrace();
		}
		
		return lista;
	}
		
	
	public void delete(int authorID,  String isbn){
		String sql  = "Delete from books.authorisbn where isbn=? and authorID = ?";
		
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1, isbn);
			statement.setInt(2, authorID);
			statement.execute();
			
		} catch (SQLException e) {
			System.out.println("Problemas ao executar o sql delete"+e);
			e.printStackTrace();
		}
	}

}
