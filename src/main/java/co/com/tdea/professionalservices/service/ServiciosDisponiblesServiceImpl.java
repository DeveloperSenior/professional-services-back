package co.com.tdea.professionalservices.service;

import co.com.tdea.professionalservices.dto.AvailableServicesPager;
import co.com.tdea.professionalservices.dto.ServiciosDisponibles;
import co.com.tdea.professionalservices.dao.ServiciosDisponiblesDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing {@link ServiciosDisponibles}.
 */
@Service
@Transactional
public class ServiciosDisponiblesServiceImpl implements ServiciosDisponiblesService {

    private final Logger log = LoggerFactory.getLogger(ServiciosDisponiblesServiceImpl.class);

    private final ServiciosDisponiblesDAO serviciosdisponiblesDAO;

    public ServiciosDisponiblesServiceImpl(ServiciosDisponiblesDAO serviciosdisponiblesDAO) {
        this.serviciosdisponiblesDAO = serviciosdisponiblesDAO;
    }

    @Override
    public ServiciosDisponibles save(ServiciosDisponibles serviciosdisponibles) {
        log.debug("Request to insert ServiciosDisponibles : {}", serviciosdisponibles);
        return serviciosdisponiblesDAO.insert(serviciosdisponibles);
    }

    @Override
    public ServiciosDisponibles update(ServiciosDisponibles serviciosdisponibles) {
        log.debug("Request to update ServiciosDisponibles : {}", serviciosdisponibles);
        return serviciosdisponiblesDAO.update(serviciosdisponibles);
    }

    @Override
    @Transactional(readOnly = true)
    public AvailableServicesPager findAll(AvailableServicesPager pager) {
        log.debug("Request to get all ServiciosDisponibles");
        return serviciosdisponiblesDAO.getAll(pager);
    }


    @Override
    @Transactional(readOnly = true)
    public ServiciosDisponibles findOne(Long id) {
        log.debug("Request to get ServiciosDisponibles : {}", id);
        return serviciosdisponiblesDAO.getById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ServiciosDisponibles : {}", id);
        serviciosdisponiblesDAO.delete(id);
    }
}
