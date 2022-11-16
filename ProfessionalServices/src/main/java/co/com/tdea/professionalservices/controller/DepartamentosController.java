package co.com.tdea.professionalservices.controller;

import co.com.tdea.professionalservices.controller.base.ResponseBase;
import co.com.tdea.professionalservices.controller.errors.ApplicationCustomException;
import co.com.tdea.professionalservices.dto.Departamentos;
import co.com.tdea.professionalservices.service.DepartamentosService;
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
 * REST controller for managing {@link co.com.tdea.professionalservices.dto.Departamentos}.
 */
@RestController
@RequestMapping("/api")
public class DepartamentosController extends ResponseBase {

    private final Logger log = LoggerFactory.getLogger(DepartamentosController.class);

    private static final String ENTITY_NAME = "Departamentos";


    private final DepartamentosService departamentosService;

    public DepartamentosController(DepartamentosService departamentosService) {
        this.departamentosService = departamentosService;
    }

    /**
     * {@code POST  /departamentos} : Create a new departamentos.
     *
     * @param departamentos the departamentos to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new departamentos, or with status {@code 400 (Bad Request)} if the departamentos has already an ID.
     */
    @PostMapping("/departamentos")
    public ResponseEntity<ResponseMessage<Departamentos>> createDepartamentos(@Valid @RequestBody Departamentos departamentos) throws ApplicationCustomException {
        log.debug("REST request to save Departamentos : {}", departamentos);
        Departamentos departamentosFind = departamentosService.findOne(departamentos.getId());
        if(departamentosFind != null) {
        	throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_ALREADY_EXISTS, ENTITY_NAME));
        }
        Departamentos result = departamentosService.save(departamentos);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result) );
    }

    /**
     * {@code PUT  /departamentos} : Updates an existing departamentos.
     *
     * @param departamentos the departamentos to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated departamentos,
     * or with status {@code 400 (Bad Request)} if the departamentos is not valid,
     * or with status {@code 500 (Internal Server Error)} if the departamentos couldn't be updated.
     */
    @PutMapping("/departamentos")
    public ResponseEntity<ResponseMessage<Departamentos>> updateDepartamentos(@Valid @RequestBody Departamentos departamentos) throws ApplicationCustomException {
        log.debug("REST request to update Departamentos : {}", departamentos);
        if (departamentos.getId() == 0) {
            throw new ApplicationCustomException(MessagesConstants.ENTITY_NOT_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        Departamentos result = departamentosService.update(departamentos);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result) );
    }

    /**
     * {@code GET  /departamentos} : get all the departamentoss.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of departamentoss in body.
     */
    @GetMapping("/departamentos")
    public ResponseEntity<ResponseMessage<List<Departamentos>>> getAllDepartamentoss() {
        log.debug("REST request to get all Departamentoss");

        return ResponseEntity.ok( new ResponseMessage<>(0, null, departamentosService.findAll()) );
    }

    /**
     * {@code GET  /departamentos/:id} : get the "id" departamentos.
     *
     * @param id the id of the departamentos to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the departamentos, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/departamentos/{id}")
    public ResponseEntity<ResponseMessage<Departamentos>> getDepartamentos(@PathVariable Long id) throws ApplicationCustomException {
        log.debug("REST request to get Departamentos : {}", id);
        Departamentos departamentos = departamentosService.findOne(id);
        if(departamentos == null) {
        	throw new ApplicationCustomException(MessagesConstants.ENTITY_NOT_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        return ResponseEntity.ok(new ResponseMessage<>(0, null, departamentos) );
    }

    /**
     * {@code DELETE  /departamentos/:id} : delete the "id" departamentos.
     *
     * @param id the id of the departamentos to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/departamentos/{id}")
    public ResponseEntity<ResponseMessage<Departamentos>> deleteDepartamentos(@PathVariable Long id) {
        log.debug("REST request to delete Departamentos : {}", id);
        departamentosService.delete(id);
        return ResponseEntity.ok(new ResponseMessage<>(0, null, null) );
    }
}
