package com.br.labdeinf.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditaAuthor implements Tarefa{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		Integer idAuthor =Integer.parseInt( req.getParameter("idAuthor"));
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		
		String pagina = null;
		try {
			req.setAttribute("firstName", firstName);
			req.setAttribute("idAuthor", idAuthor);
			req.setAttribute("lastName", lastName);
			pagina="/WEB-INF/paginas/edita_author.jsp";
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return  pagina ;
	}

}
