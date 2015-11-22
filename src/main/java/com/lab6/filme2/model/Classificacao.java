package com.lab6.filme2.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Lucas Norberto
 */
@Entity
@Table(name = "classificacao")
public class Classificacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclassificacao")
    private Long idclassificacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo")
    private String tipo;

    public Classificacao() {
    }

    public Classificacao(Long idclassificacao) {
        this.idclassificacao = idclassificacao;
    }

    public Classificacao(Long idclassificacao, String tipo) {
        this.idclassificacao = idclassificacao;
        this.tipo = tipo;
    }

    public Long getIdclassificacao() {
        return idclassificacao;
    }

    public void setIdclassificacao(Long idclassificacao) {
        this.idclassificacao = idclassificacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclassificacao != null ? idclassificacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classificacao)) {
            return false;
        }
        Classificacao other = (Classificacao) object;
        if ((this.idclassificacao == null && other.idclassificacao != null) || (this.idclassificacao != null && !this.idclassificacao.equals(other.idclassificacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lab6.filme2.model.Classificacao[ idclassificacao=" + idclassificacao + " ]";
    }
    
}
