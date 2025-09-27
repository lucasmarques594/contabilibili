package br.com.contabilibili.application.usecases;

import br.com.contabilibili.domain.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExcluirPessoa {
    private final PessoaRepository pessoaRepository;

    public void executar(Long id) {
        pessoaRepository.deleteById(id);
    }
}