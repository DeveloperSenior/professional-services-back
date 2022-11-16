package co.com.tdea.professionalservices.service;

import co.com.tdea.professionalservices.dto.Usuarios;
import co.com.tdea.professionalservices.dao.UsuariosDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing {@link Usuarios}.
 */
@Service
@Transactional
public class UsuariosServiceImpl implements UsuariosService {

    private final Logger log = LoggerFactory.getLogger(UsuariosServiceImpl.class);

    private final UsuariosDAO usuariosDAO;

    public UsuariosServiceImpl(UsuariosDAO usuariosDAO) {
        this.usuariosDAO = usuariosDAO;
    }

    @Override
    public Usuarios save(Usuarios usuarios) {
        log.debug("Request to insert Usuarios : {}", usuarios);
        return usuariosDAO.insert(usuarios);
    }

    @Override
    public Usuarios update(Usuarios usuarios) {
        log.debug("Request to update Usuarios : {}", usuarios);
        return usuariosDAO.update(usuarios);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuarios> findAll() {
        log.debug("Request to get all Usuarios");
        return usuariosDAO.getAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Usuarios findOne(String id) {
        log.debug("Request to get Usuarios : {}", id);
        return usuariosDAO.getById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuarios findOneEmail(String email) {
        return usuariosDAO.getByEmail(email);
    }

    @Override
    public void delete(String id) {
        log.debug("Request to delete Usuarios : {}", id);
        usuariosDAO.delete(id);
    }
}
