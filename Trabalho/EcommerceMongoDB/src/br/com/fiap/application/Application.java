package br.com.fiap.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import br.com.fiap.entity.Cliente;
import br.com.fiap.repository.ClienteRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = Cliente.class)
public class Application implements CommandLineRunner {
	
	@Autowired
	public ClienteRepository repository;
	
	static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.deleteAll();
		
		repository.save(new Cliente("Diego Climaites", "diegoclimaites@teste.com"));
		
		System.out.println("Inserindo um cliente");
	}
}
