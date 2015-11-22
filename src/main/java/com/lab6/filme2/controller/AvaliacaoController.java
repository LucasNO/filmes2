package com.lab6.filme2.controller;

import com.lab6.filme2.model.Avaliacao;
import com.lab6.filme2.model.Filmes;
import com.lab6.filme2.service.AvaliacaoBO;
import com.lab6.filme2.service.FilmesBO;
import com.lab6.filme2.web.WebUtils;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author Lucas Norberto
 */
@ManagedBean(name="avaliacaoController")
public class AvaliacaoController {
    
    private Boolean editar;
    @ManagedProperty(value="#{avaliacaoBO}")
    private AvaliacaoBO avaliacaoBO;
    @ManagedProperty(value="#{filmesBO}")
    private FilmesBO filmesBO;
    private Avaliacao avaliacao = new Avaliacao();
    private List<Avaliacao> resultado;
    private Long idFilme;
    
    public void novo() {
        editar = true;
        avaliacao = new Avaliacao();
    }
    
    public void salvar() {
        try {
            Filmes filme = filmesBO.pesquisaFilme(idFilme);
            avaliacao.setIdfilme(filme);
            avaliacaoBO.avaliarFilme(avaliacao);
            editar = false;
            WebUtils.incluirMensagemInfo("Avaliacao gravada com sucesso!");
            novo();
        } catch (Throwable t) {
            WebUtils.incluirMensagemErro(WebUtils.recuperarCausa(t));
        }
    }
    
    public void editar() {
        avaliacaoBO.atualizarAvaliacao(avaliacao);
    }
    
    public void deletar() {
        avaliacaoBO.deletarAvaliacao(avaliacao);
    }
    
    public void listar() {
        resultado = avaliacaoBO.listarClassificacoes();
    }

    public AvaliacaoBO getAvaliacaoBO() {
        return avaliacaoBO;
    }

    public void setAvaliacaoBO(AvaliacaoBO avaliacaoBO) {
        this.avaliacaoBO = avaliacaoBO;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacaoVO(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public List<Avaliacao> getResultado() {
        return resultado;
    }

    public void setResultado(List<Avaliacao> resultado) {
        this.resultado = resultado;
    }

    public Boolean getEditar() {
        return editar;
    }

    public void setEditar(Boolean editar) {
        this.editar = editar;
    }   

    public Long getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Long idFilme) {
        this.idFilme = idFilme;
    }

    public FilmesBO getFilmesBO() {
        return filmesBO;
    }

    public void setFilmesBO(FilmesBO filmesBO) {
        this.filmesBO = filmesBO;
    }
}
