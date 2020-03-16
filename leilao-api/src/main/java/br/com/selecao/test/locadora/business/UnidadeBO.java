package br.com.selecao.test.locadora.business;

import br.com.selecao.test.locadora.entity.Unidade;
import br.com.selecao.test.locadora.repository.UnidadeRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UnidadeBO {

    @Autowired
    private UnidadeRepository unidadeRepository;

    public List<Unidade> buscarTodos() {
        return unidadeRepository.findAll();
    }

    public Unidade buscarPorId(Long id) {
        Optional<Unidade> unidade = unidadeRepository.findById(id);
        return unidade.orElseThrow(() -> new ObjectNotFoundException("O Objeto como id: " + id + " da classe " + Unidade.class.getName() + " não foi encontrado!", null));
    }

    public void cadastrarUnidade(Unidade unidade) {
        unidade.setCreatedAt(new Date());
        unidade.setUpdatedAt(new Date());
        unidadeRepository.save(unidade);
    }

    public void atualizarUnidade(Long id, Unidade unidadeAtualizada) {
        Unidade unidadeDesatualizada = unidadeRepository.getOne(unidadeAtualizada.getId());
        unidadeDesatualizada.setNome(unidadeAtualizada.getNome());
        unidadeDesatualizada.setUpdatedAt(new Date());
        unidadeRepository.save(unidadeDesatualizada);
    }

    public void deletarUnidade(Long id) {
        Unidade unidade = unidadeRepository.getOne(id);
        unidadeRepository.delete(unidade);
    }


}
