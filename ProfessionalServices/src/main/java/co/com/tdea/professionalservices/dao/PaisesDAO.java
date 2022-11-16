package co.com.tdea.professionalservices.dao;

import co.com.tdea.professionalservices.dto.Paises;

import java.util.List;


public interface PaisesDAO  {
    List<Paises> getAll();
    Paises getById(Long id);
    Paises insert(Paises entity);
    Paises update(Paises entity);
    Boolean delete(Long id);
}
