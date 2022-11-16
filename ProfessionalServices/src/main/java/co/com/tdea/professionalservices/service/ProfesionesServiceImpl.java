package co.com.tdea.professionalservices.service;

import co.com.tdea.professionalservices.dto.Profesiones;
import co.com.tdea.professionalservices.dao.ProfesionesDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing {@link Profesiones}.
 */
@Service
@Transactional
public class ProfesionesServiceImpl implements ProfesionesService {

    private final Logger log = LoggerFactory.getLogger(ProfesionesServiceImpl.class);

    private final ProfesionesDAO profesionesDAO;

    public ProfesionesServiceImpl(ProfesionesDAO profesionesDAO) {
        this.profesionesDAO = profesionesDAO;
    }

    @Override
    public Profesiones save(Profesiones profesiones) {
        log.debug("Request to insert Profesiones : {}", profesiones);
        return profesionesDAO.insert(profesiones);
    }

    @Override
    public Profesiones update(Profesiones profesiones) {
        log.debug("Request to update Profesiones : {}", profesiones);
        return profesionesDAO.update(profesiones);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Profesiones> findAll() {
        log.debug("Request to get all Profesiones");
        return profesionesDAO.getAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Profesiones findOne(Long id) {
        log.debug("Request to get Profesiones : {}", id);
        return profesionesDAO.getById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Profesiones : {}", id);
        profesionesDAO.delete(id);
    }
}
