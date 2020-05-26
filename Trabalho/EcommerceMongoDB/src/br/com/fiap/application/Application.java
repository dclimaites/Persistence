	package br.com.fiap.application;

	import br.com.fiap.ui.GerenciadorProduto;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.CommandLineRunner;
	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;

	import java.util.Scanner;

	@SpringBootApplication(scanBasePackageClasses = GerenciadorProduto.class)
	public class Application implements CommandLineRunner {

		private static Scanner reader;
		@Autowired
		GerenciadorProduto produtoCommandLine = new GerenciadorProduto();


		public static void main(String[] args) {
			reader = new Scanner(System.in);
			SpringApplication.run(Application.class, args);
		}

		@Override
		public void run(String... args) throws Exception {
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
											"\n4 - Excluir produto no estoque" +
											"\n99 - Encerrar o programa");



					int valorNumerico =  Integer.parseInt(reader.nextLine());

					switch(valorNumerico) {
						case 1:
							produtoCommandLine.CadastrarProduto();
							break;
						case 2:
							produtoCommandLine.ListarProdutosEstoque();
							break;
						case 3:
							produtoCommandLine.AlterarProduto();
							break;
						case 4:
							produtoCommandLine.ExcluirProduto();
							break;
						case 5:

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

	}
