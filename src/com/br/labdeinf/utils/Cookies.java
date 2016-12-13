package com.br.labdeinf.utils;

import javax.servlet.http.Cookie;

public class Cookies {

	private final Cookie[] cookies;

	public Cookies(Cookie[] cookies) {
		super();
		this.cookies = cookies;
	}
	
	public Cookie getUsuarioLogado() {
	    if (cookies == null)
	        return null;
	    for (Cookie cookie : cookies) {
	        if (cookie.getName().equals("usuario.logado")) {
	            return cookie;
	        }
	    }
	    return null;
	}
}
