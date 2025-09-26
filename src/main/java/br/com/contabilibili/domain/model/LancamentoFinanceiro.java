package br.com.contabilibili.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "lancamento_financeiro")
public class LancamentoFinanceiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private BigDecimal valor;
    private LocalDate dataLancamento;
    @Enumerated(EnumType.STRING)
    private TipoLancamento tipoLancamento;
    @ManyToOne
    private Processo processo;
}