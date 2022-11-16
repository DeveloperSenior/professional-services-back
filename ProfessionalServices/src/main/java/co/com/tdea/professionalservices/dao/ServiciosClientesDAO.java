package co.com.tdea.professionalservices.dao;

import co.com.tdea.professionalservices.dto.ServiciosClientes;

import java.util.List;


public interface ServiciosClientesDAO  {
    List<ServiciosClientes> getAll();
    ServiciosClientes getById(Long id);
    ServiciosClientes insert(ServiciosClientes entity);
    ServiciosClientes update(ServiciosClientes entity);
    Boolean delete(Long id);
}
