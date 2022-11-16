package co.com.tdea.professionalservices.controller;

import co.com.tdea.professionalservices.controller.base.ResponseBase;
import co.com.tdea.professionalservices.controller.errors.ApplicationCustomException;
import co.com.tdea.professionalservices.dto.Usuarios;
import co.com.tdea.professionalservices.service.UsuariosService;
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
 * REST controller for managing {@link co.com.tdea.professionalservices.dto.Usuarios}.
 */
@RestController
@RequestMapping("/api")
public class UsuariosController extends ResponseBase {

    private final Logger log = LoggerFactory.getLogger(UsuariosController.class);

    private static final String ENTITY_NAME = "Usuarios";


    private final UsuariosService usuariosService;

    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }


    /**
     * {@code POST  /usuarios} : Create a new usuarios.
     *
     * @param usuarios the usuarios to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new usuarios, or with status {@code 400 (Bad Request)} if the usuarios has already an ID.
     */
    @PostMapping("/usuarios")
    public ResponseEntity<ResponseMessage<Usuarios>> createUsuarios(@Valid @RequestBody Usuarios usuarios) throws ApplicationCustomException {
        log.debug("REST request to save Usuarios : {}", usuarios);
        Usuarios result;
        Usuarios usuariosFind = usuariosService.findOne(usuarios.getCddocumento());
        if(usuariosFind != null) {
            result = usuariosService.update(usuarios);
        }else {
            result = usuariosService.save(usuarios);
        }
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result) );
    }

    /**
     * {@code PUT  /usuarios} : Updates an existing usuarios.
     *
     * @param usuarios the usuarios to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated usuarios,
     * or with status {@code 400 (Bad Request)} if the usuarios is not valid,
     * or with status {@code 500 (Internal Server Error)} if the usuarios couldn't be updated.
     */
    @PutMapping("/usuarios")
    public ResponseEntity<ResponseMessage<Usuarios>> updateUsuarios(@Valid @RequestBody Usuarios usuarios) throws ApplicationCustomException {
        log.debug("REST request to update Usuarios : {}", usuarios);
        if (usuarios.getCddocumento() == null) {
            throw new ApplicationCustomException(MessagesConstants.ENTITY_NOT_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        Usuarios result = usuariosService.update(usuarios);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result) );
    }

    /**
     * {@code GET  /usuarios} : get all the usuarioss.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of usuarioss in body.
     */
    @GetMapping("/usuarios")
    public ResponseEntity<ResponseMessage<List<Usuarios>>> getAllUsuarioss() {
        log.debug("REST request to get all Usuarioss");

        return ResponseEntity.ok( new ResponseMessage<>(0, null, usuariosService.findAll()) );
    }

    /**
     * {@code GET  /usuarios/:id} : get the "id" usuarios.
     *
     * @param id the id of the usuarios to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the usuarios, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/usuarios/{id}")
    public ResponseEntity<ResponseMessage<Usuarios>> getUsuarios(@PathVariable String id) throws ApplicationCustomException {
        log.debug("REST request to get Usuarios : {}", id);
        Usuarios usuarios = usuariosService.findOne(id);
        if(usuarios == null) {
        	throw new ApplicationCustomException(MessagesConstants.ENTITY_NOT_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        return ResponseEntity.ok(new ResponseMessage<>(0, null, usuarios) );
    }

    /**
     * {@code GET  /usuarios/:email} : get the "email" usuarios.
     *
     * @param id the id of the usuarios to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the usuarios, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/usuarios/info/{email}")
    public ResponseEntity<ResponseMessage<Usuarios>> getInfoUsuario(@PathVariable String email) throws ApplicationCustomException {
        log.debug("REST request to get Usuarios : {}", email);
        Usuarios usuarios = usuariosService.findOneEmail(email);
        if(usuarios == null) {
            throw new ApplicationCustomException(MessagesConstants.ENTITY_NOT_EXISTS_CODE, MessagesConstants.ENTITY_NOT_EXISTS);
        }
        return ResponseEntity.ok(new ResponseMessage<>(0, null, usuarios) );
    }

    /**
     * {@code DELETE  /usuarios/:id} : delete the "id" usuarios.
     *
     * @param id the id of the usuarios to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<ResponseMessage<Usuarios>> deleteUsuarios(@PathVariable String id) {
        log.debug("REST request to delete Usuarios : {}", id);
        usuariosService.delete(id);
        return ResponseEntity.ok(new ResponseMessage<>(0, null, null) );
    }
}
