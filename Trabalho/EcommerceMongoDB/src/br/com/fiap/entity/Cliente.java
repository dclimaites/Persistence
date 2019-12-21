package br.com.fiap.entity;

import java.util.HashMap;

import org.springframework.data.annotation.Id;

import br.com.fiap.enums.TipoEndereco;

public class Cliente {
	
	@Id
	private String id;
	
	private String Nome;
	private String email;
	private HashMap<TipoEndereco, Endereco> enderecos;
	
	public Cliente(String nome, String email) {
		super();
		Nome = nome;
		this.email = email;
		this.enderecos = new HashMap<TipoEndereco, Endereco>();
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
	
	public void setEndereco(TipoEndereco tipoEndereco, Endereco endereco) {
		this.enderecos.put(tipoEndereco, endereco);
	}
	
}
