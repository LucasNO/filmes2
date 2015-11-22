/**
 * 
 */
package com.lab6.filme2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Emanuel
 *
 */
@Entity
@Table(name = "PER_PERMISSAO")
public class Permissao {

	@Id 
    @GeneratedValue
    @Column(name = "PER_ID")
	private Long id;
    
    @Column(name = "PER_DESCRICAO", unique=true)
    private String descricao;

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
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
