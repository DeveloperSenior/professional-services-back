package co.com.tdea.professionalservices.controller;

import co.com.tdea.professionalservices.controller.base.ResponseBase;
import co.com.tdea.professionalservices.controller.errors.ApplicationCustomException;
import co.com.tdea.professionalservices.dto.Ciudades;
import co.com.tdea.professionalservices.service.CiudadesService;
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
 * REST controller for managing {@link co.com.tdea.professionalservices.dto.Ciudades}.
 */
@RestController
@RequestMapping("/api")
public class CiudadesController extends ResponseBase {

    private final Logger log = LoggerFactory.getLogger(CiudadesController.class);

    private static final String ENTITY_NAME = "Ciudades";


    private final CiudadesService ciudadesService;

    public CiudadesController(CiudadesService ciudadesService) {
        this.ciudadesService = ciudadesService;
    }

    /**
     * {@code POST  /ciudades} : Create a new ciudades.
     *
     * @param ciudades the ciudades to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new ciudades, or with status {@code 400 (Bad Request)} if the ciudades has already an ID.
     */
    @PostMapping("/ciudades")
    public ResponseEntity<ResponseMessage<Ciudades>> createCiudades(@Valid @RequestBody Ciudades ciudades) throws ApplicationCustomException {
        log.debug("REST request to save Ciudades : {}", ciudades);
        Ciudades ciudadesFind = ciudadesService.findOne(ciudades.getId());
        if(ciudadesFind != null) {
        	throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_ALREADY_EXISTS, ENTITY_NAME));
        }
        Ciudades result = ciudadesService.save(ciudades);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result) );
    }

    /**
     * {@code PUT  /ciudades} : Updates an existing ciudades.
     *
     * @param ciudades the ciudades to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated ciudades,
     * or with status {@code 400 (Bad Request)} if the ciudades is not valid,
     * or with status {@code 500 (Internal Server Error)} if the ciudades couldn't be updated.
     */
    @PutMapping("/ciudades")
    public ResponseEntity<ResponseMessage<Ciudades>> updateCiudades(@Valid @RequestBody Ciudades ciudades) throws ApplicationCustomException {
        log.debug("REST request to update Ciudades : {}", ciudades);
        if (ciudades.getId() == 0) {
            throw new ApplicationCustomException(MessagesConstants.ENTITY_NOT_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        Ciudades result = ciudadesService.update(ciudades);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result) );
    }

    /**
     * {@code GET  /ciudades} : get all the ciudadess.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of ciudadess in body.
     */
    @GetMapping("/ciudades")
    public ResponseEntity<ResponseMessage<List<Ciudades>>> getAllCiudadess() {
        log.debug("REST request to get all Ciudadess");

        return ResponseEntity.ok( new ResponseMessage<>(0, null, ciudadesService.findAll()) );
    }

    /**
     * {@code GET  /ciudades/:id} : get the "id" ciudades.
     *
     * @param id the id of the ciudades to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the ciudades, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ciudades/{id}")
    public ResponseEntity<ResponseMessage<Ciudades>> getCiudades(@PathVariable Long id) throws ApplicationCustomException {
        log.debug("REST request to get Ciudades : {}", id);
        Ciudades ciudades = ciudadesService.findOne(id);
        if(ciudades == null) {
        	throw new ApplicationCustomException(MessagesConstants.ENTITY_NOT_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        return ResponseEntity.ok(new ResponseMessage<>(0, null, ciudades) );
    }

    /**
     * {@code DELETE  /ciudades/:id} : delete the "id" ciudades.
     *
     * @param id the id of the ciudades to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/ciudades/{id}")
    public ResponseEntity<ResponseMessage<Ciudades>> deleteCiudades(@PathVariable Long id) {
        log.debug("REST request to delete Ciudades : {}", id);
        ciudadesService.delete(id);
        return ResponseEntity.ok(new ResponseMessage<>(0, null, null) );
    }
}
