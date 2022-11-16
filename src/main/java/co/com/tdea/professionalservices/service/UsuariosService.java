package co.com.tdea.professionalservices.service;

import co.com.tdea.professionalservices.dto.Usuarios;

import java.util.List;

/**
 * Service Interface for managing {@link Usuarios}.
 */
public interface UsuariosService {

    /**
     * Save a Usuarios.
     *
     * @param usuarios the entity to save.
     * @return the persisted entity.
     */
    Usuarios save(Usuarios usuarios);

    /**
     * update a Usuarios.
     *
     * @param usuarios the entity to update.
     * @return the persisted entity.
     */
    Usuarios update(Usuarios usuarios);

    /**
     * Get all the Usuarios.
     *
     * @return the list of entities.
     */
    List<Usuarios> findAll();


    /**
     * Get the "id" Usuarios.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Usuarios findOne(String id);

    /**
     * Get the "email" Usuarios.
     *
     * @param email the id of the entity.
     * @return the entity.
     */
    Usuarios findOneEmail(String email);

    /**
     * Delete the "id" Usuarios.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
