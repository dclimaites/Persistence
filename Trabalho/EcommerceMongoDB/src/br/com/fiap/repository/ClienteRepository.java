package br.com.fiap.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fiap.entity.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
	public Cliente findByNome(String nome);
}
