package co.com.tdea.professionalservices.service;

import co.com.tdea.professionalservices.dto.CiudadesUsuarios;

import java.util.List;

/**
 * Service Interface for managing {@link CiudadesUsuarios}.
 */
public interface CiudadesUsuariosService {

    /**
     * Save a CiudadesUsuarios.
     *
     * @param ciudadesusuarios the entity to save.
     * @return the persisted entity.
     */
    CiudadesUsuarios save(CiudadesUsuarios ciudadesusuarios);

    /**
     * update a CiudadesUsuarios.
     *
     * @param ciudadesusuarios the entity to update.
     * @return the persisted entity.
     */
    CiudadesUsuarios update(CiudadesUsuarios ciudadesusuarios);

    /**
     * Get all the CiudadesUsuarios.
     *
     * @return the list of entities.
     */
    List<CiudadesUsuarios> findAll();


    /**
     * Get the "id" CiudadesUsuarios.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    CiudadesUsuarios findOne(Long id);

    /**
     * Delete the "id" CiudadesUsuarios.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
