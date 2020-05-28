package br.com.fiap.ui;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Produto;
import br.com.fiap.repository.ClienteRepository;
import br.com.fiap.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

@EnableMongoRepositories(basePackageClasses = ClienteRepository.class)
@SpringBootApplication
@Service
public class ClienteGerenciador extends GerenciadorBase {
    @Autowired
    private ClienteRepository clienteRepository;

    public int Iniciar() {

        boolean encerrar = false;
        int tentativas = 0;
        System.out.println
                ("Iniciado programa de estoque/compra de produtos");
        do {

            try {

                int valorNumerico = LerInteiro("\nEscolha uma opção: " +
                        "\n1 - Realizar Login" +
                        "\n2 - Cadastrar Cliente" +
                        "\n3 - Alterar Cliente" +
                        "\n4 - Excluir Cliente" +
                        "\n99 - Voltar ao menu anterior");

                switch (valorNumerico) {
                    case 1:
                        LogarComTela();
                        break;
                    case 2:
                        CadastrarCliente();
                        break;
                    case 3:
                        AlterarCliente();
                        break;
                    case 4:
                        ExcluirCliente();
                        break;
                    case 99:
                        return 99;
                    default:
                        System.out.println("Opção não existente");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());

                System.out.println(e.getMessage());
                tentativas++;
                if (tentativas == 3) encerrar = true;
            }
        } while (!encerrar);

        return 999;
    }

    private Cliente LogarComTela() {
        return null;
    }

    private void CadastrarCliente() {


        int tentativas = 0;
        do {
            try {

                String email = LerTexto("Qual e-mail que gostaria de cadastrar?");
                String nome = LerTexto("Qual é o seu nome?");

                Cliente clienteCadastro = clienteRepository.findByEmail(email);

                if(clienteCadastro != null)
                {
                    
                }

                produtoRepository.save(new Produto(descricao, valorReal, quantidade));
                System.out.println("Produto cadastrado com sucesso");
                tentativas = 4;
            } catch (NumberFormatException e) {
                System.out.println("Valor digitado está incorreto.");
                tentativas++;
            } catch (Exception e) {
                tentativas++;
                System.out.println(e.getStackTrace());
                System.out.println(e.getMessage());
                System.out.println("Genérico: Valor informado não é válido");
            }

        } while (tentativas <= 3);
    }

    private void AlterarCliente() {

    }

    private void ExcluirCliente() {
    }
}
