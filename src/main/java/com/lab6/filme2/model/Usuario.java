/**
 * 
 */
package com.lab6.filme2.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * @author Emanuel
 *
 */
@Entity
@Table(name = "USR_USUARIO")
public class Usuario {

	@Id 
    @GeneratedValue
    @Column(name = "USR_ID")
	private Long id;
    
    @Column(name = "USR_NOME", unique=true)
    private String nome;
    
    @Column(name = "USR_SENHA")
    private String senha;

    @ManyToMany
    @JoinTable(name = "PUS_PERMISSAO_USUARIO", joinColumns = { @JoinColumn(name = "USR_ID") }, inverseJoinColumns = { @JoinColumn(name = "PER_ID") })
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Permissao> permissoes;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the permissoes
	 */
	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	/**
	 * @param permissoes the permissoes to set
	 */
	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

}
