package br.com.fiap.entity;

import java.util.HashMap;

import org.springframework.data.annotation.Id;

import br.com.fiap.enums.TipoEndereco;
import org.springframework.data.annotation.ReadOnlyProperty;

public class Cliente {
	
	@Id
	private String id;
	
	private String nome;
	private String email;
	private HashMap<TipoEndereco, Endereco> enderecos;
	
	public Cliente(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
		this.enderecos = new HashMap<TipoEndereco, Endereco>();
	}
	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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

	public HashMap<TipoEndereco, Endereco> getEnderecos() { return this.enderecos; };

	public void setEndereco(TipoEndereco tipoEndereco, Endereco endereco) {
		this.enderecos.put(tipoEndereco, endereco);
	}
	
}
