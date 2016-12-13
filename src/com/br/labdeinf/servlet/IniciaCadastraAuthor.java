package com.br.labdeinf.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IniciaCadastraAuthor implements Tarefa{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		 return "/WEB-INF/paginas/author_cadastrado.jsp"; 
	}

}
