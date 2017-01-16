package cz.muni.fi.pa165.facade;

import java.util.Collection;
import java.util.List;

import cz.muni.fi.pa165.entity.Ghost;
import cz.muni.fi.pa165.entity.Haunting;
import cz.muni.fi.pa165.services.GhostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.muni.fi.pa165.dto.HouseCreateDTO;
import cz.muni.fi.pa165.dto.HouseDTO;
import cz.muni.fi.pa165.entity.House;
import cz.muni.fi.pa165.services.HauntingService;
import cz.muni.fi.pa165.services.HouseService;
import cz.muni.fi.pa165.services.MappingService;

/**
 * @author Jirka Kruml
 */
@Service
@Transactional
public class HouseFacadeImpl implements HouseFacade {

    @Autowired
    private HouseService houseService;

    @Autowired
    private HauntingService hauntingService;

    @Autowired
    private MappingService mappingService;

    @Autowired
    private GhostService ghostService;

    @Override
    public Collection<HouseDTO> getAll() {
        return mappingService.mapCollection(houseService.getAll(), HouseDTO.class);
    }

    @Override
    public HouseDTO getByName(String name) {
        return mappingService.mapObject(houseService.getByName(name), HouseDTO.class);
    }

    @Override
    public HouseDTO getByAddress(String address) {
        return mappingService.mapObject(houseService.getByAddress(address), HouseDTO.class);
    }

    @Override
    public HouseDTO getById(long id) {
        return mappingService.mapObject(houseService.getById(id), HouseDTO.class);
    }

    @Override
    public HouseDTO create(HouseCreateDTO house) {
        return mappingService.mapObject(houseService.create(mappingService.mapObject(house, House.class)), HouseDTO.class);
    }

    @Override
    public HouseDTO update(HouseDTO house) {
        return mappingService.mapObject(houseService.update(mappingService.mapObject(house, House.class)), HouseDTO.class);
    }

    @Override
    public void delete(long id) {
        House house = houseService.getById(id);
        if (house.getName() == "No house") return;
        List<Haunting> hauntings = hauntingService.getHauntingsOfHouse(house);
        for (Haunting haunt : hauntings  ) {
            hauntingService.remove(haunt);
        }
        House defaultHouse = houseService.getByName("No house");
        List<Ghost> ghosts = ghostService.getGhostsOfHouse(house);
        for (Ghost ghost : ghosts ) {
            ghost.setHauntedHouse(defaultHouse);
        }
        houseService.delete(id);
    }
}
