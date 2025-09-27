package br.com.contabilibili.ui.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MainViewController {

    @FXML
    private BorderPane mainPane;

    private final ApplicationContext springContext;

    public MainViewController(ApplicationContext springContext) {
        this.springContext = springContext;
    }

    @FXML
    public void initialize() {
        abrirTelaHome();
    }

    public void abrirTelaHome() {
        carregarView("HomeView", false);
    }

    @FXML
    void abrirTelaCartorios(ActionEvent event) {
        carregarView("CartorioView", true);
    }

    @FXML
    void abrirTelaPessoas(ActionEvent event) {
        carregarView("PessoaView", true);
    }

    @FXML
    void fecharAplicacao(ActionEvent event) {
        Platform.exit();
    }

    private void carregarView(String viewNome, boolean passarReferencia) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/br/com/contabilibili/ui/view/" + viewNome + ".fxml"));
            loader.setControllerFactory(springContext::getBean);
            Parent view = loader.load();
            if (passarReferencia) {
                if (loader.getController() instanceof CartorioViewController) {
                    ((CartorioViewController) loader.getController()).setMainController(this);
                } else if (loader.getController() instanceof PessoaViewController) {
                    ((PessoaViewController) loader.getController()).setMainController(this);
                }
            }

            mainPane.setCenter(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}