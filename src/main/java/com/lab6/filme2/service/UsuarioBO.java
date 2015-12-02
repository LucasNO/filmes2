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
import java.util.List;

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
    
    public List<Usuario> listarUsuarios() {
        List<Usuario> lista = new ArrayList<>();
            
        for (Usuario item : usuarioDAO.findAll()) {
            lista.add(item);
        }
            
        return lista;
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

    public void salvarUsuario(Usuario usuario) {
        this.usuarioDAO.save(usuario);
    }

    public Usuario carregarUsuario(Long id) {
        return this.usuarioDAO.findOne(id);
    }

    public void editarClassificacao(Usuario usuario) {
        this.usuarioDAO.save(usuario);
    }

    public void deletarUsuario(Usuario usuario) {
        Usuario u = this.usuarioDAO.findOne(usuario.getId());
	if (u == null) {
            throw new RuntimeException("Nao existe usuario com esse id: " + usuario.getId());
	}
        this.usuarioDAO.delete(usuario);
    }
    
}
