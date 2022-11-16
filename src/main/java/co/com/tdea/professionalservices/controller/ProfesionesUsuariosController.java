package co.com.tdea.professionalservices.controller;

import co.com.tdea.professionalservices.controller.base.ResponseBase;
import co.com.tdea.professionalservices.controller.errors.ApplicationCustomException;
import co.com.tdea.professionalservices.dto.ProfesionesUsuarios;
import co.com.tdea.professionalservices.service.ProfesionesUsuariosService;
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
 * REST controller for managing {@link co.com.tdea.professionalservices.dto.ProfesionesUsuarios}.
 */
@RestController
@RequestMapping("/api")
public class ProfesionesUsuariosController extends ResponseBase {

    private final Logger log = LoggerFactory.getLogger(ProfesionesUsuariosController.class);

    private static final String ENTITY_NAME = "ProfesionesUsuarios";


    private final ProfesionesUsuariosService profesionesusuariosService;

    public ProfesionesUsuariosController(ProfesionesUsuariosService profesionesusuariosService) {
        this.profesionesusuariosService = profesionesusuariosService;
    }

    /**
     * {@code POST  /profesionesusuarios} : Create a new profesionesusuarios.
     *
     * @param profesionesusuarios the profesionesusuarios to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new profesionesusuarios, or with status {@code 400 (Bad Request)} if the profesionesusuarios has already an ID.
     */
    @PostMapping("/profesionesusuarios")
    public ResponseEntity<ResponseMessage<ProfesionesUsuarios>> createProfesionesUsuarios(@Valid @RequestBody ProfesionesUsuarios profesionesusuarios) throws ApplicationCustomException {
        log.debug("REST request to save ProfesionesUsuarios : {}", profesionesusuarios);
        ProfesionesUsuarios profesionesusuariosFind = profesionesusuariosService.findOne(profesionesusuarios.getId_profesion());
        if(profesionesusuariosFind != null) {
        	throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_ALREADY_EXISTS, ENTITY_NAME));
        }
        ProfesionesUsuarios result = profesionesusuariosService.save(profesionesusuarios);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result) );
    }

    /**
     * {@code PUT  /profesionesusuarios} : Updates an existing profesionesusuarios.
     *
     * @param profesionesusuarios the profesionesusuarios to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated profesionesusuarios,
     * or with status {@code 400 (Bad Request)} if the profesionesusuarios is not valid,
     * or with status {@code 500 (Internal Server Error)} if the profesionesusuarios couldn't be updated.
     */
    @PutMapping("/profesionesusuarios")
    public ResponseEntity<ResponseMessage<ProfesionesUsuarios>> updateProfesionesUsuarios(@Valid @RequestBody ProfesionesUsuarios profesionesusuarios) throws ApplicationCustomException {
        log.debug("REST request to update ProfesionesUsuarios : {}", profesionesusuarios);
        if (profesionesusuarios.getId_profesion() == 0) {
            throw new ApplicationCustomException(MessagesConstants.ENTITY_NOT_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        ProfesionesUsuarios result = profesionesusuariosService.update(profesionesusuarios);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result) );
    }

    /**
     * {@code GET  /profesionesusuarios} : get all the profesionesusuarioss.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of profesionesusuarioss in body.
     */
    @GetMapping("/profesionesusuarios")
    public ResponseEntity<ResponseMessage<List<ProfesionesUsuarios>>> getAllProfesionesUsuarioss() {
        log.debug("REST request to get all ProfesionesUsuarioss");

        return ResponseEntity.ok( new ResponseMessage<>(0, null, profesionesusuariosService.findAll()) );
    }

    /**
     * {@code GET  /profesionesusuarios/:id} : get the "id" profesionesusuarios.
     *
     * @param id the id of the profesionesusuarios to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the profesionesusuarios, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/profesionesusuarios/{id}")
    public ResponseEntity<ResponseMessage<ProfesionesUsuarios>> getProfesionesUsuarios(@PathVariable Long id) throws ApplicationCustomException {
        log.debug("REST request to get ProfesionesUsuarios : {}", id);
        ProfesionesUsuarios profesionesusuarios = profesionesusuariosService.findOne(id);
        if(profesionesusuarios == null) {
        	throw new ApplicationCustomException(MessagesConstants.ENTITY_NOT_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        return ResponseEntity.ok(new ResponseMessage<>(0, null, profesionesusuarios) );
    }

    /**
     * {@code DELETE  /profesionesusuarios/:id} : delete the "id" profesionesusuarios.
     *
     * @param id the id of the profesionesusuarios to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/profesionesusuarios/{id}")
    public ResponseEntity<ResponseMessage<ProfesionesUsuarios>> deleteProfesionesUsuarios(@PathVariable Long id) {
        log.debug("REST request to delete ProfesionesUsuarios : {}", id);
        profesionesusuariosService.delete(id);
        return ResponseEntity.ok(new ResponseMessage<>(0, null, null) );
    }
}
