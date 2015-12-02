package com.lab6.filme2.controller;

import com.lab6.filme2.model.Classificacao;
import com.lab6.filme2.model.Filmes;
import com.lab6.filme2.service.ClassificacaoBO;
import com.lab6.filme2.service.FilmesBO;
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
@ManagedBean(name = "filmesController")
@SessionScoped
public class FilmesController {
    
    @ManagedProperty(value = "#{filmesBO}")
    private FilmesBO filmesBO;
    @ManagedProperty(value = "#{classificacaoBO}")
    private ClassificacaoBO classificacaoBO;
    private Boolean editar;
    private Filmes edicao;
    private List<Filmes> resultado;
    private Long idGenero;
    
    public void novo() {
        editar = true;
        edicao = new Filmes();
        edicao.setIdclassificacao(new Classificacao());
    }

    public void salvar() {

        try {
            Classificacao cla = classificacaoBO.carregarClassificacao(idGenero);
            edicao.setIdclassificacao(cla);
            filmesBO.salvarFilme(edicao);
            editar = false;
            WebUtils.incluirMensagemInfo("Filme gravado com sucesso!");
            novo();
        } catch (Throwable t) {

            WebUtils.incluirMensagemErro(WebUtils.recuperarCausa(t));
        }
    }
    
    public void onRowEdit(RowEditEvent event) {
        Long id = ((Filmes) event.getObject()).getIdfilme();
        edicao = filmesBO.pesquisaFilme(id);
        edicao.setTitle(((Filmes) event.getObject()).getTitle());
        filmesBO.editarClassificacao(edicao);
        FacesMessage msg = new FacesMessage("Titulo Editado", ((Filmes) event.getObject()).getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Classificacao) event.getObject()).getTipo());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void deletar() {
        try {
        filmesBO.removerFilme(edicao.getIdfilme());
        WebUtils.incluirMensagemInfo("Filme deletado com sucesso!");
            novo();
        } catch (Throwable t) {
            WebUtils.incluirMensagemErro(WebUtils.recuperarCausa(t));
        }
    }

    public void cancelar() {

        editar = false;
    }

    public void listar() {

        resultado = filmesBO.listarFilmes();
    }

    public void inicializar() {

        editar = false;
    }

    public FilmesBO getFilmesBO() {
        return filmesBO;
    }

    public void setFilmesBO(FilmesBO filmesBO) {
        this.filmesBO = filmesBO;
    }

    public Boolean getEditar() {
        return editar;
    }

    public void setEditar(Boolean editar) {
        this.editar = editar;
    }

    public Filmes getEdicao() {
        return edicao;
    }

    public void setEdicao(Filmes edicao) {
        this.edicao = edicao;
    }

    public List<Filmes> getResultado() {
        return resultado;
    }

    public void setResultado(List<Filmes> resultado) {
        this.resultado = resultado;
    }

    public Long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Long idGenero) {
        this.idGenero = idGenero;
    }

    public ClassificacaoBO getClassificacaoBO() {
        return classificacaoBO;
    }

    public void setClassificacaoBO(ClassificacaoBO classificacaoBO) {
        this.classificacaoBO = classificacaoBO;
    }
}
