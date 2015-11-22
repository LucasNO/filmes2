/**
 * 
 */
package com.lab6.filme2.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.lab6.filme2.dao.UsuarioDao;
import com.lab6.filme2.model.Usuario;

/**
 * @author Emanuel
 *
 */
@Transactional
public class SegurancaBOImpl implements UserDetailsService  {
	
	private UsuarioDao usuarioDao;
	
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Usuario usuario = usuarioDao.recuperarUsuario(userName);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usu�rio n�o encontrado!");
		}
		return usuarioDao.paraUsuarioVO(usuario);
	}

}
