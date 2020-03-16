package br.com.selecao.test.locadora.DTO;

import br.com.selecao.test.locadora.business.LeilaoBO;
import br.com.selecao.test.locadora.entity.Leilao;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Date;

public class LeilaoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    public LeilaoDTO() {
    }

    public LeilaoDTO(Leilao leilao) {
        this.id = leilao.getId();
        this.vendedor = leilao.getVendedor();
        this.inicioPrevisto = leilao.getInicioPrevisto();
    }



    private Long id;
    private Integer vendedor;
    private Date inicioPrevisto;
    private Double totalLeilao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getTotalLeilao() {
        return totalLeilao;
    }

    public void setTotalLeilao(Double totalLeilao) {
        this.totalLeilao = totalLeilao;
    }

}
