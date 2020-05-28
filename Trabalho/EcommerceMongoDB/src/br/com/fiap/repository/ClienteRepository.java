package br.com.fiap.repository;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fiap.entity.Cliente;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

@Document
public interface ClienteRepository extends MongoRepository<Cliente, String> {
	@Query("{ 'nome' : { $regex: ?0 } }")
	public List<Cliente> findByNome(String nome);

	@Query("{ 'email' : { $regex: ?0 } }")
	public Cliente findByEmail(String email);
}
