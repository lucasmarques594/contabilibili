package br.com.contabilibili.application.usecases;

import br.com.contabilibili.domain.model.Cartorio;
import br.com.contabilibili.domain.repository.CartorioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarCartorios {
    private final CartorioRepository cartorioRepository;

    public List<Cartorio> executar() {
        return cartorioRepository.findAll();
    }
}