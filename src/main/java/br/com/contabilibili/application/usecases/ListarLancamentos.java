package br.com.contabilibili.application.usecases;

import br.com.contabilibili.domain.model.LancamentoFinanceiro;
import br.com.contabilibili.domain.repository.LancamentoFinanceiroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarLancamentos {
    private final LancamentoFinanceiroRepository repository;

    public List<LancamentoFinanceiro> executar() {
        return repository.findAll();
    }
}