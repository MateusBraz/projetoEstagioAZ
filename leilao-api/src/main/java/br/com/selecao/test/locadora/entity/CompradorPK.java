package br.com.selecao.test.locadora.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CompradorPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "EMP_ID")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "LEI_ID")
    private Leilao leilao;

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Leilao getLeilao() {
        return leilao;
    }

    public void setLeilao(Leilao leilao) {
        this.leilao = leilao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompradorPK that = (CompradorPK) o;
        return Objects.equals(empresa, that.empresa) &&
                Objects.equals(leilao, that.leilao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empresa, leilao);
    }
}
