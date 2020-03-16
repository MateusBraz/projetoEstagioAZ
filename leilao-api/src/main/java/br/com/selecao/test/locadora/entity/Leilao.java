package br.com.selecao.test.locadora.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "TB_LEILAO")
@SequenceGenerator(name = "seq_leilao")
public class Leilao implements Serializable {

    private static final long serialVersionUID = 1L;

    public Leilao() {
    }

    public Leilao(Integer codigo, String descricao, Integer vendedor, Date inicioPrevisto, Date createdAt, Date updatedAt) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.vendedor = vendedor;
        this.inicioPrevisto = inicioPrevisto;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Id
    @Column(name = "LEI_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_leilao")
    private Long id;

    @Column(name = "LEI_CODIGO")
    private Integer codigo;

    @Column(name = "LEI_DESCRICAO", length = 60, nullable = false)
    private String descricao;

    @Column(name = "LEI_VENDEDOR", nullable = false)
    private Integer vendedor;

    @Column(name = "LEI_INICIO_PREVISTO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicioPrevisto;

    @Column(name = "LEI_CREATED_AT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "LEI_UPDATED_AT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getVendedor() {
        return vendedor;
    }

    public void setVendedor(Integer vendedor) {
        this.vendedor = vendedor;
    }

    public Date getInicioPrevisto() {
        return inicioPrevisto;
    }

    public void setInicioPrevisto(Date inicioPrevisto) {
        this.inicioPrevisto = inicioPrevisto;
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
        Leilao leilao = (Leilao) o;
        return Objects.equals(id, leilao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
