package com.lab6.filme2.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public abstract class DaoGenericoImpl<T, ID extends Serializable> implements DaoGenerico<T, ID> {
	
	private final Class<T> oClass;
	
	private SessionFactory sessionFactory;

	@Override
	public Class<T> getObjectClass() {
		return this.oClass;
	}
	
	@SuppressWarnings("unchecked")
	public DaoGenericoImpl() {
		//determina através do argumento genérico T
		//a classe que será utilizada para o DAO
		this.oClass = (Class<T>)
		((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public T salvar(T object) {
	    if(object == null) {
	    	throw new RuntimeException("Entidade n�o pode ser nula");
	    }
	    getCurrentSession().persist(object);
		return object;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T pesquisarPorId(ID id) {
	    if(id == null) {
	    	throw new RuntimeException("Id n�o pode ser nulo");
	    }
		return (T)getCurrentSession().get(oClass, id);
	}

	@Override
	public T atualizar(T object) {
	    if(object == null) {
	    	throw new RuntimeException("Entidade n�o pode ser nula");
	    }
	    getCurrentSession().merge(object);
		return object;
	}

	@Override
	public void excluir(T object) {
	    if(object == null) {
	    	throw new RuntimeException("Entidade n�o pode ser nula");
	    }
	    getCurrentSession().delete(object);
	}

	@SuppressWarnings("unchecked")
    @Override
	public List<T> todos() {
		return getCurrentSession().createQuery("from " + oClass.getName()).list();
	}
	
    protected final Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }	

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
