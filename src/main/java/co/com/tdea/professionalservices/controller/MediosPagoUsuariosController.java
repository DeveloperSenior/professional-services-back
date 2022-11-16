package co.com.tdea.professionalservices.controller;

import co.com.tdea.professionalservices.controller.base.ResponseBase;
import co.com.tdea.professionalservices.controller.errors.ApplicationCustomException;
import co.com.tdea.professionalservices.dto.MediosPagoUsuarios;
import co.com.tdea.professionalservices.service.MediosPagoUsuariosService;
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
 * REST controller for managing {@link co.com.tdea.professionalservices.dto.MediosPagoUsuarios}.
 */
@RestController
@RequestMapping("/api")
public class MediosPagoUsuariosController extends ResponseBase {

    private final Logger log = LoggerFactory.getLogger(MediosPagoUsuariosController.class);

    private static final String ENTITY_NAME = "MediosPagoUsuarios";


    private final MediosPagoUsuariosService mediospagousuariosService;

    public MediosPagoUsuariosController(MediosPagoUsuariosService mediospagousuariosService) {
        this.mediospagousuariosService = mediospagousuariosService;
    }

    /**
     * {@code POST  /mediospagousuarios} : Create a new mediospagousuarios.
     *
     * @param mediospagousuarios the mediospagousuarios to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new mediospagousuarios, or with status {@code 400 (Bad Request)} if the mediospagousuarios has already an ID.
     */
    @PostMapping("/mediospagousuarios")
    public ResponseEntity<ResponseMessage<MediosPagoUsuarios>> createMediosPagoUsuarios(@Valid @RequestBody MediosPagoUsuarios mediospagousuarios) throws ApplicationCustomException {
        log.debug("REST request to save MediosPagoUsuarios : {}", mediospagousuarios);
        MediosPagoUsuarios mediospagousuariosFind = mediospagousuariosService.findOne(mediospagousuarios.getIdmedio_pago());
        if(mediospagousuariosFind != null) {
        	throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_ALREADY_EXISTS, ENTITY_NAME));
        }
        MediosPagoUsuarios result = mediospagousuariosService.save(mediospagousuarios);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result) );
    }

    /**
     * {@code PUT  /mediospagousuarios} : Updates an existing mediospagousuarios.
     *
     * @param mediospagousuarios the mediospagousuarios to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated mediospagousuarios,
     * or with status {@code 400 (Bad Request)} if the mediospagousuarios is not valid,
     * or with status {@code 500 (Internal Server Error)} if the mediospagousuarios couldn't be updated.
     */
    @PutMapping("/mediospagousuarios")
    public ResponseEntity<ResponseMessage<MediosPagoUsuarios>> updateMediosPagoUsuarios(@Valid @RequestBody MediosPagoUsuarios mediospagousuarios) throws ApplicationCustomException {
        log.debug("REST request to update MediosPagoUsuarios : {}", mediospagousuarios);
        if (mediospagousuarios.getIdmedio_pago() == 0) {
            throw new ApplicationCustomException(MessagesConstants.ENTITY_NOT_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        MediosPagoUsuarios result = mediospagousuariosService.update(mediospagousuarios);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result) );
    }

    /**
     * {@code GET  /mediospagousuarios} : get all the mediospagousuarioss.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of mediospagousuarioss in body.
     */
    @GetMapping("/mediospagousuarios")
    public ResponseEntity<ResponseMessage<List<MediosPagoUsuarios>>> getAllMediosPagoUsuarioss() {
        log.debug("REST request to get all MediosPagoUsuarioss");

        return ResponseEntity.ok( new ResponseMessage<>(0, null, mediospagousuariosService.findAll()) );
    }

    /**
     * {@code GET  /mediospagousuarios/:id} : get the "id" mediospagousuarios.
     *
     * @param id the id of the mediospagousuarios to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the mediospagousuarios, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/mediospagousuarios/{id}")
    public ResponseEntity<ResponseMessage<MediosPagoUsuarios>> getMediosPagoUsuarios(@PathVariable Long id) throws ApplicationCustomException {
        log.debug("REST request to get MediosPagoUsuarios : {}", id);
        MediosPagoUsuarios mediospagousuarios = mediospagousuariosService.findOne(id);
        if(mediospagousuarios == null) {
        	throw new ApplicationCustomException(MessagesConstants.ENTITY_NOT_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        return ResponseEntity.ok(new ResponseMessage<>(0, null, mediospagousuarios) );
    }

    /**
     * {@code DELETE  /mediospagousuarios/:id} : delete the "id" mediospagousuarios.
     *
     * @param id the id of the mediospagousuarios to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/mediospagousuarios/{id}")
    public ResponseEntity<ResponseMessage<MediosPagoUsuarios>> deleteMediosPagoUsuarios(@PathVariable Long id) {
        log.debug("REST request to delete MediosPagoUsuarios : {}", id);
        mediospagousuariosService.delete(id);
        return ResponseEntity.ok(new ResponseMessage<>(0, null, null) );
    }
}
