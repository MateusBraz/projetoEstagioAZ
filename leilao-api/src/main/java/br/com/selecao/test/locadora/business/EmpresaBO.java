package br.com.selecao.test.locadora.business;

import br.com.selecao.test.locadora.business.exception.ObjectExistingException;
import br.com.selecao.test.locadora.business.exception.ObjectHasLink;
import br.com.selecao.test.locadora.entity.Empresa;
import br.com.selecao.test.locadora.repository.EmpresaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaBO {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empresa> buscarTodos() {
        return empresaRepository.findAll();
    }

    public Empresa buscarPorId(Long id) {
        Optional<Empresa> unidade = empresaRepository.findById(id);
        return unidade.orElseThrow(() -> new ObjectNotFoundException("O OBJETO COM O ID: '" + id + "' DA CLASSE " + Empresa.class.getName().toUpperCase() + " NÃO FOI ENCONTRADO!", null));
    }

    public void cadatrarEmpresa(Empresa empresa) {
        this.verificacoes(empresa);
        empresa.setCreatedAt(new Date());
        empresa.setUpdatedAt(new Date());
        empresaRepository.save(empresa);
    }

    public void atualizarEmpresa(Long id, Empresa empresaAtualizada) {
        Empresa empresaDesatualizada = empresaRepository.getOne(id);
        if (empresaDesatualizada.getCnpj().equalsIgnoreCase(empresaAtualizada.getCnpj()) && empresaDesatualizada.getUsuario().equalsIgnoreCase(empresaAtualizada.getUsuario())) {
            atualizarCamposSalvarNoBanco(empresaDesatualizada, empresaAtualizada);
        } else if (empresaDesatualizada.getCnpj().equalsIgnoreCase(empresaAtualizada.getCnpj())) {
            if (this.empresaComMesmoUsuario(empresaAtualizada.getUsuario())) {
                throw new ObjectExistingException("NÃO FOI POSSÍVEL ATUALIZAR OS DADOS, POIS O 'USUÁRIO' JA SE ENCONTRA CADASTRADO!");
            }
            atualizarCamposSalvarNoBanco(empresaDesatualizada, empresaAtualizada);
        } else if (empresaDesatualizada.getUsuario().equalsIgnoreCase(empresaAtualizada.getUsuario())) {
            if (this.empresaComMesmoCnpj(empresaAtualizada.getCnpj())) {
                throw new ObjectExistingException("NÃO FOI POSSÍVEL ATUALIZAR OS DADOS, POIS O 'CNPJ' JA SE ENCONTRA CADASTRADO!");
            }
            atualizarCamposSalvarNoBanco(empresaDesatualizada, empresaAtualizada);
        } else {
            this.verificacoes(empresaAtualizada);
            atualizarCamposSalvarNoBanco(empresaDesatualizada, empresaAtualizada);
        }
    }

    public void deletarEmpresa(Long id) {
        List<java.math.BigInteger> chavesEstrangeirasNaTabelaComprador = empresaRepository.buscarChavesEstrangeirasEmpresa(id);
        if (!chavesEstrangeirasNaTabelaComprador.isEmpty()) {
            throw new ObjectHasLink("NÃO FOI POSSÍVEL EXCLUIR A EMPRESA, POIS ELA POSSUI VÍNCULO COM COMPRADOR!");
        } else {
            empresaRepository.delete(empresaRepository.getOne(id));
        }
    }

    private void verificacoes(Empresa empresa) {
        if (this.empresaComMesmoCnpj(empresa.getCnpj())) {
            throw new ObjectExistingException("O CNPJ '" + empresa.getCnpj() + "' JA SE ENCONTRA CADASTRADO!");
        } else if (this.empresaComMesmoUsuario(empresa.getUsuario())) {
            throw new ObjectExistingException("O USUÁRIO '" + empresa.getUsuario() + "' JA SE ENCONTRA CADASTRADO!");
        }
    }

    private Boolean empresaComMesmoCnpj(String cnpj) {
        Empresa empresa = empresaRepository.empresaComEsseCnpj(cnpj);
        return empresa != null ? true : false;
    }

    private Boolean empresaComMesmoUsuario(String usuario) {
        Empresa empresa = empresaRepository.empresaComEsseUsuario(usuario);
        return empresa != null ? true : false;
    }

    private void atualizarCamposSalvarNoBanco(Empresa empresaDesatualizada, Empresa empresaAtualizada) {
        empresaDesatualizada.setRazaoSocial(empresaAtualizada.getRazaoSocial());
        empresaDesatualizada.setCnpj(empresaAtualizada.getCnpj());
        empresaDesatualizada.setLogradouro(empresaAtualizada.getLogradouro());
        empresaDesatualizada.setMunicipio(empresaAtualizada.getMunicipio());
        empresaDesatualizada.setNumero(empresaAtualizada.getNumero());
        empresaDesatualizada.setComplemento(empresaAtualizada.getComplemento());
        empresaDesatualizada.setBairro(empresaAtualizada.getBairro());
        empresaDesatualizada.setCep(empresaAtualizada.getCep());
        empresaDesatualizada.setTelefone(empresaAtualizada.getTelefone());
        empresaDesatualizada.setEmail(empresaAtualizada.getEmail());
        empresaDesatualizada.setSite(empresaAtualizada.getSite());
        empresaDesatualizada.setUsuario(empresaAtualizada.getUsuario());
        empresaDesatualizada.setSenha(empresaAtualizada.getSenha());
        empresaDesatualizada.setUpdatedAt(new Date());
        empresaRepository.save(empresaDesatualizada);
    }
}

