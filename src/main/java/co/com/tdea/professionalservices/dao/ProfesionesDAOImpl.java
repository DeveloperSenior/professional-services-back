package co.com.tdea.professionalservices.dao;

import co.com.tdea.professionalservices.dto.Profesiones;
import co.com.tdea.professionalservices.mapper.ProfesionesMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.sql.DataSource;
import java.util.List;


import org.springframework.stereotype.Repository;


@Repository
public class ProfesionesDAOImpl implements ProfesionesDAO  {

  private static final String INSERT ="INSERT INTO profesiones (dsnombre, cdusuario, cdestado, dtfechacreacion) VALUES(?, ? ,?, now())";
    private static final String UPDATE ="UPDATE profesiones set dsnombre = ?  , dtfechamodificacion = now() WHERE id = ? ";
    private static final String SELECT ="SELECT * FROM profesiones ";
    private static final String SELECTBYID = SELECT + " WHERE id = ?";
    private static final String DELETE="DELETE FROM profesiones WHERE id = ?";

    JdbcTemplate jdbcTemplate;

    public ProfesionesDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Profesiones> getAll() {
        return jdbcTemplate.query(SELECT, new ProfesionesMapper());
    }

    @Override
    public Profesiones getById(Long id) {
        try{
            return jdbcTemplate.queryForObject(SELECTBYID, new ProfesionesMapper(),id);
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public Profesiones insert(Profesiones entity) {
        jdbcTemplate.update(INSERT,entity.getDsnombre(),
                entity.getCdusuario(),
                entity.getCdestado()
                );

        return entity;
    }

    @Override
    public Profesiones update(Profesiones entity) {
        jdbcTemplate.update(UPDATE,
               entity.getDsnombre(),entity.getId()
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
