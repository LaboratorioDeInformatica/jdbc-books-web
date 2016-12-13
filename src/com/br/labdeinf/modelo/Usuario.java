package com.br.labdeinf.modelo;

public class Usuario {
	
	String email ;
	String senha ;
	
	
	public Usuario(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	

	@Override
	public String toString() {
		return String.format("Usuario Logado : %s ",email);	}
}
