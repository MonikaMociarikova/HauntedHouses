package cz.muni.fi.pa165.services;

import java.util.List;

import cz.muni.fi.pa165.entity.Ghost;

/**
 * @author Ondrej Ponteš
 */
public interface GhostService {
    Ghost create(Ghost ghost);
    Ghost update(Ghost ghost);
    void delete(Ghost ghost);
    Ghost getById(long id);
    Ghost getByName(String name);
    List<Ghost> getAll();
}
