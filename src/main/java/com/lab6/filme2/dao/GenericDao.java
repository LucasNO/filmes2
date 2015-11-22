package com.lab6.filme2.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Lucas Norberto
 */
@Repository
public class GenericDao<T, ID extends Serializable> {
    private final Class<T> Class;

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public Class<T> getObjectClass() {
        return this.Class;
    }

    @SuppressWarnings("unchecked")
    public GenericDao() {
        this.Class = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Transactional
    public T salvar(T object) {
        if (object == null) {
            throw new RuntimeException("Entidade não pode ser nula");
        }
        getCurrentSession().persist(object);
        return object;
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public T pesquisarPorId(ID id) {
        if (id == null) {
            throw new RuntimeException("Id não pode ser nulo");
        }
        return (T) getCurrentSession().get(Class, id);
    }

    @Transactional
    public T atualizar(T object) {
        if (object == null) {
            throw new RuntimeException("Entidade não pode ser nula");
        }
        getCurrentSession().merge(object);
        return object;
    }

    @Transactional
    public void excluir(T object) {
        if (object == null) {
            throw new RuntimeException("Entidade não pode ser nula");
        }
        getCurrentSession().delete(object);
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<T> todos() {
        return getCurrentSession().createQuery("from " + Class.getName()).list();
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
    public List<T> findAllOrdenado(String orderPropertyName) {
        return getCurrentSession().createQuery("select i from " + Class.getName() + " i order by " + orderPropertyName).list();
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
    public void adicionarAtualizarEmLote(List<T> u) throws Exception {
        int x = 0;
        try {
            for (T t : u) {
                getCurrentSession().saveOrUpdate(t);
                if (x % 10 == 0) {
                    getCurrentSession().flush();
                }
                x++;
            }
        } catch (GenericJDBCException ge) {
            ge.printStackTrace();
            throw ge;
            
        } catch (Exception e) {
            getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            throw e;
        }
    }

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
