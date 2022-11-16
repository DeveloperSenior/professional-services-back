package co.com.tdea.professionalservices.controller;

import co.com.tdea.professionalservices.controller.base.ResponseBase;
import co.com.tdea.professionalservices.controller.errors.ApplicationCustomException;
import co.com.tdea.professionalservices.dto.ServiciosClientes;
import co.com.tdea.professionalservices.service.ServiciosClientesService;
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
 * REST controller for managing {@link co.com.tdea.professionalservices.dto.ServiciosClientes}.
 */
@RestController
@RequestMapping("/api")
public class ServiciosClientesController extends ResponseBase {

    private final Logger log = LoggerFactory.getLogger(ServiciosClientesController.class);

    private static final String ENTITY_NAME = "ServiciosClientes";


    private final ServiciosClientesService serviciosclientesService;

    public ServiciosClientesController(ServiciosClientesService serviciosclientesService) {
        this.serviciosclientesService = serviciosclientesService;
    }

    /**
     * {@code POST  /serviciosclientes} : Create a new serviciosclientes.
     *
     * @param serviciosclientes the serviciosclientes to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new serviciosclientes, or with status {@code 400 (Bad Request)} if the serviciosclientes has already an ID.
     */
    @PostMapping("/serviciosclientes")
    public ResponseEntity<ResponseMessage<ServiciosClientes>> createServiciosClientes(@Valid @RequestBody ServiciosClientes serviciosclientes) throws ApplicationCustomException {
        log.debug("REST request to save ServiciosClientes : {}", serviciosclientes);
        ServiciosClientes serviciosclientesFind = serviciosclientesService.findOne(serviciosclientes.getIdservicio());
        if(serviciosclientesFind != null) {
        	throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_ALREADY_EXISTS, ENTITY_NAME));
        }
        ServiciosClientes result = serviciosclientesService.save(serviciosclientes);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result) );
    }

    /**
     * {@code PUT  /serviciosclientes} : Updates an existing serviciosclientes.
     *
     * @param serviciosclientes the serviciosclientes to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated serviciosclientes,
     * or with status {@code 400 (Bad Request)} if the serviciosclientes is not valid,
     * or with status {@code 500 (Internal Server Error)} if the serviciosclientes couldn't be updated.
     */
    @PutMapping("/serviciosclientes")
    public ResponseEntity<ResponseMessage<ServiciosClientes>> updateServiciosClientes(@Valid @RequestBody ServiciosClientes serviciosclientes) throws ApplicationCustomException {
        log.debug("REST request to update ServiciosClientes : {}", serviciosclientes);
        if (serviciosclientes.getIdservicio() == 0) {
            throw new ApplicationCustomException(MessagesConstants.ENTITY_NOT_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        ServiciosClientes result = serviciosclientesService.update(serviciosclientes);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result) );
    }

    /**
     * {@code GET  /serviciosclientes} : get all the serviciosclientess.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of serviciosclientess in body.
     */
    @GetMapping("/serviciosclientes")
    public ResponseEntity<ResponseMessage<List<ServiciosClientes>>> getAllServiciosClientess() {
        log.debug("REST request to get all ServiciosClientess");

        return ResponseEntity.ok( new ResponseMessage<>(0, null, serviciosclientesService.findAll()) );
    }

    /**
     * {@code GET  /serviciosclientes/:id} : get the "id" serviciosclientes.
     *
     * @param id the id of the serviciosclientes to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the serviciosclientes, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/serviciosclientes/{id}")
    public ResponseEntity<ResponseMessage<ServiciosClientes>> getServiciosClientes(@PathVariable Long id) throws ApplicationCustomException {
        log.debug("REST request to get ServiciosClientes : {}", id);
        ServiciosClientes serviciosclientes = serviciosclientesService.findOne(id);
        if(serviciosclientes == null) {
        	throw new ApplicationCustomException(MessagesConstants.ENTITY_NOT_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        return ResponseEntity.ok(new ResponseMessage<>(0, null, serviciosclientes) );
    }

    /**
     * {@code DELETE  /serviciosclientes/:id} : delete the "id" serviciosclientes.
     *
     * @param id the id of the serviciosclientes to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/serviciosclientes/{id}")
    public ResponseEntity<ResponseMessage<ServiciosClientes>> deleteServiciosClientes(@PathVariable Long id) {
        log.debug("REST request to delete ServiciosClientes : {}", id);
        serviciosclientesService.delete(id);
        return ResponseEntity.ok(new ResponseMessage<>(0, null, null) );
    }
}
