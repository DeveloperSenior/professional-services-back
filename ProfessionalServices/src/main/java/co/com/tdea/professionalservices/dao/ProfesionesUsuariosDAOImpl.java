package co.com.tdea.professionalservices.dao;

import co.com.tdea.professionalservices.dto.ProfesionesUsuarios;
import co.com.tdea.professionalservices.mapper.ProfesionesUsuariosMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.sql.DataSource;
import java.util.List;


import org.springframework.stereotype.Repository;


@Repository
public class ProfesionesUsuariosDAOImpl implements ProfesionesUsuariosDAO  {

  private static final String INSERT ="INSERT INTO profesiones_usuarios (id_profesion,cddocumento, cdusuario, cdestado, dtfechacreacion) VALUES(?,?, ? ,?, now())";
    private static final String UPDATE ="UPDATE profesiones_usuarios set cddocumento = ?  , dtfechamodificacion = now() WHERE id_profesion = ? ";
    private static final String SELECT ="SELECT * FROM profesiones_usuarios ";
    private static final String SELECTBYID = SELECT + " WHERE id_profesion = ?";
    private static final String DELETE="DELETE FROM profesiones_usuarios WHERE id_profesion = ?";

    JdbcTemplate jdbcTemplate;

    public ProfesionesUsuariosDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<ProfesionesUsuarios> getAll() {
        return jdbcTemplate.query(SELECT, new ProfesionesUsuariosMapper());
    }

    @Override
    public ProfesionesUsuarios getById(Long id) {
        try{
            return jdbcTemplate.queryForObject(SELECTBYID, new ProfesionesUsuariosMapper(),id);
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public ProfesionesUsuarios insert(ProfesionesUsuarios entity) {
        jdbcTemplate.update(INSERT,
                entity.getId_profesion(),entity.getCddocumento(),
                entity.getCdusuario(),
                entity.getCdestado()
                );

        return entity;
    }

    @Override
    public ProfesionesUsuarios update(ProfesionesUsuarios entity) {
        jdbcTemplate.update(UPDATE,
               entity.getCddocumento(),entity.getId_profesion()
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
