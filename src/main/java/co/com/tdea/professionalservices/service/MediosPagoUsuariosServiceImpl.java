package co.com.tdea.professionalservices.service;

import co.com.tdea.professionalservices.dto.MediosPagoUsuarios;
import co.com.tdea.professionalservices.dao.MediosPagoUsuariosDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing {@link MediosPagoUsuarios}.
 */
@Service
@Transactional
public class MediosPagoUsuariosServiceImpl implements MediosPagoUsuariosService {

    private final Logger log = LoggerFactory.getLogger(MediosPagoUsuariosServiceImpl.class);

    private final MediosPagoUsuariosDAO mediospagousuariosDAO;

    public MediosPagoUsuariosServiceImpl(MediosPagoUsuariosDAO mediospagousuariosDAO) {
        this.mediospagousuariosDAO = mediospagousuariosDAO;
    }

    @Override
    public MediosPagoUsuarios save(MediosPagoUsuarios mediospagousuarios) {
        log.debug("Request to insert MediosPagoUsuarios : {}", mediospagousuarios);
        return mediospagousuariosDAO.insert(mediospagousuarios);
    }

    @Override
    public MediosPagoUsuarios update(MediosPagoUsuarios mediospagousuarios) {
        log.debug("Request to update MediosPagoUsuarios : {}", mediospagousuarios);
        return mediospagousuariosDAO.update(mediospagousuarios);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MediosPagoUsuarios> findAll() {
        log.debug("Request to get all MediosPagoUsuarios");
        return mediospagousuariosDAO.getAll();
    }


    @Override
    @Transactional(readOnly = true)
    public MediosPagoUsuarios findOne(Long id) {
        log.debug("Request to get MediosPagoUsuarios : {}", id);
        return mediospagousuariosDAO.getById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete MediosPagoUsuarios : {}", id);
        mediospagousuariosDAO.delete(id);
    }
}
