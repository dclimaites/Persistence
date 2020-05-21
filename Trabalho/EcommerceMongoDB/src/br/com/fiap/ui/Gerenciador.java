package br.com.fiap.ui;

import br.com.fiap.entity.Produto;
import br.com.fiap.repository.ClienteRepository;
import br.com.fiap.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;



@SpringBootApplication
public class Gerenciador implements CommandLineRunner {

    public Gerenciador() {

    }

    @Override
    public void run(String... args) throws Exception {
        Iniciar();
    }


    public void Iniciar() throws Exception {
			/*// TODO Auto-generated method stub
			repository.deleteAll();

			repository.save(new Cliente("Diego Climaites", "diegoclimaites@teste.com"));

			System.out.println("Inserindo um cliente");*/

        boolean encerrar = false;
        int tentativas = 0;
        System.out.println
                ("Iniciado programa de estoque/compra de produtos");
        do {

            try {

                System.out.println
                (
                        "\nEscolha uma opção: " +
                        "\n1 - Cadastrar produto no estoque" +
                        "\n2 - Listar produtos do estoque" +
                        "\n3 - Alterar Produto no estoque" +
                        "\n99 - Encerrar o programa");



//                int valorNumerico =  Integer.parseInt(reader.nextLine());
//
//                switch(valorNumerico) {
//                    case 1:
//                        CadastrarProduto();
//                        break;
//                    case 2:
//                        ListarProdutosEstoque();
//                        break;
//                    case 3:
//                        AlterarProduto();
//                        break;
//                    case 99:
//                        encerrar = true;
//                        break;
//                    default:
//                        System.out.println("Opção não existente");
//                }
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


}
