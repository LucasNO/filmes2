package com.lab6.filme2.service;

import com.lab6.filme2.dao.AvaliacaoDAO;
import com.lab6.filme2.model.Avaliacao;
import java.util.List;

/**
 *
 * @author Lucas Norberto
 */
public class AvaliacaoBO {
    
    private static final long serialVersionUID = -7290834612026599955L;
	
	private AvaliacaoDAO avaliacaoDAO;

	public void avaliarFilme(Avaliacao avaliacao) {
		avaliacaoDAO.salvar(avaliacao);
	}
        public List<Avaliacao> listarClassificacoes() {
		return avaliacaoDAO.todos();
	}
        
        public void deletarAvaliacao(Avaliacao avaliacao){
            avaliacaoDAO.excluir(avaliacao);
        }
        
        public void atualizarAvaliacao(Avaliacao avaliacao){
            avaliacaoDAO.atualizar(avaliacao);
        }

    public AvaliacaoDAO getAvaliacaoDAO() {
        return avaliacaoDAO;
    }

    public void setAvaliacaoDAO(AvaliacaoDAO avaliacaoDAO) {
        this.avaliacaoDAO = avaliacaoDAO;
    }
}
