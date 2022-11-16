package co.com.tdea.professionalservices.dao;

import co.com.tdea.professionalservices.dto.DiplomasUsuarios;
import co.com.tdea.professionalservices.mapper.DiplomasUsuariosMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.sql.DataSource;
import java.util.List;


import org.springframework.stereotype.Repository;


@Repository
public class DiplomasUsuariosDAOImpl implements DiplomasUsuariosDAO  {

  private static final String INSERT ="INSERT INTO diplomas_usuarios (id_profesion,cddocumento,dsruta_diploma,cdtarjeta_profesional,fediploma, cdusuario, cdestado, dtfechacreacion) VALUES(?,?,?,?,?, ? ,?, now())";
    private static final String UPDATE ="UPDATE diplomas_usuarios set id_profesion = ? ,dsruta_diploma = ? ,cdtarjeta_profesional = ? ,fediploma = ?  , dtfechamodificacion = now() WHERE id = ? ";
    private static final String SELECT ="SELECT * FROM diplomas_usuarios ";
    private static final String SELECTBYID = SELECT + " WHERE id = ?";
    private static final String DELETE="DELETE FROM diplomas_usuarios WHERE id = ?";

    JdbcTemplate jdbcTemplate;

    public DiplomasUsuariosDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<DiplomasUsuarios> getAll() {
        return jdbcTemplate.query(SELECT, new DiplomasUsuariosMapper());
    }

    @Override
    public DiplomasUsuarios getById(Long id) {
        try{
            return jdbcTemplate.queryForObject(SELECTBYID, new DiplomasUsuariosMapper(),id);
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public DiplomasUsuarios insert(DiplomasUsuarios entity) {
        jdbcTemplate.update(INSERT,entity.getId_profesion(),entity.getCddocumento(),entity.getDsruta_diploma(),entity.getCdtarjeta_profesional(),entity.getFediploma(),
                entity.getCdusuario(),
                entity.getCdestado()
                );

        return entity;
    }

    @Override
    public DiplomasUsuarios update(DiplomasUsuarios entity) {
        jdbcTemplate.update(UPDATE,
               entity.getId_profesion(),entity.getDsruta_diploma(),entity.getCdtarjeta_profesional(),entity.getFediploma(),entity.getId()
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
