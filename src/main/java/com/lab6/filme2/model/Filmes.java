package com.lab6.filme2.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Lucas Norberto
 */
@Entity
@Table(name = "filmes")
public class Filmes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfilme")
    private Long idfilme;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "title")
    private String title;
    @JoinColumn(name = "idclassificacao", referencedColumnName = "idclassificacao")
    @ManyToOne(optional = false)
    private Classificacao idclassificacao;
    public Filmes() {
    }

    public Filmes(Long idfilme) {
        this.idfilme = idfilme;
    }

    public Filmes(Long idfilme, String title) {
        this.idfilme = idfilme;
        this.title = title;
    }

    public Long getIdfilme() {
        return idfilme;
    }

    public void setIdfilme(Long idfilme) {
        this.idfilme = idfilme;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Classificacao getIdclassificacao() {
        return idclassificacao;
    }

    public void setIdclassificacao(Classificacao idclassificacao) {
        this.idclassificacao = idclassificacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfilme != null ? idfilme.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filmes)) {
            return false;
        }
        Filmes other = (Filmes) object;
        if ((this.idfilme == null && other.idfilme != null) || (this.idfilme != null && !this.idfilme.equals(other.idfilme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lab6.filme2.model.Filmes[ idfilme=" + idfilme + " ]";
    }
    
}
