package co.com.tdea.professionalservices.dao;

import co.com.tdea.professionalservices.dto.DiplomasUsuarios;

import java.util.List;


public interface DiplomasUsuariosDAO  {
    List<DiplomasUsuarios> getAll();
    DiplomasUsuarios getById(Long id);
    DiplomasUsuarios insert(DiplomasUsuarios entity);
    DiplomasUsuarios update(DiplomasUsuarios entity);
    Boolean delete(Long id);
}
