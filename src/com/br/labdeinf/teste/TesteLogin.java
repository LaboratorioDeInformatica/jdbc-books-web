package com.br.labdeinf.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.br.labdeinf.dao.UsuarioDAO;
import com.br.labdeinf.modelo.Usuario;
import com.br.labdeinf.utils.ConectaBanco;

public class TesteLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  try(Connection connection = new ConectaBanco().abreConexao()) {
		    	UsuarioDAO dao = new UsuarioDAO(connection);
		    	Usuario usuario = new Usuario("teste@teste.com","123456");
		    	List<Usuario> usuario2 =dao.buscaUsuario(usuario);
		    	if(usuario2.size()==1)
		    	System.out.printf("Teste %s",usuario2.get(0).getEmail());
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
