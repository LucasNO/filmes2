/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab6.filme2.dao;

import com.lab6.filme2.model.Filmes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author José Nicodemos Maia Neto<jose at nicomaia.com.br>
 */
@Repository(value = "filmesDAO")
public interface FilmeDAO extends CrudRepository<Filmes, Long> {
    
}
