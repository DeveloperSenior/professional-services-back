package co.com.tdea.professionalservices.dao;

import co.com.tdea.professionalservices.dto.Departamentos;

import java.util.List;


public interface DepartamentosDAO  {
    List<Departamentos> getAll();
    Departamentos getById(Long id);
    Departamentos insert(Departamentos entity);
    Departamentos update(Departamentos entity);
    Boolean delete(Long id);
}
