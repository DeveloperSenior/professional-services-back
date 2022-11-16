package co.com.tdea.professionalservices.service;

import co.com.tdea.professionalservices.dto.DiplomasUsuarios;
import co.com.tdea.professionalservices.dao.DiplomasUsuariosDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing {@link DiplomasUsuarios}.
 */
@Service
@Transactional
public class DiplomasUsuariosServiceImpl implements DiplomasUsuariosService {

    private final Logger log = LoggerFactory.getLogger(DiplomasUsuariosServiceImpl.class);

    private final DiplomasUsuariosDAO diplomasusuariosDAO;

    public DiplomasUsuariosServiceImpl(DiplomasUsuariosDAO diplomasusuariosDAO) {
        this.diplomasusuariosDAO = diplomasusuariosDAO;
    }

    @Override
    public DiplomasUsuarios save(DiplomasUsuarios diplomasusuarios) {
        log.debug("Request to insert DiplomasUsuarios : {}", diplomasusuarios);
        return diplomasusuariosDAO.insert(diplomasusuarios);
    }

    @Override
    public DiplomasUsuarios update(DiplomasUsuarios diplomasusuarios) {
        log.debug("Request to update DiplomasUsuarios : {}", diplomasusuarios);
        return diplomasusuariosDAO.update(diplomasusuarios);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DiplomasUsuarios> findAll() {
        log.debug("Request to get all DiplomasUsuarios");
        return diplomasusuariosDAO.getAll();
    }


    @Override
    @Transactional(readOnly = true)
    public DiplomasUsuarios findOne(Long id) {
        log.debug("Request to get DiplomasUsuarios : {}", id);
        return diplomasusuariosDAO.getById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete DiplomasUsuarios : {}", id);
        diplomasusuariosDAO.delete(id);
    }
}
