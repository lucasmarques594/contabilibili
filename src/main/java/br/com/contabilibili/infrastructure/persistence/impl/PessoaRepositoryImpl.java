package br.com.contabilibili.infrastructure.persistence.impl;

import br.com.contabilibili.domain.model.Pessoa;
import br.com.contabilibili.domain.repository.PessoaRepository;
import br.com.contabilibili.infrastructure.persistence.jpa.PessoaJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PessoaRepositoryImpl implements PessoaRepository {

    private final PessoaJpaRepository jpaRepository;

    @Override
    public Pessoa save(Pessoa pessoa) {
        return jpaRepository.save(pessoa);
    }

    @Override
    public Optional<Pessoa> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<Pessoa> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}