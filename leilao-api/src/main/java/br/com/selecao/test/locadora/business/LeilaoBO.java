package br.com.selecao.test.locadora.business;

import br.com.selecao.test.locadora.business.exception.ObjectHasLink;
import br.com.selecao.test.locadora.entity.Leilao;
import br.com.selecao.test.locadora.entity.Lote;
import br.com.selecao.test.locadora.repository.LeilaoRepository;
import br.com.selecao.test.locadora.repository.LoteRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LeilaoBO {

    @Autowired
    private LeilaoRepository leilaoRepository;
    @Autowired
    private LoteRepository loteRepository;

    public List<Leilao> buscarTodos() {
        return leilaoRepository.findAll();
    }

    public Leilao buscarPorId(Long id) {
        Optional<Leilao> leilao = leilaoRepository.findById(id);
        return leilao.orElseThrow(() -> new ObjectNotFoundException("O OBJETO COM O ID: '" + id + "' DA CLASSE " + Leilao.class.getName().toUpperCase() + " NÃO FOI ENCONTRADO!", null));
    }

    public void cadastrarLeilao(Leilao leilao) {
        leilao.setInicioPrevisto(new Date());
        leilao.setCreatedAt(new Date());
        leilao.setUpdatedAt(new Date());
        leilaoRepository.save(leilao);
    }

    public void atualizarLeilao(Long id, Leilao leilaoAtualizado) {
        Leilao leilaoDesatualizado = leilaoRepository.getOne(id);
        leilaoDesatualizado.setCodigo(leilaoAtualizado.getCodigo());
        leilaoDesatualizado.setDescricao(leilaoAtualizado.getDescricao());
        leilaoDesatualizado.setVendedor(leilaoAtualizado.getVendedor());
        leilaoDesatualizado.setInicioPrevisto(new Date());
        leilaoDesatualizado.setUpdatedAt(new Date());
        leilaoRepository.save(leilaoDesatualizado);
    }

    public void deletarLeilao(Long id) {
        List<java.math.BigInteger> chavesEstrangeirasNaTabelaComprador = leilaoRepository.buscarChavesEstrangeirasLeilaoEmComprador(id);
        if (!chavesEstrangeirasNaTabelaComprador.isEmpty()) {
            throw new ObjectHasLink("NÃO FOI POSSÍVEL EXCLUIR O LEILÃO, POIS ELE POSSUI VÍNCULO COM COMPRADOR!");
        } else if (!loteRepository.buscarLotesVinculados(id).isEmpty()) {
            throw new ObjectHasLink("NÃO FOI POSSÍVEL EXCLUIR O LEILÃO, POIS ELE POSSUI VÍNCULO COM LOTE!");
        } else {
            leilaoRepository.delete(leilaoRepository.getOne(id));
        }
    }

    private List<Lote> buscarLotesVinculados(Long id) {
        return loteRepository.buscarLotesVinculados(id);
    }

    public Double valorTotal(Long id) {
        Double valorTotal = 0.0;
        List<Lote> lotes = loteRepository.buscarLotesVinculados(id);
        System.out.println(lotes);
        for (Lote lote : lotes) {
            valorTotal += lote.getQuantidade() * lote.getValorInicial();
        }
        return valorTotal;
    }
}

