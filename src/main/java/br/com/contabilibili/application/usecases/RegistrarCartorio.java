package br.com.contabilibili.application.usecases;

import br.com.contabilibili.domain.model.Cartorio;
import br.com.contabilibili.domain.repository.CartorioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrarCartorio {

    private final CartorioRepository cartorioRepository;

    public Cartorio executar(String nome) {
        Cartorio novoCartorio = new Cartorio();
        novoCartorio.setNome(nome);
        return cartorioRepository.save(novoCartorio);
    }
}