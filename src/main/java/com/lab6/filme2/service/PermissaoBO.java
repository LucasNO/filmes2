/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab6.filme2.service;

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

    public PermissaoVO paraPermissaoVO(Permissao entidade) {

        PermissaoVO permissaoVO = new PermissaoVO();
        permissaoVO.setId(entidade.getId());
        permissaoVO.setDescricao(entidade.getDescricao());
        
        return permissaoVO;
    }

    public List<PermissaoVO> paraColecaoPermissaoVO(Collection<Permissao> entidades) {

        List<PermissaoVO> permissoesVO = new ArrayList<>();

        for (Permissao entidade : entidades) {

            permissoesVO.add(paraPermissaoVO(entidade));
        }

        return permissoesVO;
    }
}
