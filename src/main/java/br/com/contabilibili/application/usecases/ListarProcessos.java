package br.com.contabilibili.application.usecases;

import br.com.contabilibili.domain.model.Processo;
import br.com.contabilibili.domain.repository.ProcessoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarProcessos {
    private final ProcessoRepository processoRepository;

    public List<Processo> executar() {
        return processoRepository.findAll();
    }
}