package br.com.contabilibili.infrastructure.persistence.impl;

import br.com.contabilibili.domain.model.LancamentoFinanceiro;
import br.com.contabilibili.domain.repository.LancamentoFinanceiroRepository;
import br.com.contabilibili.infrastructure.persistence.jpa.LancamentoFinanceiroJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LancamentoFinanceiroRepositoryImpl implements LancamentoFinanceiroRepository {

    private final LancamentoFinanceiroJpaRepository jpaRepository;

    @Override
    public LancamentoFinanceiro save(LancamentoFinanceiro lancamentoFinanceiro) {
        return jpaRepository.save(lancamentoFinanceiro);
    }

    @Override
    public Optional<LancamentoFinanceiro> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<LancamentoFinanceiro> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}