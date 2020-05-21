	package br.com.fiap.application;

	import br.com.fiap.repository.ProdutoRepository;
	import br.com.fiap.ui.Gerenciador;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.CommandLineRunner;
	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;
	import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

	import br.com.fiap.entity.Cliente;
	import br.com.fiap.repository.ClienteRepository;

	@SpringBootApplication
	public class Application implements CommandLineRunner {

		public static void main(String[] args) {

			SpringApplication.run(Application.class, args);
		}

		@Override
		public void run(String... args) throws Exception {
			/*// TODO Auto-generated method stub
			repository.deleteAll();

			repository.save(new Cliente("Diego Climaites", "diegoclimaites@teste.com"));

			System.out.println("Inserindo um cliente");*/

			new Gerenciador().Iniciar();
	}
	}
