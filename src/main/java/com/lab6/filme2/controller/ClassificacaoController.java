package com.lab6.filme2.controller;

import com.lab6.filme2.model.Classificacao;
import com.lab6.filme2.service.ClassificacaoBO;
import com.lab6.filme2.web.WebUtils;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Lucas Norberto
 */
@ManagedBean(name = "tipoController")
@SessionScoped
public class ClassificacaoController {
    
    private Boolean editar;
    @ManagedProperty(value = "#{classificacaoBO}")
    private ClassificacaoBO classificacaoBO;
    private Classificacao edicao;
    private List<Classificacao> resultado;
    
    public void novo() {
        editar = true;
        edicao = new Classificacao();
    }

    public void salvar() {
        try {
            classificacaoBO.salvarClassificacao(edicao);
            editar = false;
            WebUtils.incluirMensagemInfo("Classificacao gravada com sucesso!");
            novo();
        } catch (Throwable t) {
            WebUtils.incluirMensagemErro(WebUtils.recuperarCausa(t));
        }
    }
    
    public void onRowEdit(RowEditEvent event) {
        Long id = ((Classificacao) event.getObject()).getIdclassificacao();
        edicao = classificacaoBO.carregarClassificacao(id);
        edicao.setTipo(((Classificacao) event.getObject()).getTipo());
        classificacaoBO.editarClassificacao(edicao);
        FacesMessage msg = new FacesMessage("Tipo Editado", ((Classificacao) event.getObject()).getTipo());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Classificacao) event.getObject()).getTipo());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void deletar() {
        try {
        classificacaoBO.deletarAvaliacao(edicao);
        WebUtils.incluirMensagemInfo("Classificacao deletado com sucesso!");
            novo();
        } catch (Throwable t) {
            WebUtils.incluirMensagemErro(WebUtils.recuperarCausa(t));
        }
    }

    public void cancelar() {
        editar = false;
    }
    
    public void listar() {
        resultado = classificacaoBO.listarClassificacoes();
    }

    public void inicializar() {

        editar = false;
    }

    public Boolean getEditar() {
        return editar;
    }

    public void setEditar(Boolean editar) {
        this.editar = editar;
    }

    public ClassificacaoBO getClassificacaoBO() {
        return classificacaoBO;
    }

    public void setClassificacaoBO(ClassificacaoBO classificacaoBO) {
        this.classificacaoBO = classificacaoBO;
    }

    public Classificacao getEdicao() {
        return edicao;
    }

    public void setEdicao(Classificacao edicao) {
        this.edicao = edicao;
    }

    public List<Classificacao> getResultado() {
        return resultado;
    }

    public void setResultado(List<Classificacao> resultado) {
        this.resultado = resultado;
    }
}
