package co.com.tdea.professionalservices.service;

import co.com.tdea.professionalservices.dto.Ciudades;
import co.com.tdea.professionalservices.dao.CiudadesDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing {@link Ciudades}.
 */
@Service
@Transactional
public class CiudadesServiceImpl implements CiudadesService {

    private final Logger log = LoggerFactory.getLogger(CiudadesServiceImpl.class);

    private final CiudadesDAO ciudadesDAO;

    public CiudadesServiceImpl(CiudadesDAO ciudadesDAO) {
        this.ciudadesDAO = ciudadesDAO;
    }

    @Override
    public Ciudades save(Ciudades ciudades) {
        log.debug("Request to insert Ciudades : {}", ciudades);
        return ciudadesDAO.insert(ciudades);
    }

    @Override
    public Ciudades update(Ciudades ciudades) {
        log.debug("Request to update Ciudades : {}", ciudades);
        return ciudadesDAO.update(ciudades);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ciudades> findAll() {
        log.debug("Request to get all Ciudades");
        return ciudadesDAO.getAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Ciudades findOne(Long id) {
        log.debug("Request to get Ciudades : {}", id);
        return ciudadesDAO.getById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Ciudades : {}", id);
        ciudadesDAO.delete(id);
    }
}
