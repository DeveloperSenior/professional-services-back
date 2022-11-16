package co.com.tdea.professionalservices.service;

import co.com.tdea.professionalservices.dto.Paises;
import co.com.tdea.professionalservices.dao.PaisesDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing {@link Paises}.
 */
@Service
@Transactional
public class PaisesServiceImpl implements PaisesService {

    private final Logger log = LoggerFactory.getLogger(PaisesServiceImpl.class);

    private final PaisesDAO paisesDAO;

    public PaisesServiceImpl(PaisesDAO paisesDAO) {
        this.paisesDAO = paisesDAO;
    }

    @Override
    public Paises save(Paises paises) {
        log.debug("Request to insert Paises : {}", paises);
        return paisesDAO.insert(paises);
    }

    @Override
    public Paises update(Paises paises) {
        log.debug("Request to update Paises : {}", paises);
        return paisesDAO.update(paises);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Paises> findAll() {
        log.debug("Request to get all Paises");
        return paisesDAO.getAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Paises findOne(Long id) {
        log.debug("Request to get Paises : {}", id);
        return paisesDAO.getById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Paises : {}", id);
        paisesDAO.delete(id);
    }
}
