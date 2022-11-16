package co.com.tdea.professionalservices.service;

import co.com.tdea.professionalservices.dto.DiplomasUsuarios;

import java.util.List;

/**
 * Service Interface for managing {@link DiplomasUsuarios}.
 */
public interface DiplomasUsuariosService {

    /**
     * Save a DiplomasUsuarios.
     *
     * @param diplomasusuarios the entity to save.
     * @return the persisted entity.
     */
    DiplomasUsuarios save(DiplomasUsuarios diplomasusuarios);

    /**
     * update a DiplomasUsuarios.
     *
     * @param diplomasusuarios the entity to update.
     * @return the persisted entity.
     */
    DiplomasUsuarios update(DiplomasUsuarios diplomasusuarios);

    /**
     * Get all the DiplomasUsuarios.
     *
     * @return the list of entities.
     */
    List<DiplomasUsuarios> findAll();


    /**
     * Get the "id" DiplomasUsuarios.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    DiplomasUsuarios findOne(Long id);

    /**
     * Delete the "id" DiplomasUsuarios.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
