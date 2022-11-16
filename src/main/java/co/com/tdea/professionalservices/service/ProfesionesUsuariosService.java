package co.com.tdea.professionalservices.service;

import co.com.tdea.professionalservices.dto.ProfesionesUsuarios;

import java.util.List;

/**
 * Service Interface for managing {@link ProfesionesUsuarios}.
 */
public interface ProfesionesUsuariosService {

    /**
     * Save a ProfesionesUsuarios.
     *
     * @param profesionesusuarios the entity to save.
     * @return the persisted entity.
     */
    ProfesionesUsuarios save(ProfesionesUsuarios profesionesusuarios);

    /**
     * update a ProfesionesUsuarios.
     *
     * @param profesionesusuarios the entity to update.
     * @return the persisted entity.
     */
    ProfesionesUsuarios update(ProfesionesUsuarios profesionesusuarios);

    /**
     * Get all the ProfesionesUsuarios.
     *
     * @return the list of entities.
     */
    List<ProfesionesUsuarios> findAll();


    /**
     * Get the "id" ProfesionesUsuarios.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    ProfesionesUsuarios findOne(Long id);

    /**
     * Delete the "id" ProfesionesUsuarios.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
