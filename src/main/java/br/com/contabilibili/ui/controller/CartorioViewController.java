package br.com.contabilibili.ui.controller;

import br.com.contabilibili.application.usecases.ExcluirCartorio;
import br.com.contabilibili.application.usecases.ListarCartorios;
import br.com.contabilibili.application.usecases.SalvarCartorio;
import br.com.contabilibili.domain.model.Cartorio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.stereotype.Component;

@Component
public class CartorioViewController {

    private final ListarCartorios listarCartorios;
    private final SalvarCartorio salvarCartorio;
    private final ExcluirCartorio excluirCartorio;

    @FXML
    private TableView<Cartorio> tabelaCartorios;
    @FXML
    private TableColumn<Cartorio, Long> colunaId;
    @FXML
    private TableColumn<Cartorio, String> colunaNome;
    @FXML
    private TextField campoNome;
    @FXML
    private Label labelId;
    @FXML
    private Button btnExcluir;

    private ObservableList<Cartorio> cartoriosData;
    private Cartorio cartorioSelecionado;

    public CartorioViewController(ListarCartorios listarCartorios, SalvarCartorio salvarCartorio,
            ExcluirCartorio excluirCartorio) {
        this.listarCartorios = listarCartorios;
        this.salvarCartorio = salvarCartorio;
        this.excluirCartorio = excluirCartorio;
    }

    @FXML
    public void initialize() {
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        tabelaCartorios.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarCartorio(newValue));

        carregarDadosDaTabela();
    }

    private void carregarDadosDaTabela() {
        cartoriosData = FXCollections.observableArrayList(listarCartorios.executar());
        tabelaCartorios.setItems(cartoriosData);
    }

    private void selecionarCartorio(Cartorio cartorio) {
        cartorioSelecionado = cartorio;
        if (cartorio != null) {
            campoNome.setText(cartorio.getNome());
            labelId.setText(String.valueOf(cartorio.getId()));
            btnExcluir.setDisable(false);
        } else {
            limparFormulario();
        }
    }

    @FXML
    void onNovoClick(ActionEvent event) {
        tabelaCartorios.getSelectionModel().clearSelection();
        limparFormulario();
    }

    @FXML
    void onExcluirClick(ActionEvent event) {
        if (cartorioSelecionado != null) {
            excluirCartorio.executar(cartorioSelecionado.getId());
            carregarDadosDaTabela();
            limparFormulario();
        }
    }

    @FXML
    void onSalvarClick(ActionEvent event) {
        Cartorio cartorioParaSalvar;
        if (cartorioSelecionado != null) {
            cartorioParaSalvar = cartorioSelecionado;
        } else {
            cartorioParaSalvar = new Cartorio();
        }

        cartorioParaSalvar.setNome(campoNome.getText());
        salvarCartorio.executar(cartorioParaSalvar);

        carregarDadosDaTabela();
        limparFormulario();
    }

    private void limparFormulario() {
        cartorioSelecionado = null;
        campoNome.clear();
        labelId.setText("");
        btnExcluir.setDisable(true);
    }
}