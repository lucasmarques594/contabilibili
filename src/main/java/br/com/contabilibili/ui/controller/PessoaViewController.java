package br.com.contabilibili.ui.controller;

import br.com.contabilibili.application.usecases.ExcluirPessoa;
import br.com.contabilibili.application.usecases.ListarPessoas;
import br.com.contabilibili.application.usecases.SalvarPessoa;
import br.com.contabilibili.domain.model.Pessoa;
import br.com.contabilibili.domain.model.TipoPessoa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert;
import org.springframework.stereotype.Component;

@Component
public class PessoaViewController {

    private final ListarPessoas listarPessoas;
    private final SalvarPessoa salvarPessoa;
    private final ExcluirPessoa excluirPessoa;
    private MainViewController mainController;

    @FXML
    private TableView<Pessoa> tabelaPessoas;
    @FXML
    private TableColumn<Pessoa, Long> colunaId;
    @FXML
    private TableColumn<Pessoa, String> colunaNome;
    @FXML
    private TableColumn<Pessoa, TipoPessoa> colunaTipo;
    @FXML
    private TextField campoNome;
    @FXML
    private ComboBox<TipoPessoa> comboTipoPessoa;
    @FXML
    private Label labelId;
    @FXML
    private Button btnExcluir;

    private ObservableList<Pessoa> pessoasData;
    private Pessoa pessoaSelecionada;

    public PessoaViewController(ListarPessoas listarPessoas, SalvarPessoa salvarPessoa, ExcluirPessoa excluirPessoa) {
        this.listarPessoas = listarPessoas;
        this.salvarPessoa = salvarPessoa;
        this.excluirPessoa = excluirPessoa;
    }

    public void setMainController(MainViewController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void initialize() {
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaTipo.setCellValueFactory(new PropertyValueFactory<>("tipoPessoa"));

        comboTipoPessoa.getItems().setAll(TipoPessoa.values());

        tabelaPessoas.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarPessoa(newValue));

        carregarDadosDaTabela();
    }

    private void carregarDadosDaTabela() {
        pessoasData = FXCollections.observableArrayList(listarPessoas.executar());
        tabelaPessoas.setItems(pessoasData);
    }

    private void selecionarPessoa(Pessoa pessoa) {
        pessoaSelecionada = pessoa;
        if (pessoa != null) {
            campoNome.setText(pessoa.getNome());
            comboTipoPessoa.setValue(pessoa.getTipoPessoa());
            labelId.setText(String.valueOf(pessoa.getId()));
            btnExcluir.setDisable(false);
        } else {
            limparFormulario();
        }
    }

    @FXML
    void onVoltarClick(ActionEvent event) {
        if (mainController != null) {
            mainController.abrirTelaHome();
        }
    }

    @FXML
    void onNovoClick(ActionEvent event) {
        tabelaPessoas.getSelectionModel().clearSelection();
        limparFormulario();
    }

    @FXML
    void onExcluirClick(ActionEvent event) {
        if (pessoaSelecionada != null) {
            excluirPessoa.executar(pessoaSelecionada.getId());
            carregarDadosDaTabela();
            limparFormulario();
        }
    }

    @FXML
    void onSalvarClick(ActionEvent event) {
        Pessoa pessoaParaSalvar = (pessoaSelecionada != null) ? pessoaSelecionada : new Pessoa();
        pessoaParaSalvar.setNome(campoNome.getText());
        pessoaParaSalvar.setTipoPessoa(comboTipoPessoa.getValue());

        salvarPessoa.executar(pessoaParaSalvar);
        carregarDadosDaTabela();
        limparFormulario();
    }

    private void limparFormulario() {
        pessoaSelecionada = null;
        campoNome.clear();
        comboTipoPessoa.getSelectionModel().clearSelection();
        labelId.setText("");
        btnExcluir.setDisable(true);
    }
}