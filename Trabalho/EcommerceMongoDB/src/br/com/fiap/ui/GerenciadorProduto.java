package br.com.fiap.ui;

import br.com.fiap.entity.Produto;
import br.com.fiap.repository.ClienteRepository;
import br.com.fiap.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@EnableMongoRepositories(basePackageClasses =  ProdutoRepository.class)
@SpringBootApplication
@Service
public class GerenciadorProduto extends  GerenciadorBase {

    @Autowired
    private ProdutoRepository produtoRepository;

    public GerenciadorProduto() {
        super();
    }

    public void CadastrarProduto() {
        double valorReal = 999999999;
        int tentativas = 0;
        do{
            try {

                String descricao = LerTexto("Digite a descrição do produto?");

                valorReal = LerDouble("Qual é o valor do produto?");

                int quantidade = LerInteiro("Qual é a quantidade em estoque do produto?");

                produtoRepository.save(new Produto(descricao, valorReal, quantidade));
                System.out.println("Produto cadastrado com sucesso");
                tentativas = 4;
            }
            catch (NumberFormatException e) {
                System.out.println("Valor digitado está incorreto.");
                tentativas++;
            }
            catch (Exception e) {
                tentativas++;
                System.out.println(e.getStackTrace());
                System.out.println(e.getMessage());
                System.out.println("Genérico: Valor informado não é válido");
            }

        }while(tentativas <= 3);

    }

    public void AlterarProduto() {
        int tentativas = 0;
        List<Produto> produtos = null;
        do{
            try {

                if(produtos == null)
                    produtos = ListarProdutosEstoque();

                String indice = LerTexto("Qual produto gostaria de alterar? Digite o número/ Aperte B para Buscar por Nome");

                Produto produtoParaAlterar;

                if(indice.toUpperCase() == "B")
                    return;
                else
                {
                    int indiceInt = Integer.parseInt(indice);

                    produtoParaAlterar = produtos.get(indiceInt);

                    /*
                    Optional<Produto> produtoPesquisado = produtoRepository.findById(indice);

                    if(!produtoPesquisado.isPresent())
                    {
                        tentativas++;
                        System.out.println("Produto não encontrado, entre com uma opção válida");
                        continue;
                    }
                    else {
                        produtoParaAlterar = produtoPesquisado.get();
                    }

                     */
                }


                String descricao = LerTexto("Deseja alterar a descrição do produto? Caso deseje manter a descrição, apenas apertar enter");
                if(descricao != "")
                    produtoParaAlterar.setDescricao(descricao);

                Double valorReal = LerDouble("Deseja alterar o valor do produto? Caso deseje manter, apenas apertar enter Qual é o valor do produto?", true);

                if(valorReal != null)
                    produtoParaAlterar.setValor(valorReal);

                Integer quantidade = LerInteiro("Qual é a quantidade em estoque do produto?");

                if(quantidade != null)
                    produtoParaAlterar.setQuantidade(quantidade);

                produtoRepository.save(produtoParaAlterar);
                System.out.println("Produto alterado com sucesso");
                tentativas = 4;
            }
            catch (NumberFormatException e) {
                System.out.println("Valor digitado está incorreto.");
                tentativas++;
            }
            catch (Exception e) {
                tentativas++;
                System.out.println(e.getStackTrace());
                System.out.println(e.getMessage());
                System.out.println("Genérico: Valor informado não é válido");
            }

        }while(tentativas <= 3);
    }

    public Produto PesquisarProduto() throws IOException {
        List<Produto> produtos = ListarProdutosEstoque();

        String indice = LerTexto("Qual produto gostaria de excluir? Digite o número/ Aperte B para Buscar por Nome");

        Produto produto;

        if(indice.toUpperCase().equals("B"))
        {
            String nomeProcurado = LerTexto("Qual produto gostaria de excluir? Digite o número/ Aperte B para Buscar por Nome");
            produtos = produtoRepository.findByDescricao(nomeProcurado);
            produto = produtos.get(0);
        }
        else
        {
            int indiceInt = Integer.parseInt(indice);
            produto = produtos.get(indiceInt);
        }

        return produto;
    }

    public List<Produto> ListarProdutosEstoque() throws IOException {
        List<Produto> produtos = produtoRepository.findAll();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < produtos.size(); i++) {
            sb.append("Numero " + i + produtos.get(i));
        }

        System.out.println(sb.toString());

        return produtos;
    }

    public void ExcluirProduto() {
        int tentativas = 0;

        do{
            try {
                Produto produtoParaExcluir = PesquisarProduto();
                produtoRepository.delete(produtoParaExcluir);
                System.out.println("Produto excluído com sucesso");
                tentativas = 4;
            }
            catch (NumberFormatException e) {
                System.out.println("Valor digitado está incorreto.");
                tentativas++;
            }
            catch (Exception e) {
                tentativas++;
                System.out.println(e.getStackTrace());
                System.out.println(e.getMessage());
                System.out.println("Genérico: Valor informado não é válido");
            }

        }while(tentativas <= 3);
    }
}
