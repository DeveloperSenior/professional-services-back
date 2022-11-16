package co.com.tdea.professionalservices.service;

import co.com.tdea.professionalservices.dto.Paises;

import java.util.List;

/**
 * Service Interface for managing {@link Paises}.
 */
public interface PaisesService {

    /**
     * Save a Paises.
     *
     * @param paises the entity to save.
     * @return the persisted entity.
     */
    Paises save(Paises paises);

    /**
     * update a Paises.
     *
     * @param paises the entity to update.
     * @return the persisted entity.
     */
    Paises update(Paises paises);

    /**
     * Get all the Paises.
     *
     * @return the list of entities.
     */
    List<Paises> findAll();


    /**
     * Get the "id" Paises.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Paises findOne(Long id);

    /**
     * Delete the "id" Paises.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
