package br.com.fiap.ui;

public enum OpcoesEnum {

    CADASTRAR_PRODUTO(1),
    ENCERRAR_PROGRAMA(99);

    private int numero;
    OpcoesEnum(int _numero){
        this.numero = _numero;
    }

    public int getValor() {
        return this.numero;
    };
}
