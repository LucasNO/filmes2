package com.lab6.filme2.controller;

import com.lab6.filme2.model.Classificacao;
import com.lab6.filme2.model.Filmes;
import com.lab6.filme2.service.FilmesBO;
import com.lab6.filme2.web.WebUtils;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Lucas Norberto
 */
@ManagedBean(name = "filmesController")
@SessionScoped
public class FilmesController {
    
    @ManagedProperty(value = "#{filmesBO}")
    private FilmesBO filmesBO;
    private Boolean editar;
    private Filmes edicao;
    private List<Filmes> resultado;
    
    public void novo() {
        editar = true;
        edicao = new Filmes();
        edicao.setIdclassificacao(new Classificacao());
    }

    public void salvar() {

        try {
            filmesBO.salvarFilme(edicao);
            editar = false;
            WebUtils.incluirMensagemInfo("Filme gravado com sucesso!");
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
}
