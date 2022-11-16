package co.com.tdea.professionalservices.dao;

import co.com.tdea.professionalservices.dto.Paises;
import co.com.tdea.professionalservices.mapper.PaisesMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.sql.DataSource;
import java.util.List;


import org.springframework.stereotype.Repository;


@Repository
public class PaisesDAOImpl implements PaisesDAO  {

  private static final String INSERT ="INSERT INTO paises (cdpais,cdindicativo,cdmoneda, cdusuario, cdestado, dtfechacreacion) VALUES(?,?,?, ? ,?, now())";
    private static final String UPDATE ="UPDATE paises set cdpais = ? ,cdindicativo = ? ,cdmoneda = ?  , dtfechamodificacion = now() WHERE id = ? ";
    private static final String SELECT ="SELECT * FROM paises ";
    private static final String SELECTBYID = SELECT + " WHERE id = ?";
    private static final String DELETE="DELETE FROM paises WHERE id = ?";

    JdbcTemplate jdbcTemplate;

    public PaisesDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Paises> getAll() {
        return jdbcTemplate.query(SELECT, new PaisesMapper());
    }

    @Override
    public Paises getById(Long id) {
        try{
            return jdbcTemplate.queryForObject(SELECTBYID, new PaisesMapper(),id);
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public Paises insert(Paises entity) {
        jdbcTemplate.update(INSERT,entity.getCdpais(),entity.getCdindicativo(),entity.getCdmoneda(),
                entity.getCdusuario(),
                entity.getCdestado()
                );

        return entity;
    }

    @Override
    public Paises update(Paises entity) {
        jdbcTemplate.update(UPDATE,
               entity.getCdpais(),entity.getCdindicativo(),entity.getCdmoneda(),entity.getId()
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
