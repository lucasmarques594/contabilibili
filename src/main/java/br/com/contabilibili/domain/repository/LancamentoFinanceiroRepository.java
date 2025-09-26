package br.com.contabilibili.domain.repository;

import br.com.contabilibili.domain.model.LancamentoFinanceiro;
import java.util.Optional;

public interface LancamentoFinanceiroRepository {
    LancamentoFinanceiro save(LancamentoFinanceiro lancamentoFinanceiro);

    Optional<LancamentoFinanceiro> findById(Long id);
}