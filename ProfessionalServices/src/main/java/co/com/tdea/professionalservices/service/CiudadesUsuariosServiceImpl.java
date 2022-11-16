package co.com.tdea.professionalservices.service;

import co.com.tdea.professionalservices.dto.CiudadesUsuarios;
import co.com.tdea.professionalservices.dao.CiudadesUsuariosDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing {@link CiudadesUsuarios}.
 */
@Service
@Transactional
public class CiudadesUsuariosServiceImpl implements CiudadesUsuariosService {

    private final Logger log = LoggerFactory.getLogger(CiudadesUsuariosServiceImpl.class);

    private final CiudadesUsuariosDAO ciudadesusuariosDAO;

    public CiudadesUsuariosServiceImpl(CiudadesUsuariosDAO ciudadesusuariosDAO) {
        this.ciudadesusuariosDAO = ciudadesusuariosDAO;
    }

    @Override
    public CiudadesUsuarios save(CiudadesUsuarios ciudadesusuarios) {
        log.debug("Request to insert CiudadesUsuarios : {}", ciudadesusuarios);
        return ciudadesusuariosDAO.insert(ciudadesusuarios);
    }

    @Override
    public CiudadesUsuarios update(CiudadesUsuarios ciudadesusuarios) {
        log.debug("Request to update CiudadesUsuarios : {}", ciudadesusuarios);
        return ciudadesusuariosDAO.update(ciudadesusuarios);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CiudadesUsuarios> findAll() {
        log.debug("Request to get all CiudadesUsuarios");
        return ciudadesusuariosDAO.getAll();
    }


    @Override
    @Transactional(readOnly = true)
    public CiudadesUsuarios findOne(Long id) {
        log.debug("Request to get CiudadesUsuarios : {}", id);
        return ciudadesusuariosDAO.getById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete CiudadesUsuarios : {}", id);
        ciudadesusuariosDAO.delete(id);
    }
}
