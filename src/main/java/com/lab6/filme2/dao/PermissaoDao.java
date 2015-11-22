package com.lab6.filme2.dao;

import java.util.Collection;
import java.util.List;

import com.lab6.filme2.model.Permissao;
import com.lab6.filme2.vo.PermissaoVO;

public interface PermissaoDao extends DaoGenerico<Permissao, Long>{
	
	/**
	 * Converte entidade para VO
	 * @param entidade Entidade
	 * @return VO
	 */
	public PermissaoVO paraPermissaoVO(Permissao entidade);
	
	/**
	 * Converte uma colecao de entidades para colecao de VOs
	 * @param entidades Colecao de entidades
	 * @return Colecao de VOs
	 */
	public List<PermissaoVO> paraColecaoPermissaoVO(Collection<Permissao> entidades);
	
	/**
	 * Converte um VO para uma entidade
	 * @param permissaoVO VO
	 * @return Entidade
	 */
	public Permissao paraEntidade(PermissaoVO permissaoVO);
	
}
