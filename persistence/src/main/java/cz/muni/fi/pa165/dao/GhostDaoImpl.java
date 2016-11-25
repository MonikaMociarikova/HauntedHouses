package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Ghost;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Ondrej Ponteš
 */
@Repository
@Transactional
public class GhostDaoImpl implements GhostDao {

    @PersistenceContext
    private EntityManager em;

    public Ghost create(Ghost ghost) {
        em.persist(ghost);
        return ghost;
    }

    public Ghost update(Ghost ghost) {
        return em.merge(ghost);
    }

    public void delete(Ghost ghost) {
        em.remove(ghost);
    }

    public Ghost getById(long id) {
        return em.find(Ghost.class, id);
    }

    public List<Ghost> getByName(String name) {
        if(name == null)
            throw new IllegalArgumentException("name cannot be null");

        return em.createQuery("select ghost from Ghost ghost where ghost.name = :name", Ghost.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Ghost> getAll() {
        return em.createQuery("select ghost from Ghost ghost", Ghost.class)
                .getResultList();
    }
}
