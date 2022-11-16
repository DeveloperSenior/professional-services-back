package co.com.tdea.professionalservices.service;

import co.com.tdea.professionalservices.dto.MediosPago;
import co.com.tdea.professionalservices.dao.MediosPagoDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing {@link MediosPago}.
 */
@Service
@Transactional
public class MediosPagoServiceImpl implements MediosPagoService {

    private final Logger log = LoggerFactory.getLogger(MediosPagoServiceImpl.class);

    private final MediosPagoDAO mediospagoDAO;

    public MediosPagoServiceImpl(MediosPagoDAO mediospagoDAO) {
        this.mediospagoDAO = mediospagoDAO;
    }

    @Override
    public MediosPago save(MediosPago mediospago) {
        log.debug("Request to insert MediosPago : {}", mediospago);
        return mediospagoDAO.insert(mediospago);
    }

    @Override
    public MediosPago update(MediosPago mediospago) {
        log.debug("Request to update MediosPago : {}", mediospago);
        return mediospagoDAO.update(mediospago);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MediosPago> findAll() {
        log.debug("Request to get all MediosPago");
        return mediospagoDAO.getAll();
    }


    @Override
    @Transactional(readOnly = true)
    public MediosPago findOne(Long id) {
        log.debug("Request to get MediosPago : {}", id);
        return mediospagoDAO.getById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete MediosPago : {}", id);
        mediospagoDAO.delete(id);
    }
}
