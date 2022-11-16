package co.com.tdea.professionalservices.service;

import co.com.tdea.professionalservices.dto.ProfesionesUsuarios;
import co.com.tdea.professionalservices.dao.ProfesionesUsuariosDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing {@link ProfesionesUsuarios}.
 */
@Service
@Transactional
public class ProfesionesUsuariosServiceImpl implements ProfesionesUsuariosService {

    private final Logger log = LoggerFactory.getLogger(ProfesionesUsuariosServiceImpl.class);

    private final ProfesionesUsuariosDAO profesionesusuariosDAO;

    public ProfesionesUsuariosServiceImpl(ProfesionesUsuariosDAO profesionesusuariosDAO) {
        this.profesionesusuariosDAO = profesionesusuariosDAO;
    }

    @Override
    public ProfesionesUsuarios save(ProfesionesUsuarios profesionesusuarios) {
        log.debug("Request to insert ProfesionesUsuarios : {}", profesionesusuarios);
        return profesionesusuariosDAO.insert(profesionesusuarios);
    }

    @Override
    public ProfesionesUsuarios update(ProfesionesUsuarios profesionesusuarios) {
        log.debug("Request to update ProfesionesUsuarios : {}", profesionesusuarios);
        return profesionesusuariosDAO.update(profesionesusuarios);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProfesionesUsuarios> findAll() {
        log.debug("Request to get all ProfesionesUsuarios");
        return profesionesusuariosDAO.getAll();
    }


    @Override
    @Transactional(readOnly = true)
    public ProfesionesUsuarios findOne(Long id) {
        log.debug("Request to get ProfesionesUsuarios : {}", id);
        return profesionesusuariosDAO.getById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ProfesionesUsuarios : {}", id);
        profesionesusuariosDAO.delete(id);
    }
}
