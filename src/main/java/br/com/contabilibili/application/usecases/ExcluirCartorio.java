package br.com.contabilibili.application.usecases;

import br.com.contabilibili.domain.repository.CartorioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExcluirCartorio {
    private final CartorioRepository cartorioRepository;

    public void executar(Long id) {
        cartorioRepository.deleteById(id);
    }
}