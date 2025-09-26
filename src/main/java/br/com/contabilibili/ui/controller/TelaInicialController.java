package br.com.contabilibili.ui.controller;

import br.com.contabilibili.application.usecases.RegistrarCartorio;
import javafx.fxml.FXML;
import org.springframework.stereotype.Component;

@Component
public class TelaInicialController {

    private final RegistrarCartorio registrarCartorio;

    public TelaInicialController(RegistrarCartorio registrarCartorio) {
        this.registrarCartorio = registrarCartorio;
    }

    @FXML
    public void initialize() {
        System.out.println("Tela Inicial Carregada!");
    }
}