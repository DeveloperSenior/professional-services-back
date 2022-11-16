package co.com.tdea.professionalservices.service;

import co.com.tdea.professionalservices.dto.ServiciosClientes;
import co.com.tdea.professionalservices.dao.ServiciosClientesDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing {@link ServiciosClientes}.
 */
@Service
@Transactional
public class ServiciosClientesServiceImpl implements ServiciosClientesService {

    private final Logger log = LoggerFactory.getLogger(ServiciosClientesServiceImpl.class);

    private final ServiciosClientesDAO serviciosclientesDAO;

    public ServiciosClientesServiceImpl(ServiciosClientesDAO serviciosclientesDAO) {
        this.serviciosclientesDAO = serviciosclientesDAO;
    }

    @Override
    public ServiciosClientes save(ServiciosClientes serviciosclientes) {
        log.debug("Request to insert ServiciosClientes : {}", serviciosclientes);
        return serviciosclientesDAO.insert(serviciosclientes);
    }

    @Override
    public ServiciosClientes update(ServiciosClientes serviciosclientes) {
        log.debug("Request to update ServiciosClientes : {}", serviciosclientes);
        return serviciosclientesDAO.update(serviciosclientes);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ServiciosClientes> findAll() {
        log.debug("Request to get all ServiciosClientes");
        return serviciosclientesDAO.getAll();
    }


    @Override
    @Transactional(readOnly = true)
    public ServiciosClientes findOne(Long id) {
        log.debug("Request to get ServiciosClientes : {}", id);
        return serviciosclientesDAO.getById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ServiciosClientes : {}", id);
        serviciosclientesDAO.delete(id);
    }
}
