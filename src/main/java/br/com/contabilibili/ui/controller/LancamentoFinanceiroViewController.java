package br.com.contabilibili.ui.controller;

import br.com.contabilibili.application.usecases.*;
import br.com.contabilibili.domain.model.LancamentoFinanceiro;
import br.com.contabilibili.domain.model.Processo;
import br.com.contabilibili.domain.model.TipoLancamento;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class LancamentoFinanceiroViewController {

    private final ListarLancamentos listarLancamentos;
    private final SalvarLancamento salvarLancamento;
    private final ExcluirLancamento excluirLancamento;
    private final ListarProcessos listarProcessos;
    private MainViewController mainController;

    @FXML
    private TableView<LancamentoFinanceiro> tabelaLancamentos;
    @FXML
    private TableColumn<LancamentoFinanceiro, Long> colunaId;
    @FXML
    private TableColumn<LancamentoFinanceiro, String> colunaDescricao;
    @FXML
    private TableColumn<LancamentoFinanceiro, BigDecimal> colunaValor;
    @FXML
    private TableColumn<LancamentoFinanceiro, LocalDate> colunaData;
    @FXML
    private TableColumn<LancamentoFinanceiro, TipoLancamento> colunaTipo;
    @FXML
    private TableColumn<LancamentoFinanceiro, String> colunaProcesso;
    @FXML
    private TextField campoDescricao;
    @FXML
    private TextField campoValor;
    @FXML
    private DatePicker datePickerData;
    @FXML
    private ComboBox<TipoLancamento> comboTipo;
    @FXML
    private ComboBox<Processo> comboProcesso;
    @FXML
    private Label labelId;
    @FXML
    private Button btnExcluir;

    private LancamentoFinanceiro lancamentoSelecionado;

    public LancamentoFinanceiroViewController(ListarLancamentos listarLancamentos, SalvarLancamento salvarLancamento,
            ExcluirLancamento excluirLancamento, ListarProcessos listarProcessos) {
        this.listarLancamentos = listarLancamentos;
        this.salvarLancamento = salvarLancamento;
        this.excluirLancamento = excluirLancamento;
        this.listarProcessos = listarProcessos;
    }

    public void setMainController(MainViewController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void initialize() {
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colunaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        colunaData.setCellValueFactory(new PropertyValueFactory<>("dataLancamento"));
        colunaTipo.setCellValueFactory(new PropertyValueFactory<>("tipoLancamento"));
        colunaProcesso.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getProcesso().getNumero()));

        carregarComboBoxes();
        tabelaLancamentos.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarLancamento(newValue));
        carregarDadosDaTabela();
    }

    private void carregarComboBoxes() {
        comboTipo.setItems(FXCollections.observableArrayList(TipoLancamento.values()));
        List<Processo> processos = listarProcessos.executar();
        comboProcesso.setItems(FXCollections.observableArrayList(processos));
    }

    private void carregarDadosDaTabela() {
        List<LancamentoFinanceiro> lancamentos = listarLancamentos.executar();
        tabelaLancamentos.setItems(FXCollections.observableArrayList(lancamentos));
    }

    private void selecionarLancamento(LancamentoFinanceiro lancamento) {
        lancamentoSelecionado = lancamento;
        if (lancamento != null) {
            campoDescricao.setText(lancamento.getDescricao());
            campoValor.setText(lancamento.getValor().toString());
            datePickerData.setValue(lancamento.getDataLancamento());
            comboTipo.setValue(lancamento.getTipoLancamento());
            comboProcesso.setValue(lancamento.getProcesso());
            labelId.setText(String.valueOf(lancamento.getId()));
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
        tabelaLancamentos.getSelectionModel().clearSelection();
        limparFormulario();
    }

    @FXML
    void onExcluirClick(ActionEvent event) {
        if (lancamentoSelecionado != null) {
            excluirLancamento.executar(lancamentoSelecionado.getId());
            carregarDadosDaTabela();
            limparFormulario();
        }
    }

    @FXML
    void onSalvarClick(ActionEvent event) {
        try {
            LancamentoFinanceiro lancamentoParaSalvar = (lancamentoSelecionado != null) ? lancamentoSelecionado
                    : new LancamentoFinanceiro();
            lancamentoParaSalvar.setDescricao(campoDescricao.getText());
            lancamentoParaSalvar.setValor(new BigDecimal(campoValor.getText()));
            lancamentoParaSalvar.setDataLancamento(datePickerData.getValue());
            lancamentoParaSalvar.setTipoLancamento(comboTipo.getValue());
            lancamentoParaSalvar.setProcesso(comboProcesso.getValue());

            salvarLancamento.executar(lancamentoParaSalvar);
            carregarDadosDaTabela();
            limparFormulario();
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter valor para número: " + e.getMessage());
        }
    }

    private void limparFormulario() {
        lancamentoSelecionado = null;
        campoDescricao.clear();
        campoValor.clear();
        datePickerData.setValue(null);
        comboTipo.getSelectionModel().clearSelection();
        comboProcesso.getSelectionModel().clearSelection();
        labelId.setText("");
        btnExcluir.setDisable(true);
    }
}