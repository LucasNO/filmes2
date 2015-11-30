/**
 *
 */
package com.lab6.filme2.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.lab6.filme2.model.Usuario;

/**
 * @author Emanuel
 *
 */
@Transactional
public class SegurancaBOImpl implements UserDetailsService {

    private UsuarioBO usuarioBO;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Usuario usuario = usuarioBO.procurarPorNome(userName);

        if (usuario == null) {

            throw new UsernameNotFoundException("Usu�rio n�o encontrado!");
        }

        return usuarioBO.paraUsuarioVO(usuario);
    }

    public void setUsuarioBO(UsuarioBO usuarioBO) {
        this.usuarioBO = usuarioBO;
    }

}
