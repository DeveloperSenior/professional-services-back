package co.com.tdea.professionalservices.dao;

import co.com.tdea.professionalservices.dto.Ciudades;
import co.com.tdea.professionalservices.mapper.CiudadesMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.sql.DataSource;
import java.util.List;


import org.springframework.stereotype.Repository;


@Repository
public class CiudadesDAOImpl implements CiudadesDAO  {

  private static final String INSERT ="INSERT INTO ciudades (cdciudad,cdindicativo,dsciudad,iddepartamento, cdusuario, cdestado, dtfechacreacion) VALUES(?,?,?,?, ? ,?, now())";
    private static final String UPDATE ="UPDATE ciudades set cdciudad = ? ,cdindicativo = ? ,dsciudad = ? ,iddepartamento = ?  , dtfechamodificacion = now() WHERE id = ? ";
    private static final String SELECT ="SELECT * FROM ciudades ";
    private static final String SELECTBYID = SELECT + " WHERE id = ?";
    private static final String DELETE="DELETE FROM ciudades WHERE id = ?";

    JdbcTemplate jdbcTemplate;

    public CiudadesDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Ciudades> getAll() {
        return jdbcTemplate.query(SELECT, new CiudadesMapper());
    }

    @Override
    public Ciudades getById(Long id) {
        try{
            return jdbcTemplate.queryForObject(SELECTBYID, new CiudadesMapper(),id);
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public Ciudades insert(Ciudades entity) {
        jdbcTemplate.update(INSERT,entity.getCdciudad(),entity.getCdindicativo(),entity.getDsciudad(),entity.getIddepartamento(),
                entity.getCdusuario(),
                entity.getCdestado()
                );

        return entity;
    }

    @Override
    public Ciudades update(Ciudades entity) {
        jdbcTemplate.update(UPDATE,
               entity.getCdciudad(),entity.getCdindicativo(),entity.getDsciudad(),entity.getIddepartamento(),entity.getId()
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
