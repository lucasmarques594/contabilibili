package br.com.contabilibili.infrastructure.persistence.jpa;

import br.com.contabilibili.domain.model.LancamentoFinanceiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoFinanceiroJpaRepository extends JpaRepository<LancamentoFinanceiro, Long> {

}