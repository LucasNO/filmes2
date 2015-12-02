/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab6.filme2.service;

import com.lab6.filme2.dao.PermissaoDao;
import com.lab6.filme2.model.Permissao;
import com.lab6.filme2.vo.PermissaoVO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author José Nicodemos Maia Neto<jose at nicomaia.com.br>
 */
public class PermissaoBO {

    private PermissaoDao permissaoDao;
    
    public PermissaoVO paraPermissaoVO(Permissao entidade) {

        PermissaoVO permissaoVO = new PermissaoVO();
        permissaoVO.setId(entidade.getId());
        permissaoVO.setDescricao(entidade.getDescricao());
        
        return permissaoVO;
    }
    
    

    public List<Permissao> listarPermissoes() {
        List<Permissao> lista = new ArrayList<>();
            
        for (Permissao item : permissaoDao.findAll()) {
            lista.add(item);
        }
            
        return lista;
    }

    public List<PermissaoVO> paraColecaoPermissaoVO(Collection<Permissao> entidades) {

        List<PermissaoVO> permissoesVO = new ArrayList<>();

        for (Permissao entidade : entidades) {

            permissoesVO.add(paraPermissaoVO(entidade));
        }

        return permissoesVO;
    }

    public PermissaoDao getPermissaoDao() {
        return permissaoDao;
    }

    public void setPermissaoDao(PermissaoDao permissaoDao) {
        this.permissaoDao = permissaoDao;
    }

    public Permissao carregarClassificacao(Long idPermissao) {
        return this.permissaoDao.findOne(idPermissao);
    }
    
}
