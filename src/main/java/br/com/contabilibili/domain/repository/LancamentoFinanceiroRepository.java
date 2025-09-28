package br.com.contabilibili.domain.repository;

import br.com.contabilibili.domain.model.LancamentoFinanceiro;
import java.util.List;
import java.util.Optional;

public interface LancamentoFinanceiroRepository {
    LancamentoFinanceiro save(LancamentoFinanceiro lancamentoFinanceiro);

    List<LancamentoFinanceiro> findAll();
    Optional<LancamentoFinanceiro> findById(Long id);

    void deleteById(Long id);
}