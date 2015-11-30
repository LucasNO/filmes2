/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab6.filme2.service;

import com.lab6.filme2.dao.UsuarioDAO;
import com.lab6.filme2.model.Usuario;
import com.lab6.filme2.vo.UsuarioVO;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author José Nicodemos Maia Neto<jose at nicomaia.com.br>
 */
public class UsuarioBO {
    
    private UsuarioDAO usuarioDAO;
    private PermissaoBO permissaoBO;
    
    public Usuario procurarPorNome(String nome) {
        
        return usuarioDAO.findByNome(nome);
    }

    public UsuarioVO paraUsuarioVO(Usuario entidade) {
        
        UsuarioVO usuarioVO = new UsuarioVO();
        usuarioVO.setId(entidade.getId());
        usuarioVO.setNome(entidade.getNome());
        usuarioVO.setSenha(entidade.getSenha());
        usuarioVO.setPermissoes(permissaoBO.paraColecaoPermissaoVO(entidade.getPermissoes()));
        
        return usuarioVO;
    }

    public Collection<UsuarioVO> paraColecaoUsuarioVO(Collection<Usuario> entidades) {
        
        Collection<UsuarioVO> usuarios = new ArrayList<>();
        
        for (Usuario entidade : entidades) {
            
            usuarios.add(paraUsuarioVO(entidade));
        }
        
        return usuarios;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        
        this.usuarioDAO = usuarioDAO;
    }

    public void setPermissaoBO(PermissaoBO permissaoBO) {
        
        this.permissaoBO = permissaoBO;
    }
    
}
