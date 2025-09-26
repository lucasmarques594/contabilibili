package br.com.contabilibili.infrastructure.persistence.jpa;

import br.com.contabilibili.domain.model.Cartorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartorioJpaRepository extends JpaRepository<Cartorio, Long> {
}