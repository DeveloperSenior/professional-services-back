package co.com.tdea.professionalservices.dao;

import co.com.tdea.professionalservices.dto.ProfesionesUsuarios;

import java.util.List;


public interface ProfesionesUsuariosDAO  {
    List<ProfesionesUsuarios> getAll();
    ProfesionesUsuarios getById(Long id);
    ProfesionesUsuarios insert(ProfesionesUsuarios entity);
    ProfesionesUsuarios update(ProfesionesUsuarios entity);
    Boolean delete(Long id);
}
