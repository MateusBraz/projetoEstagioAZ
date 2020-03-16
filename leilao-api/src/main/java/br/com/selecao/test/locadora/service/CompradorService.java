package br.com.selecao.test.locadora.service;


import br.com.selecao.test.locadora.business.CompradorBO;
import br.com.selecao.test.locadora.entity.Comprador;
import br.com.selecao.test.locadora.entity.Leilao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/comprador")
public class CompradorService {

    @Autowired
    private CompradorBO compradorBO;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Comprador>> buscarTodosCompradores() {
        return ResponseEntity.ok().body(compradorBO.buscarTodos());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Comprador> buscarComprador(@PathVariable("id") Long idEmpresa, @RequestBody Leilao leilao) {
        return ResponseEntity.ok().body(compradorBO.buscarCompradorPorIdEmpresa(idEmpresa, leilao.getId()));
    }

    @RequestMapping(method = RequestMethod.POST, path = "/{id}")
    public ResponseEntity<Void> cadastrarComprador(@PathVariable("id") Long idEmpresa, @RequestBody Leilao leilao) {
        compradorBO.cadastrarComprador(idEmpresa, leilao.getId());
        URI uriDaInsercao = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(idEmpresa).toUri();
        return ResponseEntity.created(uriDaInsercao).build();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<Void> excluirRegistroComprador(@PathVariable("id") Long idEmpresa, @RequestBody Leilao leilao) {
        compradorBO.deletarComprador(idEmpresa, leilao.getId());
        return ResponseEntity.ok().build();
    }
}
