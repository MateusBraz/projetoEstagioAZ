package br.com.selecao.test.locadora.service;


import br.com.selecao.test.locadora.business.EmpresaBO;
import br.com.selecao.test.locadora.entity.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/empresas")
public class EmpresaService {

    @Autowired
    private EmpresaBO empresaBO;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Empresa>> buscarTodasEmpresas() {
        return ResponseEntity.ok().body(empresaBO.buscarTodos());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Empresa> buscarEmpresa(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(empresaBO.buscarPorId(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> cadastrarEmpresa(@RequestBody Empresa empresa) {
        empresaBO.cadatrarEmpresa(empresa);
        URI uriDaInsercao = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(empresa.getId()).toUri();
        return ResponseEntity.created(uriDaInsercao).build();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<Void> alterarRegistroEmpresa(@PathVariable("id") Long id, @RequestBody Empresa empresaAlterada) {
        empresaBO.atualizarEmpresa(id, empresaAlterada);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<Void> excluirRegistroEmpresa(@PathVariable("id") Long id) {
        empresaBO.deletarEmpresa(id);
        return ResponseEntity.ok().build();
    }
}
