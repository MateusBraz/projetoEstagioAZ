package br.com.selecao.test.locadora.business;

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
public class LoteBO {

    @Autowired
    private LoteRepository loteRepository;

    @Autowired
    private LeilaoRepository leilaoRepository;

    public List<Lote> buscarTodos() {
        return loteRepository.findAll();
    }

    public Lote bucarPorId(Long id) {
        Optional<Lote> lote = loteRepository.findById(id);
        return lote.orElseThrow(() -> new ObjectNotFoundException("O OBJETO COM O ID: '" + id + "' DA CLASSE " + Lote.class.getName().toUpperCase() + " NÃO FOI ENCONTRADO!", null));
    }

    public void cadastrarLote(Long idLeilao, Lote lote) {
        lote.setLeilao(leilaoRepository.getOne(idLeilao));
        lote.setCreatedAt(new Date());
        lote.setUpdatedAt(new Date());
        loteRepository.save(lote);
    }

    public void atualizarLote(Long id, Long idLeilao, Lote loteAtualizado) {
        Lote loteDesatualizado = loteRepository.getOne(id);
        loteDesatualizado.setNumeroLote(loteAtualizado.getNumeroLote());
        loteDesatualizado.setDescricao(loteAtualizado.getDescricao());
        loteDesatualizado.setQuantidade(loteAtualizado.getQuantidade());
        loteDesatualizado.setValorInicial(loteAtualizado.getValorInicial());
        loteDesatualizado.setUnidade(loteAtualizado.getUnidade());
        loteDesatualizado.setLeilao(leilaoRepository.getOne(idLeilao));
        loteDesatualizado.setUpdatedAt(new Date());
        loteRepository.save(loteDesatualizado);
    }

    public void deletarLote(Long id) {
        Lote lote = loteRepository.getOne(id);
        loteRepository.delete(lote);
    }

}
