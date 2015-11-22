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

/**
 *
 * @author Lucas Norberto
 */
@Entity
@Table(name = "avaliacao")
public class Avaliacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idavaliacao")
    private Long idavaliacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nota")
    private int nota;
    @JoinColumn(name = "idfilme", referencedColumnName = "idfilme")
    @ManyToOne(optional = false)
    private Filmes idfilme;

    public Avaliacao() {
    }

    public Avaliacao(Long idavaliacao) {
        this.idavaliacao = idavaliacao;
    }

    public Avaliacao(Long idavaliacao, int nota) {
        this.idavaliacao = idavaliacao;
        this.nota = nota;
    }

    public Long getIdavaliacao() {
        return idavaliacao;
    }

    public void setIdavaliacao(Long idavaliacao) {
        this.idavaliacao = idavaliacao;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Filmes getIdfilme() {
        return idfilme;
    }

    public void setIdfilme(Filmes idfilme) {
        this.idfilme = idfilme;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idavaliacao != null ? idavaliacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avaliacao)) {
            return false;
        }
        Avaliacao other = (Avaliacao) object;
        if ((this.idavaliacao == null && other.idavaliacao != null) || (this.idavaliacao != null && !this.idavaliacao.equals(other.idavaliacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lab6.filme2.model.Avaliacao[ idavaliacao=" + idavaliacao + " ]";
    }
    
}
