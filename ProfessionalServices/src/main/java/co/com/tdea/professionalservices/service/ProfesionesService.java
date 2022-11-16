package co.com.tdea.professionalservices.service;

import co.com.tdea.professionalservices.dto.Profesiones;

import java.util.List;

/**
 * Service Interface for managing {@link Profesiones}.
 */
public interface ProfesionesService {

    /**
     * Save a Profesiones.
     *
     * @param profesiones the entity to save.
     * @return the persisted entity.
     */
    Profesiones save(Profesiones profesiones);

    /**
     * update a Profesiones.
     *
     * @param profesiones the entity to update.
     * @return the persisted entity.
     */
    Profesiones update(Profesiones profesiones);

    /**
     * Get all the Profesiones.
     *
     * @return the list of entities.
     */
    List<Profesiones> findAll();


    /**
     * Get the "id" Profesiones.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Profesiones findOne(Long id);

    /**
     * Delete the "id" Profesiones.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
