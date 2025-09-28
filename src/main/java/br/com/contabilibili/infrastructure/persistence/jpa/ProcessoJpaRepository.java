package br.com.contabilibili.infrastructure.persistence.jpa;

import br.com.contabilibili.domain.model.Processo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessoJpaRepository extends JpaRepository<Processo, Long> {

}