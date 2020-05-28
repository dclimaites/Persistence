	package br.com.fiap.application;

	import br.com.fiap.ui.GerenciadorPedidos;
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
		@Autowired
		GerenciadorPedidos pedidosCommandLine = new GerenciadorPedidos();

		public static void main(String[] args) {
			reader = new Scanner(System.in);
			SpringApplication.run(Application.class, args);
		}

		@Override
		public void run(String... args) throws Exception {
			boolean encerrar = false;
			int tentativas = 0;
			System.out.println
					("Iniciado programa de estoque/compra de produtos");
			do {

				try {

					System.out.println
							(
									"\nEscolha uma opção: " +
											"\n1 - Abrir Estoque" +
											"\n2 - Abrir a Loja" +
											"\n99 - Encerrar o programa");

					int valorNumerico =  Integer.parseInt(reader.nextLine());

					switch(valorNumerico) {
						case 1:
							produtoCommandLine.Iniciar();
							break;
						case 2:
							produtoCommandLine.ListarProdutosEstoque();
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

	}
