package com.lab6.filme2.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.lab6.filme2.model.Permissao;
import com.lab6.filme2.vo.PermissaoVO;

public class PermissaoDaoImpl extends DaoGenericoImpl<Permissao, Long> implements PermissaoDao {

	@Override
	public PermissaoVO paraPermissaoVO(Permissao entidade) {
		PermissaoVO permissaoVO = new PermissaoVO();
		permissaoVO.setId(entidade.getId());
		permissaoVO.setDescricao(entidade.getDescricao());
		return permissaoVO;
	}

	@Override
	public List<PermissaoVO> paraColecaoPermissaoVO(
			Collection<Permissao> entidades) {
		List<PermissaoVO> permissoesVO = new ArrayList<PermissaoVO>();
		for(Permissao entidade: entidades) {
			permissoesVO.add(paraPermissaoVO(entidade));
		}
		return permissoesVO;
	}

	@Override
	public Permissao paraEntidade(PermissaoVO permissaoVO) {
		Permissao permissao = null;
		if(permissaoVO.getId() != null) {
			permissao = this.pesquisarPorId(permissaoVO.getId());
		}
		if(permissao == null) {
			permissao = new Permissao();
		}
		permissao.setDescricao(permissaoVO.getDescricao());
		return permissao;
	}


}
