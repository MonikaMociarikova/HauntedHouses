package cz.muni.fi.pa165.controller;

import cz.muni.fi.pa165.ApiUris;
import cz.muni.fi.pa165.dto.HauntingCreateDTO;
import cz.muni.fi.pa165.dto.HauntingDTO;
import cz.muni.fi.pa165.entity.Haunting;
import cz.muni.fi.pa165.facade.HauntingFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @author MonikaMociarikova
 */
@RestController
@RequestMapping(ApiUris.ROOT_URI_HAUNTINGS)
public class HauntingCotroller {

    @Autowired
    private HauntingFacade hauntingFacade;

    @RequestMapping(method = RequestMethod.POST)
    public HauntingDTO createHaunting(@RequestBody HauntingCreateDTO haunting) {
        return hauntingFacade.create(haunting);
    }

    @RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE)
    public Collection<HauntingDTO> getAllHauntings() {
        return hauntingFacade.getAll();
    }

    @RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE, value = "/date/{date}")
    public Collection<HauntingDTO> getHauntingByDate(@PathVariable Date date) {
        return hauntingFacade.getByDate(date);
    }

    @RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE, value = "/{id}")
    public HauntingDTO getHauntingById(@PathVariable long id) {
        return hauntingFacade.getById(id);
    }

    @RequestMapping(method = DELETE)
    public HttpStatus deleteHaunting(@RequestBody HauntingDTO haunting) {
        hauntingFacade.delete(haunting);
        return HttpStatus.OK;
    }

    @RequestMapping(method = PUT)
    public HauntingDTO updateHaunting(@RequestBody HauntingDTO haunting) {
        return hauntingFacade.update(haunting);
    }


}
