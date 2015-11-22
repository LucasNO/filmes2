package com.lab6.filme2.dao;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.lab6.filme2.model.Permissao;
import com.lab6.filme2.model.Usuario;
import com.lab6.filme2.vo.PermissaoVO;
import com.lab6.filme2.vo.UsuarioVO;

public class UsuarioDaoImpl extends DaoGenericoImpl<Usuario, Long> implements UsuarioDao {

	private PermissaoDao permissaoDao;
	
	public void setPermissaoDao(PermissaoDao permissaoDao) {
		this.permissaoDao = permissaoDao;
	}
	
	@Override
	public UsuarioVO paraUsuarioVO(Usuario entidade) {
		UsuarioVO usuarioVO = new UsuarioVO();
		usuarioVO.setId(entidade.getId());
		usuarioVO.setNome(entidade.getNome());
		usuarioVO.setSenha(entidade.getSenha());
		usuarioVO.setPermissoes(permissaoDao.paraColecaoPermissaoVO(entidade.getPermissoes()));
		return usuarioVO;
	}

	@Override
	public Collection<UsuarioVO> paraColecaoUsuarioVO(
			Collection<Usuario> entidades) {
		Collection<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
		for(Usuario entidade: entidades) {
			usuarios.add(paraUsuarioVO(entidade));
		}
		return usuarios;
	}

	@Override
	public Usuario paraEntidade(UsuarioVO usuarioVO) {
		Usuario usuario = null;
		if(usuarioVO.getId() != null) {
			usuario = this.pesquisarPorId(usuarioVO.getId());
		}
		if(usuario == null) {
			usuario = new Usuario();
		}
		usuario.setNome(usuarioVO.getNome());
		usuario.setSenha(usuarioVO.getSenha());
		usuario.setPermissoes(new ArrayList<Permissao>());
		for(PermissaoVO permissaoVO: usuarioVO.getPermissoes()) {
			usuario.getPermissoes().add(permissaoDao.paraEntidade(permissaoVO));
		}
		return usuario;
	}

	@Override
	public Usuario recuperarUsuario(String nome) {
		Criteria criteria = this.getCurrentSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("nome", nome));
		criteria.setMaxResults(1);
		return (Usuario) criteria.uniqueResult();
	}

}
