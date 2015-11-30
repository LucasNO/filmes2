package com.lab6.filme2.service;

import com.lab6.filme2.dao.ClassificacaoDAO;
import com.lab6.filme2.model.Classificacao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas Norberto
 */
public class ClassificacaoBO {
    
    private static final long serialVersionUID = -1124074102177540775L;
	
	private ClassificacaoDAO classificacaoDAO;
	
	public void salvarClassificacao(Classificacao classificacao) {
		classificacaoDAO.save(classificacao);
	}
	
	public void editarClassificacao(Classificacao classificacao) {
		classificacaoDAO.save(classificacao);
	}

	public void removerClassificacao(Long id) {
		Classificacao classificacao = classificacaoDAO.findOne(id);
		if (classificacao == null) {
			throw new RuntimeException("Nao existe classificação com esse id: " + id);
		}
		classificacaoDAO.delete(classificacao);
	}

	public List<Classificacao> listarClassificacoes() {
            
            List<Classificacao> lista = new ArrayList<>();
            
            for (Classificacao item : classificacaoDAO.findAll()) {
                lista.add(item);
            }
            
            return lista;
	}
        
        public void deletarAvaliacao(Classificacao classificacao){
            classificacaoDAO.delete(classificacao);
        }
        
        public Classificacao carregarClassificacao(Long id){
            return classificacaoDAO.findOne(id);
        }

    public ClassificacaoDAO getClassificacaoDAO() {
        return classificacaoDAO;
    }

    public void setClassificacaoDAO(ClassificacaoDAO classificacaoDAO) {
        this.classificacaoDAO = classificacaoDAO;
    }
}
