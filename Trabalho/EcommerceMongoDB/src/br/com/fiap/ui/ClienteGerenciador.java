package br.com.fiap.ui;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Endereco;
import br.com.fiap.entity.Produto;
import br.com.fiap.enums.TipoEndereco;
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

    private Cliente CadastrarCliente() {


        int tentativas = 0;
        do {
            try {

                String email = LerTexto("Qual e-mail que gostaria de cadastrar?");
                String nome = LerTexto("Qual é o seu nome?");

                Cliente clienteCadastro = clienteRepository.findByEmail(email);

                if (clienteCadastro != null) {
                    System.out.println("Usuário já cadsatrado");
                    return clienteCadastro;
                }

                clienteCadastro = new Cliente(nome, email);

                String cadastrarEndereco = LerTexto("Gostaria de cadastrar algum endereço?");
                if(cadastrarEndereco.equals("S")) {
                    String cidade = LerTexto("Qual é o Cidade?");
                    String bairro = LerTexto("Qual é o Bairro?");
                    String logradouro = LerTexto("Qual é o logradouro?");
                    String enderecoStr = LerTexto("Qual é o Endereço?");
                    int numero = LerInteiro("Qual é o Número?");
                    String complemento = LerTexto("Qual é o Complemento?");

                    Endereco endereco = new Endereco(logradouro, numero, bairro, cidade, complemento, enderecoStr);

                    ExibirTiposEndereco();

                    int tipoEndereco = LerInteiro("Digite o número do tipo de endereço");

                    clienteCadastro.setEndereco(TipoEndereco.values()[tipoEndereco], endereco);
                }

                clienteRepository.save(clienteCadastro);
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

    public void ExibirTiposEndereco() {
        StringBuilder sb = new StringBuilder();
        sb.append("Qual é o tipo de endereço?\n");
        for (TipoEndereco end : TipoEndereco.values()) {
            sb.append(end.getValor() + " - " + end.name() + "\n");
        }
    }

    private void AlterarCliente() {

    }

    private void ExcluirCliente() {
    }
}
