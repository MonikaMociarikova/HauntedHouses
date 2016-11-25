package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.dto.GhostCreateDTO;
import cz.muni.fi.pa165.dto.GhostDTO;
import cz.muni.fi.pa165.entity.Ghost;
import cz.muni.fi.pa165.services.GhostService;
import cz.muni.fi.pa165.services.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Ondrej Ponteš
 */
@Service
@Transactional
public class GhostFacadeImpl implements GhostFacade {

    @Autowired
    private MappingService mappingService;

    @Autowired
    private GhostService ghostService;

    @Override
    public GhostDTO createGhost(GhostCreateDTO ghostCreateDTO) {
        Ghost ghost = mappingService.mapObject(ghostCreateDTO, Ghost.class);
        ghost = ghostService.create(ghost);
        return mappingService.mapObject(ghost, GhostDTO.class);
    }

    @Override
    public GhostDTO updateGhost(GhostDTO ghostUpdateDTO) {
        Ghost ghost = mappingService.mapObject(ghostUpdateDTO, Ghost.class);
        ghost = ghostService.update(ghost);
        return mappingService.mapObject(ghost, GhostDTO.class);
    }

    @Override
    public Collection<GhostDTO> getAllGhosts() {
        List<GhostDTO> result = new ArrayList<>();
        for (Ghost ghost : ghostService.getAll()) {
            result.add(mappingService.mapObject(ghost, GhostDTO.class));
        }
        return result;
    }

    @Override
    public Collection<GhostDTO> getGhostsByName(String ghostName) {
        List<GhostDTO> result = new ArrayList<>();
        for (Ghost ghost : ghostService.getByName(ghostName)) {
            result.add(mappingService.mapObject(ghost, GhostDTO.class));
        }
        return result;
    }

    @Override
    public GhostDTO getGhostById(Long ghostId) {
        Ghost ghost = ghostService.getById(ghostId);
        return mappingService.mapObject(ghost, GhostDTO.class);
    }

    @Override
    public void deleteGhost(GhostDTO ghostDTO) {
        Ghost ghost = mappingService.mapObject(ghostDTO, Ghost.class);
        ghostService.delete(ghost);
    }
}
