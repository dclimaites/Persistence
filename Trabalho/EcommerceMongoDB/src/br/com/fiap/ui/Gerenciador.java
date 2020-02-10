package br.com.fiap.ui;

import br.com.fiap.entity.Produto;
import br.com.fiap.repository.ProdutoRepository;

import javax.swing.*;

public class Gerenciador {
    private boolean cancelarOpcao;
    private boolean valorInvalido;
    private ProdutoRepository produtoRepository;

    public Gerenciador(ProdutoRepository produtoRepo) {
        produtoRepository = produtoRepo;
        valorInvalido = true;
    }

    public void CadastrarProduto() {

        /*String descricao = JOptionPane.showInputDialog("Entre com o nome do produto?");*/
        double valorReal = 999999999;
        do{
            try {
                JOptionPane.showInputDialog("Entre com o nome do produto?");
                String valor = JOptionPane.showInputDialog("Qual é o valor?");
                valorReal = Double.parseDouble(valor);
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Valor digitado está incorreto.");
                valorInvalido = true;
            }
        }while(valorInvalido);

    /*Produto produto = new Produto(descricao, valorReal);
    produtoRepository.save(produto);*/

    }
}
