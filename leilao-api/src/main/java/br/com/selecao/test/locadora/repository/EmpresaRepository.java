package br.com.selecao.test.locadora.repository;

import br.com.selecao.test.locadora.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    @Query(value = "SELECT * FROM tb_empresa WHERE emp_cnpj = :cnpj", nativeQuery = true)
    Empresa empresaComEsseCnpj(@Param("cnpj") String cnpj);

    @Query(value = "SELECT * FROM tb_empresa WHERE emp_usuario = :usuario", nativeQuery = true)
    Empresa empresaComEsseUsuario(@Param("usuario") String usuario);

    @Query(value = "SELECT tb_comprador.emp_id FROM tb_comprador INNER JOIN tb_empresa empresa on tb_comprador.emp_id = empresa.emp_id WHERE tb_comprador.emp_id = :idEmpresa ", nativeQuery = true)
    List<java.math.BigInteger> buscarChavesEstrangeirasEmpresa(@Param("idEmpresa") Long idEmpresa);
}
