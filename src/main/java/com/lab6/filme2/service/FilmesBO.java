package com.lab6.filme2.service;

import com.lab6.filme2.dao.FilmeDAO;
import com.lab6.filme2.model.Filmes;
import java.util.List;

/**
 *
 * @author Lucas Norberto
 */
public class FilmesBO {
    
    private static final long serialVersionUID = -7324715745410293937L;
	
	private FilmeDAO filmesDAO;

	public void salvarFilme(Filmes filme) {
		filmesDAO.salvar(filme);		
	}

	public void removerFilme(Long id) {
		Filmes filme = filmesDAO.pesquisarPorId(id);
		if (filme == null) {
			throw new RuntimeException("Nao existe filme com esse id: " + id);
		}
		filmesDAO.excluir(filme);
	}

	public List<Filmes> listarFilmes() {
		return filmesDAO.todos();
	}
        
        public Filmes pesquisaFilme(Long id){
            return filmesDAO.pesquisarPorId(id);
        }

    public FilmeDAO getFilmesDAO() {
        return filmesDAO;
    }

    public void setFilmesDAO(FilmeDAO filmesDAO) {
        this.filmesDAO = filmesDAO;
    }
}
