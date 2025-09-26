package br.com.contabilibili.domain.repository;

import br.com.contabilibili.domain.model.Processo;
import java.util.Optional;

public interface ProcessoRepository {
    Processo save(Processo processo);

    Optional<Processo> findById(Long id);
}