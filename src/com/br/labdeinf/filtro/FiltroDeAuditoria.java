package com.br.labdeinf.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.br.labdeinf.modelo.Usuario;

@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpSession session = req.getSession();
		
		 Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		
		String usuario ="<usuarioDeslogado>";
		
		if(usuarioLogado != null){
			usuario = usuarioLogado.getEmail();
		}
		
		/*Cookie cookie=	getUsuario(req);
		String usuario ="<usuario.deslogado>";
		if(cookie != null){
			usuario = cookie.getValue();
			
		}*/
	    System.out.println("Usuario acessando a URI " + req.getRequestURI()+"-"+usuario);
	    chain.doFilter(request, response);
	}

/*	private Cookie getUsuario(HttpServletRequest req) {

	    Cookie[] cookies = req.getCookies();

	    if (cookies == null)
	        return null;
	    
	    for (Cookie cookie : cookies) {
	        if (cookie.getName().equals("usuarioLogado")) {
	            return cookie;
	        }
	    }

	    return null;
	}*/

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
