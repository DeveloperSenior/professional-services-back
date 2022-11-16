package co.com.tdea.professionalservices.controller;

import co.com.tdea.professionalservices.controller.base.ResponseBase;
import co.com.tdea.professionalservices.controller.errors.ApplicationCustomException;
import co.com.tdea.professionalservices.dto.CiudadesUsuarios;
import co.com.tdea.professionalservices.service.CiudadesUsuariosService;
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
 * REST controller for managing {@link co.com.tdea.professionalservices.dto.CiudadesUsuarios}.
 */
@RestController
@RequestMapping("/api")
public class CiudadesUsuariosController extends ResponseBase {

    private final Logger log = LoggerFactory.getLogger(CiudadesUsuariosController.class);

    private static final String ENTITY_NAME = "CiudadesUsuarios";


    private final CiudadesUsuariosService ciudadesusuariosService;

    public CiudadesUsuariosController(CiudadesUsuariosService ciudadesusuariosService) {
        this.ciudadesusuariosService = ciudadesusuariosService;
    }

    /**
     * {@code POST  /ciudadesusuarios} : Create a new ciudadesusuarios.
     *
     * @param ciudadesusuarios the ciudadesusuarios to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new ciudadesusuarios, or with status {@code 400 (Bad Request)} if the ciudadesusuarios has already an ID.
     */
    @PostMapping("/ciudadesusuarios")
    public ResponseEntity<ResponseMessage<CiudadesUsuarios>> createCiudadesUsuarios(@Valid @RequestBody CiudadesUsuarios ciudadesusuarios) throws ApplicationCustomException {
        log.debug("REST request to save CiudadesUsuarios : {}", ciudadesusuarios);
        CiudadesUsuarios ciudadesusuariosFind = ciudadesusuariosService.findOne(ciudadesusuarios.getIdciudad());
        if(ciudadesusuariosFind != null) {
        	throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_ALREADY_EXISTS, ENTITY_NAME));
        }
        CiudadesUsuarios result = ciudadesusuariosService.save(ciudadesusuarios);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result) );
    }

    /**
     * {@code PUT  /ciudadesusuarios} : Updates an existing ciudadesusuarios.
     *
     * @param ciudadesusuarios the ciudadesusuarios to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated ciudadesusuarios,
     * or with status {@code 400 (Bad Request)} if the ciudadesusuarios is not valid,
     * or with status {@code 500 (Internal Server Error)} if the ciudadesusuarios couldn't be updated.
     */
    @PutMapping("/ciudadesusuarios")
    public ResponseEntity<ResponseMessage<CiudadesUsuarios>> updateCiudadesUsuarios(@Valid @RequestBody CiudadesUsuarios ciudadesusuarios) throws ApplicationCustomException {
        log.debug("REST request to update CiudadesUsuarios : {}", ciudadesusuarios);
        if (ciudadesusuarios.getIdciudad() == 0) {
            throw new ApplicationCustomException(MessagesConstants.ENTITY_NOT_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        CiudadesUsuarios result = ciudadesusuariosService.update(ciudadesusuarios);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result) );
    }

    /**
     * {@code GET  /ciudadesusuarios} : get all the ciudadesusuarioss.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of ciudadesusuarioss in body.
     */
    @GetMapping("/ciudadesusuarios")
    public ResponseEntity<ResponseMessage<List<CiudadesUsuarios>>> getAllCiudadesUsuarioss() {
        log.debug("REST request to get all CiudadesUsuarioss");

        return ResponseEntity.ok( new ResponseMessage<>(0, null, ciudadesusuariosService.findAll()) );
    }

    /**
     * {@code GET  /ciudadesusuarios/:id} : get the "id" ciudadesusuarios.
     *
     * @param id the id of the ciudadesusuarios to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the ciudadesusuarios, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ciudadesusuarios/{id}")
    public ResponseEntity<ResponseMessage<CiudadesUsuarios>> getCiudadesUsuarios(@PathVariable Long id) throws ApplicationCustomException {
        log.debug("REST request to get CiudadesUsuarios : {}", id);
        CiudadesUsuarios ciudadesusuarios = ciudadesusuariosService.findOne(id);
        if(ciudadesusuarios == null) {
        	throw new ApplicationCustomException(MessagesConstants.ENTITY_NOT_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        return ResponseEntity.ok(new ResponseMessage<>(0, null, ciudadesusuarios) );
    }

    /**
     * {@code DELETE  /ciudadesusuarios/:id} : delete the "id" ciudadesusuarios.
     *
     * @param id the id of the ciudadesusuarios to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/ciudadesusuarios/{id}")
    public ResponseEntity<ResponseMessage<CiudadesUsuarios>> deleteCiudadesUsuarios(@PathVariable Long id) {
        log.debug("REST request to delete CiudadesUsuarios : {}", id);
        ciudadesusuariosService.delete(id);
        return ResponseEntity.ok(new ResponseMessage<>(0, null, null) );
    }
}
