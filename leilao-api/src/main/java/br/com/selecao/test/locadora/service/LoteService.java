package br.com.selecao.test.locadora.service;

import br.com.selecao.test.locadora.business.LoteBO;
import br.com.selecao.test.locadora.entity.Leilao;
import br.com.selecao.test.locadora.entity.Lote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/lotes")
public class LoteService {

    @Autowired
    private LoteBO loteBO;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Lote>> buscarTodosLotes() {
        return ResponseEntity.ok().body(loteBO.buscarTodos());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Lote> buscarLote(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(loteBO.bucarPorId(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> cadastrarLote(@RequestBody Lote lote, Leilao leilao) {
        loteBO.cadastrarLote(leilao.getId(), lote);
        URI uriDaInsercao = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(lote.getId()).toUri();
        return ResponseEntity.created(uriDaInsercao).build();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<Void> alterarRegistroLote(@PathVariable("id") Long id, @RequestBody Leilao leilao, @RequestBody Lote loteAtualizado) {
        loteBO.atualizarLote(id, leilao.getId(), loteAtualizado);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<Void> excluirRegistroLote(@PathVariable("id") Long id) {
        loteBO.deletarLote(id);
        return ResponseEntity.ok().build();
    }
}
