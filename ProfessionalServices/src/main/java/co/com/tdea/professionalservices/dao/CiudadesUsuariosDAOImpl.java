package co.com.tdea.professionalservices.dao;

import co.com.tdea.professionalservices.dto.CiudadesUsuarios;
import co.com.tdea.professionalservices.mapper.CiudadesUsuariosMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.sql.DataSource;
import java.util.List;


import org.springframework.stereotype.Repository;


@Repository
public class CiudadesUsuariosDAOImpl implements CiudadesUsuariosDAO  {

  private static final String INSERT ="INSERT INTO ciudades_usuarios (idciudad,cddocumento,snpreferencia, cdusuario, cdestado, dtfechacreacion) VALUES(?,?,?, ? ,?, now())";
    private static final String UPDATE ="UPDATE ciudades_usuarios set snpreferencia = ?  , dtfechamodificacion = now() WHERE idciudad = ? ";
    private static final String SELECT ="SELECT * FROM ciudades_usuarios ";
    private static final String SELECTBYID = SELECT + " WHERE idciudad = ?";
    private static final String DELETE="DELETE FROM ciudades_usuarios WHERE idciudad = ?";

    JdbcTemplate jdbcTemplate;

    public CiudadesUsuariosDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<CiudadesUsuarios> getAll() {
        return jdbcTemplate.query(SELECT, new CiudadesUsuariosMapper());
    }

    @Override
    public CiudadesUsuarios getById(Long id) {
        try{
            return jdbcTemplate.queryForObject(SELECTBYID, new CiudadesUsuariosMapper(),id);
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public CiudadesUsuarios insert(CiudadesUsuarios entity) {
        jdbcTemplate.update(INSERT,
                entity.getIdciudad(),entity.getCddocumento(),entity.getSnpreferencia(),
                entity.getCdusuario(),
                entity.getCdestado()
                );

        return entity;
    }

    @Override
    public CiudadesUsuarios update(CiudadesUsuarios entity) {
        jdbcTemplate.update(UPDATE,
               entity.getSnpreferencia(),entity.getIdciudad()
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
