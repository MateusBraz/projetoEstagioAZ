package br.com.selecao.test.locadora.repository;

import br.com.selecao.test.locadora.entity.Lote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoteRepository extends JpaRepository<Lote, Long> {

    @Query(value = "SELECT * FROM tb_lote WHERE tb_lote.lei_id = :idLeilao", nativeQuery = true)
    List<Lote> buscarLotesVinculados(@Param("idLeilao") Long idLeilao);

}
