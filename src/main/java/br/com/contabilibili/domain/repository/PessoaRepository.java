package br.com.contabilibili.domain.repository;

import br.com.contabilibili.domain.model.Pessoa;
import java.util.Optional;

public interface PessoaRepository {
    Pessoa save(Pessoa pessoa);

    Optional<Pessoa> findById(Long id);
}