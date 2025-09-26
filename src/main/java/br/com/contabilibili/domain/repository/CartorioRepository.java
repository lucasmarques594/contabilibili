package br.com.contabilibili.domain.repository;

import br.com.contabilibili.domain.model.Cartorio;
import java.util.List;
import java.util.Optional;

public interface CartorioRepository {
    Cartorio save(Cartorio cartorio);
    Optional<Cartorio> findById(Long id);

    List<Cartorio> findAll();

    void deleteById(Long id);
}