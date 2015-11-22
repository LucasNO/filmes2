package com.lab6.filme2.service;

import com.lab6.filme2.dao.ClassificacaoDAO;
import com.lab6.filme2.model.Classificacao;
import java.util.List;

/**
 *
 * @author Lucas Norberto
 */
public class ClassificacaoBO {
    
    private static final long serialVersionUID = -1124074102177540775L;
	
	private ClassificacaoDAO classificacaoDAO;
	
	public void salvarClassificacao(Classificacao classificacao) {
		classificacaoDAO.salvar(classificacao);
	}
	
	public void editarClassificacao(Classificacao classificacao) {
		classificacaoDAO.atualizar(classificacao);
	}

	public void removerClassificacao(Long id) {
		Classificacao classificacao = classificacaoDAO.pesquisarPorId(id);
		if (classificacao == null) {
			throw new RuntimeException("Nao existe classificação com esse id: " + id);
		}
		classificacaoDAO.excluir(classificacao);
	}

	public List<Classificacao> listarClassificacoes() {
		return classificacaoDAO.todos();
	}
        
        public void deletarAvaliacao(Classificacao classificacao){
            classificacaoDAO.excluir(classificacao);
        }
        
        public Classificacao carregarClassificacao(Long id){
            return classificacaoDAO.pesquisarPorId(id);
        }

    public ClassificacaoDAO getClassificacaoDAO() {
        return classificacaoDAO;
    }

    public void setClassificacaoDAO(ClassificacaoDAO classificacaoDAO) {
        this.classificacaoDAO = classificacaoDAO;
    }
}
