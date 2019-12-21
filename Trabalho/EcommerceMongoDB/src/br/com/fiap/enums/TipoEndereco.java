package br.com.fiap.enums;

public enum TipoEndereco {
	ENTREGA(1), RESIDENCIAL(2), TRABALHO(3), OUTROS(4);
	
	private final int valor;
	TipoEndereco(int valor) {
		this.valor = valor;
	}
	public int getValor() {
		return valor;
	}
}
