package co.com.tdea.professionalservices.service;

import co.com.tdea.professionalservices.dto.MediosPago;

import java.util.List;

/**
 * Service Interface for managing {@link MediosPago}.
 */
public interface MediosPagoService {

    /**
     * Save a MediosPago.
     *
     * @param mediospago the entity to save.
     * @return the persisted entity.
     */
    MediosPago save(MediosPago mediospago);

    /**
     * update a MediosPago.
     *
     * @param mediospago the entity to update.
     * @return the persisted entity.
     */
    MediosPago update(MediosPago mediospago);

    /**
     * Get all the MediosPago.
     *
     * @return the list of entities.
     */
    List<MediosPago> findAll();


    /**
     * Get the "id" MediosPago.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    MediosPago findOne(Long id);

    /**
     * Delete the "id" MediosPago.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
