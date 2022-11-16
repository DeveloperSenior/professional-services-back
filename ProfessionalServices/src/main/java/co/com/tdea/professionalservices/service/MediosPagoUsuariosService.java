package co.com.tdea.professionalservices.service;

import co.com.tdea.professionalservices.dto.MediosPagoUsuarios;

import java.util.List;

/**
 * Service Interface for managing {@link MediosPagoUsuarios}.
 */
public interface MediosPagoUsuariosService {

    /**
     * Save a MediosPagoUsuarios.
     *
     * @param mediospagousuarios the entity to save.
     * @return the persisted entity.
     */
    MediosPagoUsuarios save(MediosPagoUsuarios mediospagousuarios);

    /**
     * update a MediosPagoUsuarios.
     *
     * @param mediospagousuarios the entity to update.
     * @return the persisted entity.
     */
    MediosPagoUsuarios update(MediosPagoUsuarios mediospagousuarios);

    /**
     * Get all the MediosPagoUsuarios.
     *
     * @return the list of entities.
     */
    List<MediosPagoUsuarios> findAll();


    /**
     * Get the "id" MediosPagoUsuarios.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    MediosPagoUsuarios findOne(Long id);

    /**
     * Delete the "id" MediosPagoUsuarios.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
