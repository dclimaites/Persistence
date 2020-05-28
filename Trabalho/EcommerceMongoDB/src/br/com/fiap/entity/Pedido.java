package br.com.fiap.entity;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    @Id
    private String id;

    private List<Produto> itens;

    private Endereco enderecoEntrega;

    public Pedido() {
        setItens(new ArrayList<Produto>());
    }

    public Pedido(List<Produto> itens) {
       this.setItens(itens);
    }

    public void adicionarProduto(Produto produto) {
        if(this.getItens().contains(produto))
        {
            int indice = this.getItens().indexOf(produto);
            Produto prod = this.getItens().get(indice);
            prod.setQuantidade(prod.getQuantidade() + produto.getQuantidade());
        }
        else {
            this.getItens().add(produto);
        }
    }

    public void removerProduto(Produto produto) {
        this.getItens().remove(produto);
    }

    public double getTotal() {
        double valor = getItens().stream().mapToDouble(i -> i.getValor() * i.getQuantidade()).sum();

        return valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Produto> getItens() {
        return itens;
    }

    public void setItens(List<Produto> itens) {
        this.itens = itens;
    }

    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }
}
