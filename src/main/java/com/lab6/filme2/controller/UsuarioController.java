/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab6.filme2.controller;

import com.lab6.filme2.model.Permissao;
import com.lab6.filme2.model.Usuario;
import com.lab6.filme2.service.PermissaoBO;
import com.lab6.filme2.service.UsuarioBO;
import com.lab6.filme2.web.WebUtils;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Ronan Ribeiro
 */
@ManagedBean(name = "usuarioController")
@SessionScoped
public class UsuarioController {
    
    @ManagedProperty(value = "#{usuarioBO}")
    private UsuarioBO usuarioBO;
    @ManagedProperty(value = "#{permissaoBO}")
    private PermissaoBO permissaoBO;
    private Boolean editar;
    private Usuario usuario;
    private List<Usuario> resultado;
    private List<Permissao> permissoes;
    private Long idPermissao;
    
    public void novo() {
        editar = true;
        usuario = new Usuario();
        usuario.setPermissoes(new ArrayList<Permissao>());
    }
    
    public void listar() {
        this.resultado = usuarioBO.listarUsuarios();
    }
    
    public void listarPermissoes() {
        this.permissoes = permissaoBO.listarPermissoes();
    }
    
    public void salvar() {
        try {
            Permissao p = permissaoBO.carregarClassificacao(idPermissao);
            usuario.getPermissoes().add(p);
            usuarioBO.salvarUsuario(usuario);
            editar = false;
            WebUtils.incluirMensagemInfo("Usuário gravado com sucesso!");
            novo();
        } catch (Throwable t) {
            WebUtils.incluirMensagemErro(WebUtils.recuperarCausa(t));
        }
    }
    
    public void deletar() {
        try {
            usuarioBO.deletarUsuario(usuario);
            WebUtils.incluirMensagemInfo("Usuário deletado com sucesso!");
            novo();
        } catch (Throwable t) {
            WebUtils.incluirMensagemErro(WebUtils.recuperarCausa(t));
        }
    }
    
    public void onRowEdit(RowEditEvent event) {
        Long id = ((Usuario) event.getObject()).getId();
        usuario = usuarioBO.carregarUsuario(id);
        usuario.setNome(((Usuario) event.getObject()).getNome());
        usuario.setSenha(((Usuario) event.getObject()).getSenha());
        
        Permissao p = permissaoBO.carregarClassificacao(idPermissao);
        List<Permissao> lista = new ArrayList<Permissao>();
        lista.add(p);
        usuario.setPermissoes(lista);
        
        usuarioBO.editarClassificacao(usuario);
        FacesMessage msg = new FacesMessage("Usuário Editado", ((Usuario) event.getObject()).getNome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edição Cancelada", ((Usuario) event.getObject()).getNome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public UsuarioBO getUsuarioBO() {
        return usuarioBO;
    }

    public void setUsuarioBO(UsuarioBO usuarioBO) {
        this.usuarioBO = usuarioBO;
    }

    public PermissaoBO getPermissaoBO() {
        return permissaoBO;
    }

    public void setPermissaoBO(PermissaoBO permissaoBO) {
        this.permissaoBO = permissaoBO;
    }

    public Boolean getEditar() {
        return editar;
    }

    public void setEditar(Boolean editar) {
        this.editar = editar;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getResultado() {
        return resultado;
    }

    public void setResultado(List<Usuario> resultado) {
        this.resultado = resultado;
    }

    public List<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Permissao> permissoes) {
        this.permissoes = permissoes;
    }

    public Long getIdPermissao() {
        return idPermissao;
    }

    public void setIdPermissao(Long idPermissao) {
        this.idPermissao = idPermissao;
    }
}
