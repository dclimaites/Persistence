package br.com.fiap.entity;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Produto {
	
	@Id
	private String id;
	private String descricao;
	private double valor;
	private int quantidade;

	public Produto(String descricao, double valor, int quantidade) {
		setDescricao(descricao);
		setValor(valor);
		setQuantidade(quantidade);
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

	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "\nProduto " + this.getDescricao() + " - R$ " + getValor() + "\nEm estoque: " + getQuantidade();
	}
}
