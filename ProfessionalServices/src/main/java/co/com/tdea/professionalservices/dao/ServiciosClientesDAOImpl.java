package co.com.tdea.professionalservices.dao;

import co.com.tdea.professionalservices.dto.ServiciosClientes;
import co.com.tdea.professionalservices.mapper.ServiciosClientesMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.sql.DataSource;
import java.util.List;


import org.springframework.stereotype.Repository;


@Repository
public class ServiciosClientesDAOImpl implements ServiciosClientesDAO  {

  private static final String INSERT ="INSERT INTO servicios_clientes (idservicio,cddocumento_cliente, cdusuario, cdestado, dtfechacreacion) VALUES(?,?, ? ,?, now())";
    private static final String UPDATE ="UPDATE servicios_clientes set cddocumento_cliente = ?  , dtfechamodificacion = now() WHERE idservicio = ? ";
    private static final String SELECT ="SELECT * FROM servicios_clientes ";
    private static final String SELECTBYID = SELECT + " WHERE idservicio = ?";
    private static final String DELETE="DELETE FROM servicios_clientes WHERE idservicio = ?";

    JdbcTemplate jdbcTemplate;

    public ServiciosClientesDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<ServiciosClientes> getAll() {
        return jdbcTemplate.query(SELECT, new ServiciosClientesMapper());
    }

    @Override
    public ServiciosClientes getById(Long id) {
        try{
            return jdbcTemplate.queryForObject(SELECTBYID, new ServiciosClientesMapper(),id);
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public ServiciosClientes insert(ServiciosClientes entity) {
        jdbcTemplate.update(INSERT,
                entity.getIdservicio(),entity.getCddocumento_cliente(),
                entity.getCdusuario(),
                entity.getCdestado()
                );

        return entity;
    }

    @Override
    public ServiciosClientes update(ServiciosClientes entity) {
        jdbcTemplate.update(UPDATE,
               entity.getCddocumento_cliente(),entity.getIdservicio()
        );
        return entity;
    }

    @Override
    public Boolean delete(Long id) {
        return jdbcTemplate.update(DELETE,
                id
        )>0;
    }


}
