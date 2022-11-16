package co.com.tdea.professionalservices.service;

import co.com.tdea.professionalservices.dto.Ciudades;

import java.util.List;

/**
 * Service Interface for managing {@link Ciudades}.
 */
public interface CiudadesService {

    /**
     * Save a Ciudades.
     *
     * @param ciudades the entity to save.
     * @return the persisted entity.
     */
    Ciudades save(Ciudades ciudades);

    /**
     * update a Ciudades.
     *
     * @param ciudades the entity to update.
     * @return the persisted entity.
     */
    Ciudades update(Ciudades ciudades);

    /**
     * Get all the Ciudades.
     *
     * @return the list of entities.
     */
    List<Ciudades> findAll();


    /**
     * Get the "id" Ciudades.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Ciudades findOne(Long id);

    /**
     * Delete the "id" Ciudades.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
