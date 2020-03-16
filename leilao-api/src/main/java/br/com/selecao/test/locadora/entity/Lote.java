package br.com.selecao.test.locadora.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "TB_LOTE")
@SequenceGenerator(name = "seq_lote")
public class Lote implements Serializable {

    private static final long serialVersionUID = 1L;

    public Lote() {
    }

    public Lote(Integer numeroLote, String descricao, Double quantidade, Double valorInicial, String unidade, Leilao leilao, Date createdAt, Date updatedAt) {
        this.numeroLote = numeroLote;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valorInicial = valorInicial;
        this.unidade = unidade;
        this.leilao = leilao;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Id
    @Column(name = "LOT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_lote")
    private Long id;

    @Column(name = "LOT_NUMERO_LOTE")
    private Integer numeroLote;

    @Column(name = "LOT_DESCRICAO", length = 60, nullable = false)
    private String descricao;

    @Column(name = "LOT_QUANTIDADE", nullable = false)
    private Double quantidade;

    @Column(name = "LOT_VALOR_INICIAL")
    private Double valorInicial;

    @Column(name = "LOT_UNIDADE", length = 128, nullable = false)
    private String unidade;

    @ManyToOne
    @JoinColumn(name = "LEI_ID")
    private Leilao leilao;

    @Column(name = "LOT_CREATED_AT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "LOT_UPDATED_AT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(Integer numeroLote) {
        this.numeroLote = numeroLote;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(Double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Leilao getLeilao() {
        return leilao;
    }

    public void setLeilao(Leilao leilao) {
        this.leilao = leilao;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lote lote = (Lote) o;
        return Objects.equals(id, lote.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
