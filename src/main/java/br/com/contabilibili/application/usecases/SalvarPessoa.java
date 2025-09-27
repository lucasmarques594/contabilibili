package br.com.contabilibili.application.usecases;

import br.com.contabilibili.domain.model.Pessoa;
import br.com.contabilibili.domain.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalvarPessoa {
    private final PessoaRepository pessoaRepository;

    public Pessoa executar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
}