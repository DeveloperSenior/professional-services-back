package co.com.tdea.professionalservices.controller;

import co.com.tdea.professionalservices.controller.base.ResponseBase;
import co.com.tdea.professionalservices.controller.errors.ApplicationCustomException;
import co.com.tdea.professionalservices.dto.AvailableServicesPager;
import co.com.tdea.professionalservices.dto.ServiciosDisponibles;
import co.com.tdea.professionalservices.service.ServiciosDisponiblesService;
import co.com.tdea.professionalservices.util.ResponseMessage;
import co.com.tdea.professionalservices.util.MessagesConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * REST controller for managing {@link co.com.tdea.professionalservices.dto.ServiciosDisponibles}.
 */
@RestController
@RequestMapping("/api")
public class ServiciosDisponiblesController extends ResponseBase {

    private final Logger log = LoggerFactory.getLogger(ServiciosDisponiblesController.class);

    private static final String ENTITY_NAME = "ServiciosDisponibles";


    private final ServiciosDisponiblesService serviciosdisponiblesService;

    public ServiciosDisponiblesController(ServiciosDisponiblesService serviciosdisponiblesService) {
        this.serviciosdisponiblesService = serviciosdisponiblesService;
    }

    /**
     * {@code POST  /serviciosdisponibles} : Create a new serviciosdisponibles.
     *
     * @param serviciosdisponibles the serviciosdisponibles to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new serviciosdisponibles, or with status {@code 400 (Bad Request)} if the serviciosdisponibles has already an ID.
     */
    @PostMapping("/serviciosdisponibles")
    public ResponseEntity<ResponseMessage<ServiciosDisponibles>> createServiciosDisponibles(@Valid @RequestBody ServiciosDisponibles serviciosdisponibles) throws ApplicationCustomException {
        log.debug("REST request to save ServiciosDisponibles : {}", serviciosdisponibles);
        ServiciosDisponibles serviciosdisponiblesFind = serviciosdisponiblesService.findOne(serviciosdisponibles.getId());
        if(serviciosdisponiblesFind != null) {
        	throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_ALREADY_EXISTS, ENTITY_NAME));
        }
        ServiciosDisponibles result = serviciosdisponiblesService.save(serviciosdisponibles);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result) );
    }

    /**
     * {@code PUT  /serviciosdisponibles} : Updates an existing serviciosdisponibles.
     *
     * @param serviciosdisponibles the serviciosdisponibles to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated serviciosdisponibles,
     * or with status {@code 400 (Bad Request)} if the serviciosdisponibles is not valid,
     * or with status {@code 500 (Internal Server Error)} if the serviciosdisponibles couldn't be updated.
     */
    @PutMapping("/serviciosdisponibles")
    public ResponseEntity<ResponseMessage<ServiciosDisponibles>> updateServiciosDisponibles(@Valid @RequestBody ServiciosDisponibles serviciosdisponibles) throws ApplicationCustomException {
        log.debug("REST request to update ServiciosDisponibles : {}", serviciosdisponibles);
        if (serviciosdisponibles.getId() == 0) {
            throw new ApplicationCustomException(MessagesConstants.ENTITY_NOT_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        ServiciosDisponibles result = serviciosdisponiblesService.update(serviciosdisponibles);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result) );
    }

    /**
     * {@code GET  /serviciosdisponibles} : get all the serviciosdisponibless.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of serviciosdisponibless in body.
     */
    @PostMapping("/serviciosdisponibles/{offset}/{size}")
    public ResponseEntity<ResponseMessage<AvailableServicesPager>> getAllServiciosDisponibless(@RequestBody ServiciosDisponibles filter, @PathVariable String offset, @PathVariable String size) {
        AvailableServicesPager page = new AvailableServicesPager();
        page.setFilter(filter);
        page.setOffset(Long.parseLong(offset));
        page.setSize(Long.parseLong(size));
        return ResponseEntity.ok( new ResponseMessage<>(0, null, serviciosdisponiblesService.findAll(page)) );
    }

    /**
     * {@code GET  /serviciosdisponibles/:id} : get the "id" serviciosdisponibles.
     *
     * @param id the id of the serviciosdisponibles to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the serviciosdisponibles, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/serviciosdisponibles/{id}")
    public ResponseEntity<ResponseMessage<ServiciosDisponibles>> getServiciosDisponibles(@PathVariable Long id) throws ApplicationCustomException {
        log.debug("REST request to get ServiciosDisponibles : {}", id);
        ServiciosDisponibles serviciosdisponibles = serviciosdisponiblesService.findOne(id);
        if(serviciosdisponibles == null) {
        	throw new ApplicationCustomException(MessagesConstants.ENTITY_NOT_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        return ResponseEntity.ok(new ResponseMessage<>(0, null, serviciosdisponibles) );
    }

    /**
     * {@code DELETE  /serviciosdisponibles/:id} : delete the "id" serviciosdisponibles.
     *
     * @param id the id of the serviciosdisponibles to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/serviciosdisponibles/{id}")
    public ResponseEntity<ResponseMessage<ServiciosDisponibles>> deleteServiciosDisponibles(@PathVariable Long id) {
        log.debug("REST request to delete ServiciosDisponibles : {}", id);
        serviciosdisponiblesService.delete(id);
        return ResponseEntity.ok(new ResponseMessage<>(0, null, null) );
    }
}
