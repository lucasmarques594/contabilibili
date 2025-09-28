package br.com.contabilibili.application.usecases;

import br.com.contabilibili.domain.model.Processo;
import br.com.contabilibili.domain.repository.ProcessoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalvarProcesso {
    private final ProcessoRepository processoRepository;

    public Processo executar(Processo processo) {
        return processoRepository.save(processo);
    }
}