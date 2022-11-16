package co.com.tdea.professionalservices.dao;

import co.com.tdea.professionalservices.dto.MediosPagoUsuarios;

import java.util.List;


public interface MediosPagoUsuariosDAO  {
    List<MediosPagoUsuarios> getAll();
    MediosPagoUsuarios getById(Long id);
    MediosPagoUsuarios insert(MediosPagoUsuarios entity);
    MediosPagoUsuarios update(MediosPagoUsuarios entity);
    Boolean delete(Long id);
}
