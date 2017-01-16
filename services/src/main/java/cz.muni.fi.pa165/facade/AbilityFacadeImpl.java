package cz.muni.fi.pa165.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cz.muni.fi.pa165.entity.Ghost;
import cz.muni.fi.pa165.services.GhostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.muni.fi.pa165.dto.AbilityCreateDTO;
import cz.muni.fi.pa165.dto.AbilityDTO;
import cz.muni.fi.pa165.entity.Ability;
import cz.muni.fi.pa165.services.AbilityService;
import cz.muni.fi.pa165.services.MappingService;

/**
 * @author Vojta David, vojtadavid
 */
@Service
@Transactional
public class AbilityFacadeImpl implements AbilityFacade {
    @Autowired
    private MappingService mappingService;

    @Autowired
    private AbilityService abilityService;

    @Autowired
    private GhostService ghostService;


    @Override
    public AbilityDTO create(AbilityCreateDTO abilityCreateDTO) {
        Ability ability = mappingService.mapObject(abilityCreateDTO, Ability.class);
        ability = abilityService.create(ability);
        return mappingService.mapObject(ability, AbilityDTO.class);
    }

    @Override
    public AbilityDTO update(AbilityDTO abilityUpdateDTO) {
        Ability ability = mappingService.mapObject(abilityUpdateDTO, Ability.class);
        ability = abilityService.update(ability);
        return mappingService.mapObject(ability, AbilityDTO.class);
    }

    @Override
    public void delete(AbilityDTO abilityDTO) {
        Ability ability = mappingService.mapObject(abilityDTO, Ability.class);
        List<Ghost> ghosts = ghostService.getByAbility(ability);
        for (Ghost ghost : ghosts ) {
            ghost.removeAbility(ability);
        }
        abilityService.delete(ability);
    }

    @Override
    public void delete(long id) {
        Ability ability = abilityService.getById(id);
        List<Ghost> ghosts = ghostService.getByAbility(ability);
        for (Ghost ghost : ghosts ) {
            ghost.removeAbility(ability);
        }
        abilityService.delete(id);
    }

    @Override
    public AbilityDTO getById(Long id) {
        Ability ability = abilityService.getById(id);
        return mappingService.mapObject(ability, AbilityDTO.class);
    }

    @Override
    public AbilityDTO getByName(String name) {
        Ability ability = abilityService.getByName(name);
        return mappingService.mapObject(ability, AbilityDTO.class);
    }

    @Override
    public Collection<AbilityDTO> getAll() {
//        List<AbilityDTO> abilityDTOs = mappingService.mapCollection(abilityService.getAll(), AbilityDTO.class);
//        return abilityDTOs;
        List<AbilityDTO> result = new ArrayList<>();
        for (Ability ability : abilityService.getAll()) {
            result.add(mappingService.mapObject(ability, AbilityDTO.class));
        }
        return result;
    }
}
