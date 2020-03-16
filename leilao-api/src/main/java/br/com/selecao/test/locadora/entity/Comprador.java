package br.com.selecao.test.locadora.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB_COMPRADOR")
public class Comprador implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    private CompradorPK id = new CompradorPK();


    public Comprador() {
    }

    public Comprador(CompradorPK id) {
        this.id = id;
    }

    public CompradorPK getId() {
        return id;
    }

    public void setId(CompradorPK id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comprador comprador = (Comprador) o;
        return Objects.equals(id, comprador.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
