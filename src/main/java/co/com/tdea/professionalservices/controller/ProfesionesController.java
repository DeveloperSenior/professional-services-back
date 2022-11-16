package co.com.tdea.professionalservices.controller;

import co.com.tdea.professionalservices.controller.base.ResponseBase;
import co.com.tdea.professionalservices.controller.errors.ApplicationCustomException;
import co.com.tdea.professionalservices.dto.Profesiones;
import co.com.tdea.professionalservices.service.ProfesionesService;
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
 * REST controller for managing {@link co.com.tdea.professionalservices.dto.Profesiones}.
 */
@RestController
@RequestMapping("/api")
public class ProfesionesController extends ResponseBase {

    private final Logger log = LoggerFactory.getLogger(ProfesionesController.class);

    private static final String ENTITY_NAME = "Profesiones";


    private final ProfesionesService profesionesService;

    public ProfesionesController(ProfesionesService profesionesService) {
        this.profesionesService = profesionesService;
    }

    /**
     * {@code POST  /profesiones} : Create a new profesiones.
     *
     * @param profesiones the profesiones to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new profesiones, or with status {@code 400 (Bad Request)} if the profesiones has already an ID.
     */
    @PostMapping("/profesiones")
    public ResponseEntity<ResponseMessage<Profesiones>> createProfesiones(@Valid @RequestBody Profesiones profesiones) throws ApplicationCustomException {
        log.debug("REST request to save Profesiones : {}", profesiones);
        Profesiones profesionesFind = profesionesService.findOne(profesiones.getId());
        if(profesionesFind != null) {
        	throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_ALREADY_EXISTS, ENTITY_NAME));
        }
        Profesiones result = profesionesService.save(profesiones);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result) );
    }

    /**
     * {@code PUT  /profesiones} : Updates an existing profesiones.
     *
     * @param profesiones the profesiones to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated profesiones,
     * or with status {@code 400 (Bad Request)} if the profesiones is not valid,
     * or with status {@code 500 (Internal Server Error)} if the profesiones couldn't be updated.
     */
    @PutMapping("/profesiones")
    public ResponseEntity<ResponseMessage<Profesiones>> updateProfesiones(@Valid @RequestBody Profesiones profesiones) throws ApplicationCustomException {
        log.debug("REST request to update Profesiones : {}", profesiones);
        if (profesiones.getId() == 0) {
            throw new ApplicationCustomException(MessagesConstants.ENTITY_NOT_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        Profesiones result = profesionesService.update(profesiones);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result) );
    }

    /**
     * {@code GET  /profesiones} : get all the profesioness.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of profesioness in body.
     */
    @GetMapping("/profesiones")
    public ResponseEntity<ResponseMessage<List<Profesiones>>> getAllProfesioness() {
        log.debug("REST request to get all Profesioness");

        return ResponseEntity.ok( new ResponseMessage<>(0, null, profesionesService.findAll()) );
    }

    /**
     * {@code GET  /profesiones/:id} : get the "id" profesiones.
     *
     * @param id the id of the profesiones to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the profesiones, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/profesiones/{id}")
    public ResponseEntity<ResponseMessage<Profesiones>> getProfesiones(@PathVariable Long id) throws ApplicationCustomException {
        log.debug("REST request to get Profesiones : {}", id);
        Profesiones profesiones = profesionesService.findOne(id);
        if(profesiones == null) {
        	throw new ApplicationCustomException(MessagesConstants.ENTITY_NOT_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        return ResponseEntity.ok(new ResponseMessage<>(0, null, profesiones) );
    }

    /**
     * {@code DELETE  /profesiones/:id} : delete the "id" profesiones.
     *
     * @param id the id of the profesiones to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/profesiones/{id}")
    public ResponseEntity<ResponseMessage<Profesiones>> deleteProfesiones(@PathVariable Long id) {
        log.debug("REST request to delete Profesiones : {}", id);
        profesionesService.delete(id);
        return ResponseEntity.ok(new ResponseMessage<>(0, null, null) );
    }
}
