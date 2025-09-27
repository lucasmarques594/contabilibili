package br.com.contabilibili.infrastructure.persistence.jpa;

import br.com.contabilibili.domain.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaJpaRepository extends JpaRepository<Pessoa, Long> {

}