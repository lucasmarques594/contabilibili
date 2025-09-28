package br.com.contabilibili.ui.controller;

import br.com.contabilibili.application.usecases.*;
import br.com.contabilibili.domain.model.Cartorio;
import br.com.contabilibili.domain.model.Pessoa;
import br.com.contabilibili.domain.model.Processo;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ProcessoViewController {

    private final ListarProcessos listarProcessos;
    private final SalvarProcesso salvarProcesso;
    private final ExcluirProcesso excluirProcesso;
    private final ListarCartorios listarCartorios;
    private final ListarPessoas listarPessoas;

    private MainViewController mainController;

    @FXML
    private TableView<Processo> tabelaProcessos;
    @FXML
    private TableColumn<Processo, Long> colunaId;
    @FXML
    private TableColumn<Processo, String> colunaNumero;
    @FXML
    private TableColumn<Processo, String> colunaCartorio;
    @FXML
    private TableColumn<Processo, String> colunaInteressado;
    @FXML
    private TextField campoNumero;
    @FXML
    private ComboBox<Cartorio> comboCartorio;
    @FXML
    private ComboBox<Pessoa> comboInteressado;
    @FXML
    private Label labelId;
    @FXML
    private Button btnExcluir;

    private Processo processoSelecionado;

    public ProcessoViewController(ListarProcessos listarProcessos, SalvarProcesso salvarProcesso,
            ExcluirProcesso excluirProcesso, ListarCartorios listarCartorios, ListarPessoas listarPessoas) {
        this.listarProcessos = listarProcessos;
        this.salvarProcesso = salvarProcesso;
        this.excluirProcesso = excluirProcesso;
        this.listarCartorios = listarCartorios;
        this.listarPessoas = listarPessoas;
    }

    public void setMainController(MainViewController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void initialize() {
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
        colunaCartorio
                .setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCartorio().getNome()));
        colunaInteressado.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getInteressado().getNome()));

        carregarComboBoxes();

        tabelaProcessos.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarProcesso(newValue));

        carregarDadosDaTabela();
    }

    private void carregarComboBoxes() {
        List<Cartorio> cartorios = listarCartorios.executar();
        comboCartorio.setItems(FXCollections.observableArrayList(cartorios));

        List<Pessoa> pessoas = listarPessoas.executar();
        comboInteressado.setItems(FXCollections.observableArrayList(pessoas));
    }

    private void carregarDadosDaTabela() {
        List<Processo> processos = listarProcessos.executar();
        tabelaProcessos.setItems(FXCollections.observableArrayList(processos));
    }

    private void selecionarProcesso(Processo processo) {
        processoSelecionado = processo;
        if (processo != null) {
            campoNumero.setText(processo.getNumero());
            comboCartorio.setValue(processo.getCartorio());
            comboInteressado.setValue(processo.getInteressado());
            labelId.setText(String.valueOf(processo.getId()));
            btnExcluir.setDisable(false);
        } else {
            limparFormulario();
        }
    }

    @FXML
    void onVoltarClick(ActionEvent event) {
        if (mainController != null)
            mainController.abrirTelaHome();
    }

    @FXML
    void onNovoClick(ActionEvent event) {
        tabelaProcessos.getSelectionModel().clearSelection();
        limparFormulario();
    }

    @FXML
    void onExcluirClick(ActionEvent event) {
        if (processoSelecionado != null) {
            excluirProcesso.executar(processoSelecionado.getId());
            carregarDadosDaTabela();
            limparFormulario();
        }
    }

    @FXML
    void onSalvarClick(ActionEvent event) {
        Processo processoParaSalvar = (processoSelecionado != null) ? processoSelecionado : new Processo();
        processoParaSalvar.setNumero(campoNumero.getText());
        processoParaSalvar.setCartorio(comboCartorio.getValue());
        processoParaSalvar.setInteressado(comboInteressado.getValue());

        salvarProcesso.executar(processoParaSalvar);
        carregarDadosDaTabela();
        limparFormulario();
    }

    private void limparFormulario() {
        processoSelecionado = null;
        campoNumero.clear();
        comboCartorio.getSelectionModel().clearSelection();
        comboInteressado.getSelectionModel().clearSelection();
        labelId.setText("");
        btnExcluir.setDisable(true);
    }
}