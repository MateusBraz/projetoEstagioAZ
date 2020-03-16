package br.com.selecao.test.locadora.service;

import br.com.selecao.test.locadora.business.UnidadeBO;
import br.com.selecao.test.locadora.entity.Unidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/unidades")
public class UnidadeService {

    @Autowired
    private UnidadeBO unidadeBO;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Unidade>> buscarTodos() {
        return ResponseEntity.ok().body(unidadeBO.buscarTodos());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Unidade> buscarUnidade(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(unidadeBO.buscarPorId(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> cadastrarUnidade(@RequestBody Unidade unidade) {
        unidadeBO.cadastrarUnidade(unidade);
        URI uriDaInsercao = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unidade.getId()).toUri();
        return ResponseEntity.created(uriDaInsercao).build();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<Void> alterarRegistroUnidade(@PathVariable("id") Long id, @RequestBody Unidade unidadeAtualizada) {
        unidadeBO.atualizarUnidade(id, unidadeAtualizada);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<Void> excluirRegistroUnidade(@PathVariable("id") Long id) {
        unidadeBO.deletarUnidade(id);
        return ResponseEntity.ok().build();
    }
}