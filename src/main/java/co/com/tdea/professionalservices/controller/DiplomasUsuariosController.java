package co.com.tdea.professionalservices.controller;

import co.com.tdea.professionalservices.controller.base.ResponseBase;
import co.com.tdea.professionalservices.controller.errors.ApplicationCustomException;
import co.com.tdea.professionalservices.dto.DiplomasUsuarios;
import co.com.tdea.professionalservices.service.DiplomasUsuariosService;
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
 * REST controller for managing {@link co.com.tdea.professionalservices.dto.DiplomasUsuarios}.
 */
@RestController
@RequestMapping("/api")
public class DiplomasUsuariosController extends ResponseBase {

    private final Logger log = LoggerFactory.getLogger(DiplomasUsuariosController.class);

    private static final String ENTITY_NAME = "DiplomasUsuarios";


    private final DiplomasUsuariosService diplomasusuariosService;

    public DiplomasUsuariosController(DiplomasUsuariosService diplomasusuariosService) {
        this.diplomasusuariosService = diplomasusuariosService;
    }

    /**
     * {@code POST  /diplomasusuarios} : Create a new diplomasusuarios.
     *
     * @param diplomasusuarios the diplomasusuarios to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new diplomasusuarios, or with status {@code 400 (Bad Request)} if the diplomasusuarios has already an ID.
     */
    @PostMapping("/diplomasusuarios")
    public ResponseEntity<ResponseMessage<DiplomasUsuarios>> createDiplomasUsuarios(@Valid @RequestBody DiplomasUsuarios diplomasusuarios) throws ApplicationCustomException {
        log.debug("REST request to save DiplomasUsuarios : {}", diplomasusuarios);
        DiplomasUsuarios diplomasusuariosFind = diplomasusuariosService.findOne(diplomasusuarios.getId());
        if(diplomasusuariosFind != null) {
        	throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_ALREADY_EXISTS, ENTITY_NAME));
        }
        DiplomasUsuarios result = diplomasusuariosService.save(diplomasusuarios);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result) );
    }

    /**
     * {@code PUT  /diplomasusuarios} : Updates an existing diplomasusuarios.
     *
     * @param diplomasusuarios the diplomasusuarios to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated diplomasusuarios,
     * or with status {@code 400 (Bad Request)} if the diplomasusuarios is not valid,
     * or with status {@code 500 (Internal Server Error)} if the diplomasusuarios couldn't be updated.
     */
    @PutMapping("/diplomasusuarios")
    public ResponseEntity<ResponseMessage<DiplomasUsuarios>> updateDiplomasUsuarios(@Valid @RequestBody DiplomasUsuarios diplomasusuarios) throws ApplicationCustomException {
        log.debug("REST request to update DiplomasUsuarios : {}", diplomasusuarios);
        if (diplomasusuarios.getId() == 0) {
            throw new ApplicationCustomException(MessagesConstants.ENTITY_NOT_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        DiplomasUsuarios result = diplomasusuariosService.update(diplomasusuarios);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result) );
    }

    /**
     * {@code GET  /diplomasusuarios} : get all the diplomasusuarioss.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of diplomasusuarioss in body.
     */
    @GetMapping("/diplomasusuarios")
    public ResponseEntity<ResponseMessage<List<DiplomasUsuarios>>> getAllDiplomasUsuarioss() {
        log.debug("REST request to get all DiplomasUsuarioss");

        return ResponseEntity.ok( new ResponseMessage<>(0, null, diplomasusuariosService.findAll()) );
    }

    /**
     * {@code GET  /diplomasusuarios/:id} : get the "id" diplomasusuarios.
     *
     * @param id the id of the diplomasusuarios to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the diplomasusuarios, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/diplomasusuarios/{id}")
    public ResponseEntity<ResponseMessage<DiplomasUsuarios>> getDiplomasUsuarios(@PathVariable Long id) throws ApplicationCustomException {
        log.debug("REST request to get DiplomasUsuarios : {}", id);
        DiplomasUsuarios diplomasusuarios = diplomasusuariosService.findOne(id);
        if(diplomasusuarios == null) {
        	throw new ApplicationCustomException(MessagesConstants.ENTITY_NOT_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        return ResponseEntity.ok(new ResponseMessage<>(0, null, diplomasusuarios) );
    }

    /**
     * {@code DELETE  /diplomasusuarios/:id} : delete the "id" diplomasusuarios.
     *
     * @param id the id of the diplomasusuarios to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/diplomasusuarios/{id}")
    public ResponseEntity<ResponseMessage<DiplomasUsuarios>> deleteDiplomasUsuarios(@PathVariable Long id) {
        log.debug("REST request to delete DiplomasUsuarios : {}", id);
        diplomasusuariosService.delete(id);
        return ResponseEntity.ok(new ResponseMessage<>(0, null, null) );
    }
}
