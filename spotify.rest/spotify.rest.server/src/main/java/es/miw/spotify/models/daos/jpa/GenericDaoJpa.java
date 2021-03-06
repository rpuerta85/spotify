package es.miw.spotify.models.daos.jpa;


import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.miw.spotify.models.daos.GenericDao;
//le ponemos Component, para que Spring pueda inyectarnos El EntityManager que nos creamos en la clase
//SpringRestConfiguration la cual se carga en la carga del programa en el servidor

public class GenericDaoJpa<T, ID> implements GenericDao<T, ID> {
    private Class<T> persistentClass;
  
    public GenericDaoJpa(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }
   
    // Injected database connection:
    @Autowired
    @Qualifier("entityManager")
	 EntityManager entityManager;

	@Override
    public void create(T entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            LogManager.getLogger(GenericDaoJpa.class).debug("create: " + entity);
        } catch (Exception e) {
            LogManager.getLogger(GenericDaoJpa.class).error("create: " + e);
            if (entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
        } finally {
           // entityManager.close();
        }
    }

    @Override
    public T read(ID id) {
        T entity = entityManager.find(persistentClass, id);
        //entityManager.close();
        return entity;
    }

    // Cuando en una relación de colección se elimina un miembro de la
    // colección, se debe borrar de la tabla explicitamente
    @Override
    public void update(T entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
            LogManager.getLogger(GenericDaoJpa.class).debug("update: " + entity);
        } catch (Exception e) {
            LogManager.getLogger(GenericDaoJpa.class).error("update: " + e);
            if (entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
        } finally {
           // entityManager.close();
        }
    }

    @Override
    public void deleteById(ID id) {
        T entity = entityManager.find(persistentClass, id);
        if (entity != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(entity);
                entityManager.getTransaction().commit();
                LogManager.getLogger(GenericDaoJpa.class).debug("delete: " + entity);
            } catch (Exception e) {
                LogManager.getLogger(GenericDaoJpa.class).error("delete: " + e);
                if (entityManager.getTransaction().isActive())
                    entityManager.getTransaction().rollback();
            } finally {
               //entityManager.close();
            }
        }
    }

    @Override
    public List<T> findAll() {
        // Se crea un criterio de consulta
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.persistentClass);

        // Se establece la clausula FROM
        Root<T> root = criteriaQuery.from(this.persistentClass);

        // Se establece la clausula SELECT
        criteriaQuery.select(root); // criteriaQuery.multiselect(root.get(atr))

        // No existen predicados

        // Se realiza la query
        TypedQuery<T> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(0); // El primero es 0
        typedQuery.setMaxResults(0); // Se realiza la query, se buscan todos
        List<T> result = typedQuery.getResultList();
       // entityManager.close();
        return result;
    }

   @Override
	public T readUUID(String idUUID) {
		    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
	        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.persistentClass);
	        Root<T> root = criteriaQuery.from(this.persistentClass);
	        Predicate predicate = criteriaBuilder.equal(root.get("idUUID"),idUUID);
	        criteriaQuery.where(predicate);
	        criteriaQuery.select(root);
	        TypedQuery<T> typedQuery = entityManager.createQuery(criteriaQuery);
	        typedQuery.setFirstResult(0); // El primero es 0
	        typedQuery.setMaxResults(0); // Se realiza la query, se buscan todos
	        List<T> result = typedQuery.getResultList();
	        //entityManager.close();
//	        // Se establece la clausula SELECT
//	        criteriaQuery.select(root); // criteriaQuery.multiselect(root.get(atr))
//
//		   @SuppressWarnings("unchecked")
//		   
//		   T entity = (T) em.createQuery("SELECT :t FROM TABLE :t where t.idUUID = :idUUID").setParameter("idUUID", idUUID).getSingleResult();
//		   em.close();
		 return result.get(0);
	}

}
