/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinance.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import pfinance.utils.HibernateUtil;

/**
 *
 * @author higorlandia
 */
public class DaoGenerico<TCLASS> {

    private Class<TCLASS> persistentClass;
    private Session session;
    private Criteria criteria;
    private Query query;

    /**
     * Constructor
     *
     * @param  Class<TCLASS> persistentClass
     * @param  Session session
     */
    public DaoGenerico(Class<TCLASS> persistentClass) {
        this.persistentClass = persistentClass;
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    public Session getSession() {
        return session;
    }

    public Criteria getCriteria(){
        return criteria = session.createCriteria(persistentClass);
    }

    public void setQuery(String q){
        this.query = session.createQuery(q);
    }

    public TCLASS getResultQuery(){
        TCLASS obj = (TCLASS) this.query.uniqueResult();
        return obj;
    }

    public List<TCLASS> getResultSetQuery(){
        return this.query.list();
    }

    /**
     * Consulta uma Linha da Tabela Generica usando get
     *
     * @param  Serializable id
     * @return TCLASS
     */
    @SuppressWarnings("unchecked")
    public TCLASS get(Serializable id) {
        return (TCLASS) session.get(persistentClass, id);
    }

    /**
     * Consulta uma Linha da Tabela GenÃ©rica usando load
     *
     * @param  Serializable id
     * @return TCLASS
     */
    @SuppressWarnings("unchecked")
    public TCLASS load(Serializable id) {
        return (TCLASS) session.load(persistentClass, id);
    }

    /**
     * Consulta uma Linha da Tabela GenÃ©rica usando load
     *
     * @param  Serializable id
     * @return TCLASS
     */
    @SuppressWarnings("unchecked")
    public TCLASS get(Criterion criterion) {
        Criteria c = session.createCriteria(persistentClass);
        c.add(criterion);
        return (TCLASS) c.list().get(c.list().size()-1);
    }

    /**
     * Salva ou Atualiza Dados na Tabela GenÃ©rica
     *
     * @param  ClaTCLASSzz
     */
    public void saveOrUpdate(TCLASS c) {
        try {
            session.beginTransaction();
            session.saveOrUpdate(c);
            session.getTransaction().commit();
                        session.flush();
        } catch (HibernateException he) {
            he.printStackTrace();
        }

    }

    /**
     * Salva ou Atualiza Dados na Tabela GenÃ©rica
     *
     * @param  ClaTCLASSzz
     */
    public void save(TCLASS c) {
        try {
            session.beginTransaction();
            session.save(c);
            session.getTransaction().commit();
            session.flush();
        } catch (HibernateException he) {
            he.printStackTrace();
        }

    }

    /**
     * Deleta Dados na Tabela GenÃ©rica
     *
     * @param  TCLASS
     */
    public void delete(TCLASS c) {
        try {
            session.beginTransaction();
            session.delete(c);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }

    /**
     * Consulta Todas Linhas de uma Tabela GenÃ©rica em ordem crescente
     *
     * @return List<TCLASS>
     */
    public List<TCLASS> listAll() {
        Criteria c = session.createCriteria(persistentClass);
        //c.addOrder(Order.asc("id"));
        return c.list();
    }

    /**
     * Consulta Todas Linhas de uma Tabela GenÃ©rica em ordem crescente
     *
     * @return List<TCLASS>
     */
    public List<TCLASS> list(Criterion criterion) {
        Criteria c = session.createCriteria(persistentClass);
        c.add(criterion);
        return c.list();
    }

    public void commit(){
        //session.getTransaction().
    }
    /*
    public void execute(){
    try {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Query q = session.createQuery(hql);
    List resultList = q.list();
    //displayResult(resultList);
    session.getTransaction().commit();
    } catch (HibernateException he) {
    he.printStackTrace();
    }
    }
     */
    /*    public List getObjects<Object>(){
    try {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Criteria select = session.createCriteria();
    List resultList = q.list();
    //displayResult(resultList);
    session.getTransaction().commit();
    } catch (HibernateException he) {
    he.printStackTrace();
    }
    }*/
}
