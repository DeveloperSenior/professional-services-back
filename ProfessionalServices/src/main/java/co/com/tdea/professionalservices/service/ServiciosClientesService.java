package co.com.tdea.professionalservices.service;

import co.com.tdea.professionalservices.dto.ServiciosClientes;

import java.util.List;

/**
 * Service Interface for managing {@link ServiciosClientes}.
 */
public interface ServiciosClientesService {

    /**
     * Save a ServiciosClientes.
     *
     * @param serviciosclientes the entity to save.
     * @return the persisted entity.
     */
    ServiciosClientes save(ServiciosClientes serviciosclientes);

    /**
     * update a ServiciosClientes.
     *
     * @param serviciosclientes the entity to update.
     * @return the persisted entity.
     */
    ServiciosClientes update(ServiciosClientes serviciosclientes);

    /**
     * Get all the ServiciosClientes.
     *
     * @return the list of entities.
     */
    List<ServiciosClientes> findAll();


    /**
     * Get the "id" ServiciosClientes.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    ServiciosClientes findOne(Long id);

    /**
     * Delete the "id" ServiciosClientes.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
