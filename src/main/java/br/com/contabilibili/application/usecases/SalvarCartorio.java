package br.com.contabilibili.application.usecases;

import br.com.contabilibili.domain.model.Cartorio;
import br.com.contabilibili.domain.repository.CartorioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalvarCartorio {
    private final CartorioRepository cartorioRepository;
    public Cartorio executar(Cartorio cartorio) {
        return cartorioRepository.save(cartorio);
    }
}