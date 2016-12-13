package com.br.labdeinf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.br.labdeinf.modelo.Usuario;

public class UsuarioDAO {

	private Connection connection;

	public UsuarioDAO(Connection connection) {

		this.connection = connection;
	}
	
	
	public List<Usuario> buscaUsuario(Usuario usuario){
		
		List<Usuario> usuarios = new ArrayList<>();
		String sql = "SELECT  email, senha FROM books.users where email = ? and senha = ?";
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1,usuario.getEmail());
			statement.setString(2,usuario.getSenha());
			statement.execute();
			try(ResultSet rs = statement.getResultSet()){
				while(rs.next()){
				String email = rs.getString("email"); 
				String senha = rs.getString("senha");
				
				Usuario usuarioRet = new Usuario(email, senha);
				usuarios.add(usuarioRet);
				}
			}
			
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
		
		
		return usuarios;
	}
	
}
