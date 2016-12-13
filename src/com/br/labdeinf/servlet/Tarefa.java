package com.br.labdeinf.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Tarefa {

	String executa (HttpServletRequest req, HttpServletResponse resp);
}
