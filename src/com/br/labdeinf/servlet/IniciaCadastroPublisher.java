package com.br.labdeinf.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IniciaCadastroPublisher implements Tarefa{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		return "/WEB-INF/paginas/cadastra_publisher.jsp"; 
	}

}
