package br.com.fiap.repository;
import br.com.fiap.entity.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
	Pessoa findByNome(String nome);
}
