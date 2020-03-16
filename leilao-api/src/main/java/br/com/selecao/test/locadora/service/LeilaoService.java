package br.com.selecao.test.locadora.service;


import br.com.selecao.test.locadora.DTO.LeilaoDTO;
import br.com.selecao.test.locadora.business.LeilaoBO;
import br.com.selecao.test.locadora.entity.Leilao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/leiloes")
public class LeilaoService {

    @Autowired
    private LeilaoBO leilaoBO;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<LeilaoDTO>> buscarTodosLeiloes() {
        List<Leilao> leiloes = leilaoBO.buscarTodos();
        List<LeilaoDTO> leiloesDTO = leiloes.stream().map(leilao -> new LeilaoDTO(leilao)).collect(Collectors.toList());
        for(LeilaoDTO leilaoDTO : leiloesDTO){
            leilaoDTO.setTotalLeilao(leilaoBO.valorTotal(leilaoDTO.getId()));
        }
        return ResponseEntity.ok().body(leiloesDTO);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Leilao> buscarLeilao(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(leilaoBO.buscarPorId(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> cadastrarLeilao(@RequestBody Leilao leilao) {
        leilaoBO.cadastrarLeilao(leilao);
        URI uriDaInsercao = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(leilao.getId()).toUri();
        return ResponseEntity.created(uriDaInsercao).build();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<Void> alterarRegistroLeilao(@PathVariable("id") Long id, @RequestBody Leilao leilaoAlterado) {
        leilaoBO.atualizarLeilao(id, leilaoAlterado);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<Void> excluirRegistroLeilao(@PathVariable("id") Long id) {
        leilaoBO.deletarLeilao(id);
        return ResponseEntity.ok().build();
    }
}
