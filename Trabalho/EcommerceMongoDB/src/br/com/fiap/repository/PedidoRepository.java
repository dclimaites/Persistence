package br.com.fiap.repository;

import br.com.fiap.entity.Pedido;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

@Document
public interface PedidoRepository extends MongoRepository<Pedido, String> {
    @Query("")
    public List<Pedido> findByCliente();
}
