package br.com.fiap.entity;

import org.springframework.data.annotation.Id;

public class Produto {
	
	@Id
	private String id;
	private String descricao;
	private double valor;
	
	public Produto(String descricao, double valor) {
		setDescricao(descricao);
		setValor(valor);
	}
	
		
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
