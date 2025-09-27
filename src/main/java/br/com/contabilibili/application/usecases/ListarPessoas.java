package br.com.contabilibili.application.usecases;

import br.com.contabilibili.domain.model.Pessoa;
import br.com.contabilibili.domain.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarPessoas {
    private final PessoaRepository pessoaRepository;

    public List<Pessoa> executar() {
        return pessoaRepository.findAll();
    }
}