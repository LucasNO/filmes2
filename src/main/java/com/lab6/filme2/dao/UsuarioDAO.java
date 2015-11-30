package com.lab6.filme2.dao;


import com.lab6.filme2.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDAO extends CrudRepository<Usuario, Long> {
	
    public Usuario findByNome(String nome);
}
