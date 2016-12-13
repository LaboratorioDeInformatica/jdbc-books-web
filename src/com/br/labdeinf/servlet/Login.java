package com.br.labdeinf.servlet;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.br.labdeinf.dao.UsuarioDAO;
import com.br.labdeinf.modelo.Usuario;
import com.br.labdeinf.utils.ConectaBanco;
//@WebServlet(urlPatterns="/login")
//public class Login extends HttpServlet {
public class Login implements Tarefa {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		String pagina = null;
		
		Usuario loginUsuario = new Usuario(email, senha);
		
		  try(Connection connection = new ConectaBanco().abreConexao()) {
			  
			  UsuarioDAO daoLogin = new UsuarioDAO(connection);
			 
			  List<Usuario> usuario = daoLogin.buscaUsuario(loginUsuario);
			  
			  if( usuario.size()==0){
				  req.setAttribute("usuario", usuario);
				  pagina = "index.jsp";
				
			  }else{
				
				  req.setAttribute("usuario", usuario);
				  HttpSession session = req.getSession();
				  session.setAttribute("usuarioLogado", usuario.get(0));
				  //pagina = "index.jsp";
				  pagina="/WEB-INF/paginas/menu.jsp";
			  }
			  
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return pagina;
	
	}

	/*@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		Usuario loginUsuario = new Usuario(email, senha);
		
		  try(Connection connection = new ConectaBanco().abreConexao()) {
			  
			  UsuarioDAO daoLogin = new UsuarioDAO(connection);
			 
			  List<Usuario> usuario = daoLogin.buscaUsuario(loginUsuario);
			  
			  if( usuario.size()==0){
				 
				  writer.println("<html><body>Usuario ou senha inválida</body></html>");
			  }else{
				 /* Cookie cookie = new Cookie("usuario.logado", usuario.get(0).getEmail());
		            resp.addCookie(cookie);
		            cookie.setMaxAge(10*60);
				  HttpSession session = req.getSession();
				  session.setAttribute("usuarioLogado", usuario.get(0));
				  writer.println("<html><body>Usuario Logado"+usuario.get(0).getEmail()+"</body></html");
				  
			  }
			  
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}*/
	
	
}
