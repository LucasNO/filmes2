/**
 * 
 */
package com.lab6.filme2.vo;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author Emanuel
 *
 */
public class PermissaoVO implements Serializable, GrantedAuthority  {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 2733951586000592913L;
	
	private Long id;
    private String descricao;
    
	/**
	 * Default Constructor
	 */
	public PermissaoVO() {
	}

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

	@Override
	public String getAuthority() {
		return "ROLE_" + getDescricao();
	}

}
