package br.com.contabilibili.application.usecases;

import br.com.contabilibili.domain.repository.ProcessoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExcluirProcesso {
    private final ProcessoRepository processoRepository;

    public void executar(Long id) {
        processoRepository.deleteById(id);
    }
}