package br.com.fiap.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fiap.entity.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, String> {
	public Produto findByDescricao(String descricao);
}
