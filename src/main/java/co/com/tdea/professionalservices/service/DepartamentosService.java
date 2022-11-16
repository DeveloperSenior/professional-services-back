package co.com.tdea.professionalservices.service;

import co.com.tdea.professionalservices.dto.Departamentos;

import java.util.List;

/**
 * Service Interface for managing {@link Departamentos}.
 */
public interface DepartamentosService {

    /**
     * Save a Departamentos.
     *
     * @param departamentos the entity to save.
     * @return the persisted entity.
     */
    Departamentos save(Departamentos departamentos);

    /**
     * update a Departamentos.
     *
     * @param departamentos the entity to update.
     * @return the persisted entity.
     */
    Departamentos update(Departamentos departamentos);

    /**
     * Get all the Departamentos.
     *
     * @return the list of entities.
     */
    List<Departamentos> findAll();


    /**
     * Get the "id" Departamentos.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Departamentos findOne(Long id);

    /**
     * Delete the "id" Departamentos.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
