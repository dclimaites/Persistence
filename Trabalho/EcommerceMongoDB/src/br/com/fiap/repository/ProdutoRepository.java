package br.com.fiap.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fiap.entity.Produto;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProdutoRepository extends MongoRepository<Produto, String> {
	@Query("{ 'descricao' : { $regex: ?0 } }")
	public List<Produto> findByDescricao(String descricao);
}
