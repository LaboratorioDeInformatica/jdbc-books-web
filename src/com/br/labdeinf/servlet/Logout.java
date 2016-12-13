package com.br.labdeinf.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//@WebServlet(urlPatterns="/logout")
//public class Logout extends HttpServlet {

public class Logout implements Tarefa {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/*
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Cookie cookie = new Cookies(req.getCookies()).getUsuarioLogado();
		
		if(cookie!=null){
			cookie.setMaxAge(0);
			resp.addCookie(cookie);
		}
		
		HttpSession session = req.getSession();
		
		session.removeAttribute("usuario.logado");
		
		
		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>Usuario deslogado<body></html>");
		
		RequestDispatcher dispacher = req.getRequestDispatcher("/WEB-INF/paginas/logout.html");
		dispacher.forward(req, resp);
		
	}*/

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		
		
		HttpSession session = req.getSession();
		session.removeAttribute("usuarioLogado");
		
		return "/WEB-INF/paginas/logout.html";
		
	}
}
