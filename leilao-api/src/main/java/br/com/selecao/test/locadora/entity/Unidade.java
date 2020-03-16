package br.com.selecao.test.locadora.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "TB_UNIDADE")
@SequenceGenerator(name = "seq_unidade")
public class Unidade implements Serializable {

    private static final long serialVersionUID = 1L;

    public Unidade() {
    }

    public Unidade(String nome, Date createdAt, Date updatedAt) {
        this.nome = nome;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Id
    @Column(name = "UNI_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_unidade")
    private Long id;

    @Column(name = "UNI_NOME", length = 128, nullable = false)
    private String nome;

    @Column(name = "UNI_CREATED_AT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "UNI_UPDATED_AT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        Unidade unidade = (Unidade) o;
        return id.equals(unidade.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
