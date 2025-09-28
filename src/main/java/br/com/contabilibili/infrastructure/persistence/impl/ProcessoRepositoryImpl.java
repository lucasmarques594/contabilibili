package br.com.contabilibili.infrastructure.persistence.impl;

import br.com.contabilibili.domain.model.Processo;
import br.com.contabilibili.domain.repository.ProcessoRepository;
import br.com.contabilibili.infrastructure.persistence.jpa.ProcessoJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Implementação do repositório de Processo, que atua como um adaptador
 * entre a camada de domínio e a tecnologia de persistência (Spring Data JPA).
 */
@Component
@RequiredArgsConstructor
public class ProcessoRepositoryImpl implements ProcessoRepository {

    private final ProcessoJpaRepository jpaRepository;

    @Override
    public Processo save(Processo processo) {
        return jpaRepository.save(processo);
    }

    @Override
    public Optional<Processo> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<Processo> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}