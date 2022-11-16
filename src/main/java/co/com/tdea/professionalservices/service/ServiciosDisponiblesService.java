package co.com.tdea.professionalservices.service;

import co.com.tdea.professionalservices.dto.AvailableServicesPager;
import co.com.tdea.professionalservices.dto.ServiciosDisponibles;

import java.util.List;

/**
 * Service Interface for managing {@link ServiciosDisponibles}.
 */
public interface ServiciosDisponiblesService {

    /**
     * Save a ServiciosDisponibles.
     *
     * @param serviciosdisponibles the entity to save.
     * @return the persisted entity.
     */
    ServiciosDisponibles save(ServiciosDisponibles serviciosdisponibles);

    /**
     * update a ServiciosDisponibles.
     *
     * @param serviciosdisponibles the entity to update.
     * @return the persisted entity.
     */
    ServiciosDisponibles update(ServiciosDisponibles serviciosdisponibles);

    /**
     * Get all the ServiciosDisponibles.
     *
     * @return the list of entities.
     */
    AvailableServicesPager findAll(AvailableServicesPager pager);


    /**
     * Get the "id" ServiciosDisponibles.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    ServiciosDisponibles findOne(Long id);

    /**
     * Delete the "id" ServiciosDisponibles.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
