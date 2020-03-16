package br.com.selecao.test.locadora.repository;

import br.com.selecao.test.locadora.entity.Leilao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeilaoRepository extends JpaRepository<Leilao, Long> {

    @Query(value = "SELECT tb_comprador.lei_id FROM tb_comprador INNER JOIN tb_leilao leilao on tb_comprador.lei_id = leilao.lei_id WHERE tb_comprador.lei_id = :idLeilao", nativeQuery = true)
    List<java.math.BigInteger> buscarChavesEstrangeirasLeilaoEmComprador(@Param("idLeilao") Long idLeilao);

}
