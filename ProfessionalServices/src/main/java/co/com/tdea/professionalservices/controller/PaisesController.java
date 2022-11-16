package co.com.tdea.professionalservices.controller;

import co.com.tdea.professionalservices.controller.base.ResponseBase;
import co.com.tdea.professionalservices.controller.errors.ApplicationCustomException;
import co.com.tdea.professionalservices.dto.Paises;
import co.com.tdea.professionalservices.service.PaisesService;
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
 * REST controller for managing {@link co.com.tdea.professionalservices.dto.Paises}.
 */
@RestController
@RequestMapping("/api")
public class PaisesController extends ResponseBase {

    private final Logger log = LoggerFactory.getLogger(PaisesController.class);

    private static final String ENTITY_NAME = "Paises";


    private final PaisesService paisesService;

    public PaisesController(PaisesService paisesService) {
        this.paisesService = paisesService;
    }

    /**
     * {@code POST  /paises} : Create a new paises.
     *
     * @param paises the paises to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new paises, or with status {@code 400 (Bad Request)} if the paises has already an ID.
     */
    @PostMapping("/paises")
    public ResponseEntity<ResponseMessage<Paises>> createPaises(@Valid @RequestBody Paises paises) throws ApplicationCustomException {
        log.debug("REST request to save Paises : {}", paises);
        Paises paisesFind = paisesService.findOne(paises.getId());
        if(paisesFind != null) {
        	throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_ALREADY_EXISTS, ENTITY_NAME));
        }
        Paises result = paisesService.save(paises);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result) );
    }

    /**
     * {@code PUT  /paises} : Updates an existing paises.
     *
     * @param paises the paises to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated paises,
     * or with status {@code 400 (Bad Request)} if the paises is not valid,
     * or with status {@code 500 (Internal Server Error)} if the paises couldn't be updated.
     */
    @PutMapping("/paises")
    public ResponseEntity<ResponseMessage<Paises>> updatePaises(@Valid @RequestBody Paises paises) throws ApplicationCustomException {
        log.debug("REST request to update Paises : {}", paises);
        if (paises.getId() == 0) {
            throw new ApplicationCustomException(MessagesConstants.ENTITY_NOT_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        Paises result = paisesService.update(paises);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result) );
    }

    /**
     * {@code GET  /paises} : get all the paisess.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of paisess in body.
     */
    @GetMapping("/paises")
    public ResponseEntity<ResponseMessage<List<Paises>>> getAllPaisess() {
        log.debug("REST request to get all Paisess");

        return ResponseEntity.ok( new ResponseMessage<>(0, null, paisesService.findAll()) );
    }

    /**
     * {@code GET  /paises/:id} : get the "id" paises.
     *
     * @param id the id of the paises to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the paises, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/paises/{id}")
    public ResponseEntity<ResponseMessage<Paises>> getPaises(@PathVariable Long id) throws ApplicationCustomException {
        log.debug("REST request to get Paises : {}", id);
        Paises paises = paisesService.findOne(id);
        if(paises == null) {
        	throw new ApplicationCustomException(MessagesConstants.ENTITY_NOT_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        return ResponseEntity.ok(new ResponseMessage<>(0, null, paises) );
    }

    /**
     * {@code DELETE  /paises/:id} : delete the "id" paises.
     *
     * @param id the id of the paises to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/paises/{id}")
    public ResponseEntity<ResponseMessage<Paises>> deletePaises(@PathVariable Long id) {
        log.debug("REST request to delete Paises : {}", id);
        paisesService.delete(id);
        return ResponseEntity.ok(new ResponseMessage<>(0, null, null) );
    }
}
