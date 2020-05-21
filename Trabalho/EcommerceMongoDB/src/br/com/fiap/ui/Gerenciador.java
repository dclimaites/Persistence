package br.com.fiap.ui;

import br.com.fiap.entity.Produto;
import br.com.fiap.repository.ClienteRepository;
import br.com.fiap.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


@EnableMongoRepositories(basePackageClasses =  {ClienteRepository.class, ProdutoRepository.class})
public class Gerenciador {
    private boolean valorInvalido;
    private Scanner reader;
    @Autowired
    private ProdutoRepository produtoRepository;

    public Gerenciador() {
        valorInvalido = true;
        reader = new Scanner(System.in);
    }


    public void Iniciar() throws Exception {
			/*// TODO Auto-generated method stub
			repository.deleteAll();

			repository.save(new Cliente("Diego Climaites", "diegoclimaites@teste.com"));

			System.out.println("Inserindo um cliente");*/

        boolean encerrar = false;
        int tentativas = 0;
        do {

            try {

                System.out.println
                ("Iniciado programa de estoque/compra de produtos" +
                        "\nEscolha uma opção: " +
                        "\n1 - Cadastrar produto no estoque" +
                        "\n99 - Encerrar o programa");



                int valorNumerico =  Integer.parseInt(reader.nextLine());

                switch(valorNumerico) {
                    case 1:
                        CadastrarProduto();
                        break;
                    case 99:
                        encerrar = true;
                        break;
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
    }

    public void CadastrarProduto() {
        double valorReal = 999999999;
        do{
            try {

                String descricao = LerTexto("Digite a descrição do produto?");

                valorReal = LerDouble("Qual é o valor do produto?");

                int quantidade = LerInteiro("Qual é a quantidade em estoque do produto?");

                produtoRepository.save(new Produto(descricao, valorReal, quantidade));
            }
            catch (NumberFormatException e) {
                System.out.println("Valor digitado está incorreto.");
                valorInvalido = true;
            }
            catch (Exception e) {
                System.out.println(e.getStackTrace());
                System.out.println(e.getMessage());
                System.out.println("Genérico: Valor informado não é válido");
            }

        }while(valorInvalido);

    /*Produto produto = new Produto(descricao, valorReal);
    produtoRepository.save(produto);*/

    }

    private String LerTexto(String texto) {
        System.out.println(texto);
        return reader.nextLine();
    }

    private int LerInteiro(String texto) {
        System.out.println(texto);
        String teste = reader.nextLine();
        return Integer.parseInt(teste);
    }

    private Double LerDouble(String texto) {
        System.out.println(texto);
        return Double.parseDouble(reader.nextLine());
    }
}
