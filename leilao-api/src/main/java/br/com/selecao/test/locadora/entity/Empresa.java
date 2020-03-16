package br.com.selecao.test.locadora.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "TB_EMPRESA", uniqueConstraints = {
        @UniqueConstraint(columnNames = "EMP_CNPJ"),
        @UniqueConstraint(columnNames = "EMP_USUARIO")
})
@SequenceGenerator(name = "seq_empresa")
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;

    public Empresa() {
    }

    public Empresa(String razaoSocial, String cnpj, String logradouro, String municipio, String numero, String complemento, String bairro, String cep,
                   String telefone, String email, String site, String usuario, String senha, Date createdAt, Date updatedAt) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.logradouro = logradouro;
        this.municipio = municipio;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.telefone = telefone;
        this.email = email;
        this.site = site;
        this.usuario = usuario;
        this.senha = senha;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Id
    @Column(name = "EMP_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_empresa")
    private Long id;

    @Column(name = "EMP_RAZAO_SOCIAL", length = 64, nullable = false)
    private String razaoSocial;

    @Column(name = "EMP_CNPJ", length = 32, nullable = false, unique = true)
    private String cnpj;

    @Column(name = "EMP_LOGRADOURO", length = 64)
    private String logradouro;

    @Column(name = "EMP_MUNICIPIO", length = 64)
    private String municipio;

    @Column(name = "EMP_NUMERO", length = 10)
    private String numero;

    @Column(name = "EMP_COMPLEMENTO", length = 64)
    private String complemento;

    @Column(name = "EMP_BAIRRO", length = 64)
    private String bairro;

    @Column(name = "EMP_CEP", length = 16)
    private String cep;

    @Column(name = "EMP_TELEFONE", length = 32)
    private String telefone;

    @Column(name = "EMP_EMAIL", length = 254, nullable = false)
    private String email;

    @Column(name = "EMP_SITE", length = 254)
    private String site;

    @Column(name = "EMP_USUARIO", length = 20, nullable = false, unique = true)
    private String usuario;

    @Column(name = "EMP_SENHA", length = 128)
    private String senha;

    @Column(name = "EMP_CREATED_AT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "EMP_UPDATED_AT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(id, empresa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
