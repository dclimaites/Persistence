package br.com.fiap.entity;

import org.springframework.data.annotation.Id;

public class Cliente {
	
	@Id
	private String id;
	
	private String Nome;
	private String email;
	
	
	public Cliente(String nome, String email) {
		super();
		Nome = nome;
		this.email = email;
	}
	
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
