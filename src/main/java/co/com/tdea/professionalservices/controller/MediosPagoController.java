package co.com.tdea.professionalservices.controller;

import co.com.tdea.professionalservices.controller.base.ResponseBase;
import co.com.tdea.professionalservices.controller.errors.ApplicationCustomException;
import co.com.tdea.professionalservices.dto.MediosPago;
import co.com.tdea.professionalservices.service.MediosPagoService;
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
 * REST controller for managing {@link co.com.tdea.professionalservices.dto.MediosPago}.
 */
@RestController
@RequestMapping("/api")
public class MediosPagoController extends ResponseBase {

    private final Logger log = LoggerFactory.getLogger(MediosPagoController.class);

    private static final String ENTITY_NAME = "MediosPago";


    private final MediosPagoService mediospagoService;

    public MediosPagoController(MediosPagoService mediospagoService) {
        this.mediospagoService = mediospagoService;
    }

    /**
     * {@code POST  /mediospago} : Create a new mediospago.
     *
     * @param mediospago the mediospago to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new mediospago, or with status {@code 400 (Bad Request)} if the mediospago has already an ID.
     */
    @PostMapping("/mediospago")
    public ResponseEntity<ResponseMessage<MediosPago>> createMediosPago(@Valid @RequestBody MediosPago mediospago) throws ApplicationCustomException {
        log.debug("REST request to save MediosPago : {}", mediospago);
        MediosPago mediospagoFind = mediospagoService.findOne(mediospago.getId());
        if(mediospagoFind != null) {
        	throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_ALREADY_EXISTS, ENTITY_NAME));
        }
        MediosPago result = mediospagoService.save(mediospago);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result) );
    }

    /**
     * {@code PUT  /mediospago} : Updates an existing mediospago.
     *
     * @param mediospago the mediospago to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated mediospago,
     * or with status {@code 400 (Bad Request)} if the mediospago is not valid,
     * or with status {@code 500 (Internal Server Error)} if the mediospago couldn't be updated.
     */
    @PutMapping("/mediospago")
    public ResponseEntity<ResponseMessage<MediosPago>> updateMediosPago(@Valid @RequestBody MediosPago mediospago) throws ApplicationCustomException {
        log.debug("REST request to update MediosPago : {}", mediospago);
        if (mediospago.getId() == 0) {
            throw new ApplicationCustomException(MessagesConstants.ENTITY_NOT_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        MediosPago result = mediospagoService.update(mediospago);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result) );
    }

    /**
     * {@code GET  /mediospago} : get all the mediospagos.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of mediospagos in body.
     */
    @GetMapping("/mediospago")
    public ResponseEntity<ResponseMessage<List<MediosPago>>> getAllMediosPagos() {
        log.debug("REST request to get all MediosPagos");

        return ResponseEntity.ok( new ResponseMessage<>(0, null, mediospagoService.findAll()) );
    }

    /**
     * {@code GET  /mediospago/:id} : get the "id" mediospago.
     *
     * @param id the id of the mediospago to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the mediospago, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/mediospago/{id}")
    public ResponseEntity<ResponseMessage<MediosPago>> getMediosPago(@PathVariable Long id) throws ApplicationCustomException {
        log.debug("REST request to get MediosPago : {}", id);
        MediosPago mediospago = mediospagoService.findOne(id);
        if(mediospago == null) {
        	throw new ApplicationCustomException(MessagesConstants.ENTITY_NOT_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        return ResponseEntity.ok(new ResponseMessage<>(0, null, mediospago) );
    }

    /**
     * {@code DELETE  /mediospago/:id} : delete the "id" mediospago.
     *
     * @param id the id of the mediospago to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/mediospago/{id}")
    public ResponseEntity<ResponseMessage<MediosPago>> deleteMediosPago(@PathVariable Long id) {
        log.debug("REST request to delete MediosPago : {}", id);
        mediospagoService.delete(id);
        return ResponseEntity.ok(new ResponseMessage<>(0, null, null) );
    }
}
