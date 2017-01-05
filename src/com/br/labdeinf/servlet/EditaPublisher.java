package com.br.labdeinf.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditaPublisher implements Tarefa{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		
		String pagina = null;
		
		String publisherID = req.getParameter("publisherID");
		String publisherName = req.getParameter("publisherName");
		
		if(publisherID != "" && publisherName!=""){
			
			try {
				req.setAttribute("publisherID", publisherID);
				req.setAttribute("publisherName", publisherName);
				pagina = "/WEB-INF/paginas/edita_publisher.jsp";
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
		return pagina;
	}

}
