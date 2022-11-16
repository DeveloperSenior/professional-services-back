package co.com.tdea.professionalservices.dao;

import co.com.tdea.professionalservices.dto.Ciudades;

import java.util.List;


public interface CiudadesDAO  {
    List<Ciudades> getAll();
    Ciudades getById(Long id);
    Ciudades insert(Ciudades entity);
    Ciudades update(Ciudades entity);
    Boolean delete(Long id);
}
