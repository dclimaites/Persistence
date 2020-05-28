package br.com.fiap.ui;

import br.com.fiap.entity.Pedido;
import br.com.fiap.entity.Produto;
import br.com.fiap.repository.PedidoRepository;
import br.com.fiap.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;

public class GerenciadorPedidos  extends  GerenciadorBase {
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private GerenciadorProduto produtoGer;
    private Pedido pedido;
    private List<Produto> produtos;

    public GerenciadorPedidos() {
        super();
    };

    public int Iniciar() {
        boolean encerrar = false;
        int tentativas = 0;
        System.out.println
                ("Iniciado programa de estoque/compra de produtos");
        do {

            try {

                int valorNumerico =  LerInteiro("\nEscolha uma opção: " +
                        "\n1 - Listar produtos da loja" +
                        "\n2 - Incluir Produto no pedido" +
                        "\n3 - Alterar Produto do pedido" +
                        "\n4 - Excluir produto no estoque" +
                        "\n5 - Finalizar pedido" +
                        "\n6 - Listar todos os pedidos" +
                        "\n99 - Encerrar o programa");

                switch(valorNumerico) {
                    case 1:
                        this.produtos = produtoGer.ListarProdutosEstoque();
                        break;
                    case 2:
                        IncluirProdutoNoPedido();
                        break;
                    case 3:
                        AlterarProdutoDoPedido();
                        break;
                    case 4:
                        ExcluirProdutoDoPedido();
                        break;
                    case 5:
                        CadastrarPedido();
                    case 99:
                        return 99;
                    default:
                        System.out.println("Opção não existente");
                }
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());

                System.out.println(e.getMessage());
                tentativas++;
                if(tentativas == 3) encerrar = true;
            }
        }while(!encerrar);

        return 999;
    }

    public void IncluirProdutoNoPedido() throws IOException {
        Produto produtoEscolhido = produtoGer.PesquisarProduto();


        Integer quantidade = LerInteiro("Qual a quantidade que gostaria de adicionar? Deixar em branco para apenas 1", true);
        if(quantidade != null)
            produtoEscolhido.setQuantidade(quantidade);

        if(this.pedido == null)
        {
            this.pedido = new Pedido();
        }

        if(produtoEscolhido.getQuantidade() == 0)
            this.pedido.removerProduto(produtoEscolhido);
        else
            this.pedido.adicionarProduto(produtoEscolhido);
    }

    public void AlterarProdutoDoPedido() throws IOException {

        produtoGer.ListarProdutosTela(this.pedido.getItens());

        Integer item = LerInteiro("Qual produto gostaria de alterar? Escolha o número do item.");

        if(item == null)
            return;

        Produto produtoEscolhido = this.pedido.getItens().get(item);

        Integer quantidade = LerInteiro("Qual a nova quantidade desse produto? Deixar em branco para apenas 1", true);
        if(quantidade != null)
            produtoEscolhido.setQuantidade(quantidade);

        if(this.pedido == null)
        {
            this.pedido = new Pedido();
        }

        if(produtoEscolhido.getQuantidade() == 0)
            this.pedido.removerProduto(produtoEscolhido);
        else
            this.pedido.adicionarProduto(produtoEscolhido);
    }

    public void ExcluirProdutoDoPedido() throws IOException {

        produtoGer.ListarProdutosTela(this.pedido.getItens());

        Integer item = LerInteiro("Qual produto gostaria de Excluir do pedido? Escolha o número do item.");

        if(item == null)
            return;

        Produto produtoEscolhido = this.pedido.getItens().get(item);

        Integer quantidade = LerInteiro("Qual a nova quantidade desse produto? Deixar em branco para apenas 1", true);
        if(quantidade != null)
            produtoEscolhido.setQuantidade(quantidade);

        if(this.pedido == null)
        {
            this.pedido = new Pedido();
        }

        if(produtoEscolhido.getQuantidade() == 0)
            this.pedido.removerProduto(produtoEscolhido);
        else
            this.pedido.adicionarProduto(produtoEscolhido);
    }

    public void CadastrarPedido() {
        if(pedido == null || pedido.getItens().size() == 0) {
            System.out.println("Seu carrinho está vazio");
        }
        else {
            pedidoRepository.save(this.pedido);
            this.pedido = null;
        }
    }

}
