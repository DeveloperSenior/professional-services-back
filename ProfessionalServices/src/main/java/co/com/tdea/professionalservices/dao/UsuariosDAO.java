package co.com.tdea.professionalservices.dao;

import co.com.tdea.professionalservices.dto.Usuarios;

import java.util.List;


public interface UsuariosDAO  {
    List<Usuarios> getAll();
    Usuarios getById(String id);
    Usuarios getByEmail(String email);
    Usuarios insert(Usuarios entity);
    Usuarios update(Usuarios entity);
    Boolean delete(String id);
}
