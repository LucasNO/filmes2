package com.lab6.filme2.dao;

import java.util.Collection;

import com.lab6.filme2.model.Usuario;
import com.lab6.filme2.vo.UsuarioVO;

public interface UsuarioDao extends DaoGenerico<Usuario, Long>{
	
	/**
	 * Converte entidade para VO
	 * @param entidade Entidade
	 * @return VO
	 */
	public UsuarioVO paraUsuarioVO(Usuario entidade);
	
	/**
	 * Converte uma colecao de entidades para colecao de VOs
	 * @param entidades Colecao de entidades
	 * @return Colecao de VOs
	 */
	public Collection<UsuarioVO> paraColecaoUsuarioVO(Collection<Usuario> entidades);
	
	/**
	 * Converte um VO para uma entidade
	 * @param usuarioVO VO
	 * @return Entidade
	 */
	public Usuario paraEntidade(UsuarioVO usuarioVO);
	
	/**
	 * Busca usuario com nome especificado
	 * @param nome Nome
	 * @return Usuario
	 */
	public Usuario recuperarUsuario(String nome);
	
}
