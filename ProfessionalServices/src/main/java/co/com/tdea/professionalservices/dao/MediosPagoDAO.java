package co.com.tdea.professionalservices.dao;

import co.com.tdea.professionalservices.dto.MediosPago;

import java.util.List;


public interface MediosPagoDAO  {
    List<MediosPago> getAll();
    MediosPago getById(Long id);
    MediosPago insert(MediosPago entity);
    MediosPago update(MediosPago entity);
    Boolean delete(Long id);
}
