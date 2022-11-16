package co.com.tdea.professionalservices.dao;

import co.com.tdea.professionalservices.dto.AvailableServicesPager;
import co.com.tdea.professionalservices.dto.ServiciosDisponibles;

import java.util.List;


public interface ServiciosDisponiblesDAO  {
    AvailableServicesPager getAll(AvailableServicesPager pager);
    ServiciosDisponibles getById(Long id);
    ServiciosDisponibles insert(ServiciosDisponibles entity);
    ServiciosDisponibles update(ServiciosDisponibles entity);
    Boolean delete(Long id);
}
