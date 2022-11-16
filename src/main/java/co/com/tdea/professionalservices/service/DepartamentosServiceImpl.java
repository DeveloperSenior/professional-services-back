package co.com.tdea.professionalservices.service;

import co.com.tdea.professionalservices.dto.Departamentos;
import co.com.tdea.professionalservices.dao.DepartamentosDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing {@link Departamentos}.
 */
@Service
@Transactional
public class DepartamentosServiceImpl implements DepartamentosService {

    private final Logger log = LoggerFactory.getLogger(DepartamentosServiceImpl.class);

    private final DepartamentosDAO departamentosDAO;

    public DepartamentosServiceImpl(DepartamentosDAO departamentosDAO) {
        this.departamentosDAO = departamentosDAO;
    }

    @Override
    public Departamentos save(Departamentos departamentos) {
        log.debug("Request to insert Departamentos : {}", departamentos);
        return departamentosDAO.insert(departamentos);
    }

    @Override
    public Departamentos update(Departamentos departamentos) {
        log.debug("Request to update Departamentos : {}", departamentos);
        return departamentosDAO.update(departamentos);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Departamentos> findAll() {
        log.debug("Request to get all Departamentos");
        return departamentosDAO.getAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Departamentos findOne(Long id) {
        log.debug("Request to get Departamentos : {}", id);
        return departamentosDAO.getById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Departamentos : {}", id);
        departamentosDAO.delete(id);
    }
}
