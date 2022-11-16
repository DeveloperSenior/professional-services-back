package co.com.tdea.professionalservices.dao;

import co.com.tdea.professionalservices.dto.CiudadesUsuarios;

import java.util.List;


public interface CiudadesUsuariosDAO  {
    List<CiudadesUsuarios> getAll();
    CiudadesUsuarios getById(Long id);
    CiudadesUsuarios insert(CiudadesUsuarios entity);
    CiudadesUsuarios update(CiudadesUsuarios entity);
    Boolean delete(Long id);
}
