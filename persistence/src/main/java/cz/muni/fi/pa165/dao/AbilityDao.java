package cz.muni.fi.pa165.dao;

import java.util.List;

import cz.muni.fi.pa165.entity.Ability;

/**
 * @author Vojta David
 */
public interface AbilityDao {
    /**
     * Create Ability
     * @param Ability Ability object for creating
     */
     Ability create(Ability Ability);

    /**
     * Updates Ability
     * @param Ability Ability object for updating
     */
     Ability update(Ability Ability);

    /**
     * Removes Ability
     * @param Ability Ability object for deleting
     */
     void delete(Ability Ability);

    /**
     * Gets Ability by id
     * @param id of Ability to be found
     * @return Ability object with specified id
     */
     Ability getById(long id);

    /**
     * Gets Ability by name
     * @param name of Ability to be found
     * @return list of Ability object with specified name
     */
     Ability getByName(String name);

    /**
     * Gets all Abilitys
     * @return list of all Abilitys.
     */
     List<Ability> getAll();
}
