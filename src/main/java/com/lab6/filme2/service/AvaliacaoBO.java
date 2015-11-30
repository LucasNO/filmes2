package com.lab6.filme2.service;

import com.lab6.filme2.dao.AvaliacaoDAO;
import com.lab6.filme2.model.Avaliacao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas Norberto
 */
public class AvaliacaoBO {

    private static final long serialVersionUID = -7290834612026599955L;

    private AvaliacaoDAO avaliacaoDAO;

    public void avaliarFilme(Avaliacao avaliacao) {
        avaliacaoDAO.save(avaliacao);
    }

    public List<Avaliacao> listarClassificacoes() {
        List<Avaliacao> lista = new ArrayList<>();

        for (Avaliacao item : avaliacaoDAO.findAll()) {
            lista.add(item);
        }

        return lista;
    }

    public void deletarAvaliacao(Avaliacao avaliacao) {
        avaliacaoDAO.delete(avaliacao);
    }

    public void atualizarAvaliacao(Avaliacao avaliacao) {
        avaliacaoDAO.save(avaliacao);
    }

    public void setAvaliacaoDAO(AvaliacaoDAO avaliacaoDAO) {
        this.avaliacaoDAO = avaliacaoDAO;
    }
}
