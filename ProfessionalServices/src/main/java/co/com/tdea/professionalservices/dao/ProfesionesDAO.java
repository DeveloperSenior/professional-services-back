package co.com.tdea.professionalservices.dao;

import co.com.tdea.professionalservices.dto.Profesiones;

import java.util.List;


public interface ProfesionesDAO  {
    List<Profesiones> getAll();
    Profesiones getById(Long id);
    Profesiones insert(Profesiones entity);
    Profesiones update(Profesiones entity);
    Boolean delete(Long id);
}
