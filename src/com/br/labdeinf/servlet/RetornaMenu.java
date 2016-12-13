package com.br.labdeinf.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RetornaMenu implements Tarefa{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		
		String pagina = null;
		try {
			
			 HttpSession session = req.getSession(true);
			if(session!=null){
				return  pagina="/WEB-INF/paginas/menu.jsp";
			}else{
				return pagina = "index.jsp";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return pagina;
		
	}

}
