package co.com.tdea.professionalservices.dao;

import co.com.tdea.professionalservices.dto.Departamentos;
import co.com.tdea.professionalservices.mapper.DepartamentosMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.sql.DataSource;
import java.util.List;


import org.springframework.stereotype.Repository;


@Repository
public class DepartamentosDAOImpl implements DepartamentosDAO  {

  private static final String INSERT ="INSERT INTO departamentos (cddepartamento,dsdepartamento,id_pais, cdusuario, cdestado, dtfechacreacion) VALUES(?,?,?, ? ,?, now())";
    private static final String UPDATE ="UPDATE departamentos set cddepartamento = ? ,dsdepartamento = ? ,id_pais = ?  , dtfechamodificacion = now() WHERE id = ? ";
    private static final String SELECT ="SELECT * FROM departamentos ";
    private static final String SELECTBYID = SELECT + " WHERE id = ?";
    private static final String DELETE="DELETE FROM departamentos WHERE id = ?";

    JdbcTemplate jdbcTemplate;

    public DepartamentosDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Departamentos> getAll() {
        return jdbcTemplate.query(SELECT, new DepartamentosMapper());
    }

    @Override
    public Departamentos getById(Long id) {
        try{
            return jdbcTemplate.queryForObject(SELECTBYID, new DepartamentosMapper(),id);
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public Departamentos insert(Departamentos entity) {
        jdbcTemplate.update(INSERT,entity.getCddepartamento(),entity.getDsdepartamento(),entity.getId_pais(),
                entity.getCdusuario(),
                entity.getCdestado()
                );

        return entity;
    }

    @Override
    public Departamentos update(Departamentos entity) {
        jdbcTemplate.update(UPDATE,
               entity.getCddepartamento(),entity.getDsdepartamento(),entity.getId_pais(),entity.getId()
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
