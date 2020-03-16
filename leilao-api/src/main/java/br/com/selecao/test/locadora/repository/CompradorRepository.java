package br.com.selecao.test.locadora.repository;

import br.com.selecao.test.locadora.entity.Comprador;
import br.com.selecao.test.locadora.entity.CompradorPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface CompradorRepository extends JpaRepository<Comprador, CompradorPK> {

    @Query(value = "SELECT * FROM tb_comprador WHERE emp_id = :idEmpresa AND lei_id = :idLeilao", nativeQuery = true)
    Comprador buscarCompradorPorIdEmpresaIdLeilao(@Param("idEmpresa") Long idEmpresa, @Param("idLeilao") Long idLeilao);
}
