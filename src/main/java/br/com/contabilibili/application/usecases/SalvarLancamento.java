package br.com.contabilibili.application.usecases;

import br.com.contabilibili.domain.model.LancamentoFinanceiro;
import br.com.contabilibili.domain.repository.LancamentoFinanceiroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalvarLancamento {
    private final LancamentoFinanceiroRepository repository;

    public LancamentoFinanceiro executar(LancamentoFinanceiro lancamento) {
        return repository.save(lancamento);
    }
}