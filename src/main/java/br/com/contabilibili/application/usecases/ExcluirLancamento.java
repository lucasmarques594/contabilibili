package br.com.contabilibili.application.usecases;

import br.com.contabilibili.domain.repository.LancamentoFinanceiroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExcluirLancamento {
    private final LancamentoFinanceiroRepository repository;

    public void executar(Long id) {
        repository.deleteById(id);
    }
}