package br.com.selecao.test.locadora.business;

import br.com.selecao.test.locadora.business.exception.ObjectExistingException;
import br.com.selecao.test.locadora.entity.Comprador;
import br.com.selecao.test.locadora.entity.CompradorPK;
import br.com.selecao.test.locadora.entity.Empresa;
import br.com.selecao.test.locadora.entity.Leilao;
import br.com.selecao.test.locadora.repository.CompradorRepository;
import br.com.selecao.test.locadora.repository.EmpresaRepository;
import br.com.selecao.test.locadora.repository.LeilaoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompradorBO {

    @Autowired
    private CompradorRepository compradorRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private LeilaoRepository leilaoRepository;

    public List<Comprador> buscarTodos() {
        return compradorRepository.findAll();
    }

    public Comprador buscarCompradorPorIdEmpresa(Long idEmpresa, Long idLeilao) {
        CompradorPK compradorPK = new CompradorPK();
        compradorPK.setLeilao(leilaoRepository.getOne(idLeilao));
        compradorPK.setEmpresa(empresaRepository.getOne(idEmpresa));
        Optional<Comprador> comprador = compradorRepository.findById(compradorPK);
        return comprador.orElseThrow(() -> new ObjectNotFoundException("O OBJETO COM O ID: '" + compradorPK.getEmpresa().getId() + "," + compradorPK.getLeilao().getId() + "' DA CLASSE " + Comprador.class.getName().toUpperCase() + " NÃO FOI ENCONTRADO!", null));
    }

    public void cadastrarComprador(Long idEmpresa, Long idLeilao) {
        if (compradorJaExiste(idEmpresa, idLeilao)) {
            throw new ObjectExistingException("COMPRADOR JA SE ENCONTRA CADASTRADO!");
        }
        Empresa empresa = empresaRepository.getOne(idEmpresa);
        Leilao leilao = leilaoRepository.getOne(idLeilao);
        Comprador comprador = new Comprador();
        comprador.getId().setEmpresa(empresa);
        comprador.getId().setLeilao(leilao);
        compradorRepository.save(comprador);
    }

    public void deletarComprador(Long idEmpresa, Long idLeilao) {
        Comprador comprador = compradorRepository.buscarCompradorPorIdEmpresaIdLeilao(idEmpresa, idLeilao);
        compradorRepository.delete(comprador);
    }

    private Boolean compradorJaExiste(Long idEmpresa, Long idLeilao) {
        Comprador comprador = compradorRepository.buscarCompradorPorIdEmpresaIdLeilao(idEmpresa, idLeilao);
        return comprador != null ? true : false;
    }

}
