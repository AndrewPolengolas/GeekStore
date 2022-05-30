package com.geekstore.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.geekstore.entities.enums.TipoUser;

@Entity
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=200, nullable=false)
	private String nome;
	
	@Column(nullable=false, unique=true)
	private String cpf;
	
	@Column(length=200, nullable=false, unique=true)
	private String email;
	
	@Column(length=11, nullable=false)
	private Long telefone;
	
	//@Column(nullable=false)
	private Date dataNascimento;
	
	@Column(length=500, nullable=false)
	private String endereco;
	
	@Column(nullable=false)
	private Boolean status;
	
	@Column(nullable=false)
	private String senha;
	
	@Enumerated(EnumType.STRING)
	private TipoUser tipoUser;
	
	@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "login_id", referencedColumnName = "id")
	private Login login;

	public User(){}
	
	public User(Integer id, String nome, String cpf, String email, Long telefone, Date dataNascimento, String endereco,
			Boolean status, String senha, TipoUser tipoUser, Login login) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.status = status;
		this.senha = senha;
		this.tipoUser = tipoUser;
		this.login = login;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoUser getTipoUser() {
		return tipoUser;
	}

	public void setTipoUser(TipoUser tipoUser) {
		this.tipoUser = tipoUser;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
	}
}
