package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Ghost;

import java.util.List;

/**
 * @author Ondrej Ponteš
 */
public interface GhostDao {
    /**
     * Create ghost
     * @param ghost Ghost object for creating
     */
     Ghost create(Ghost ghost);

    /**
     * Updates ghost
     * @param ghost Ghost object for updating
     */
     Ghost update(Ghost ghost);

    /**
     * Removes ghost
     * @param ghost Ghost object for deleting
     */
     void delete(Ghost ghost);

    /**
     * Gets ghost by id
     * @param id of ghost to be found
     * @return Ghost object with specified id
     */
     Ghost getById(long id);

    /**
     * Gets ghost by name
     * @param name of ghost to be found
     * @return list of Ghost object with specified name
     */
     List<Ghost> getByName(String name);

    /**
     * Gets all ghosts
     * @return list of all ghosts.
     */
     List<Ghost> getAll();
}
