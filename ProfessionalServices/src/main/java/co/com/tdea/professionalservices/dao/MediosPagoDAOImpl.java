package co.com.tdea.professionalservices.dao;

import co.com.tdea.professionalservices.dto.MediosPago;
import co.com.tdea.professionalservices.mapper.MediosPagoMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.sql.DataSource;
import java.util.List;


import org.springframework.stereotype.Repository;


@Repository
public class MediosPagoDAOImpl implements MediosPagoDAO  {

  private static final String INSERT ="INSERT INTO medios_pago (cdmedio_pago,dsmedio_pago, cdusuario, cdestado, dtfechacreacion) VALUES(?,?, ? ,?, now())";
    private static final String UPDATE ="UPDATE medios_pago set cdmedio_pago = ? ,dsmedio_pago = ?  , dtfechamodificacion = now() WHERE id = ? ";
    private static final String SELECT ="SELECT * FROM medios_pago ";
    private static final String SELECTBYID = SELECT + " WHERE id = ?";
    private static final String DELETE="DELETE FROM medios_pago WHERE id = ?";

    JdbcTemplate jdbcTemplate;

    public MediosPagoDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<MediosPago> getAll() {
        return jdbcTemplate.query(SELECT, new MediosPagoMapper());
    }

    @Override
    public MediosPago getById(Long id) {
        try{
            return jdbcTemplate.queryForObject(SELECTBYID, new MediosPagoMapper(),id);
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public MediosPago insert(MediosPago entity) {
        jdbcTemplate.update(INSERT,entity.getCdmedio_pago(),entity.getDsmedio_pago(),
                entity.getCdusuario(),
                entity.getCdestado()
                );

        return entity;
    }

    @Override
    public MediosPago update(MediosPago entity) {
        jdbcTemplate.update(UPDATE,
               entity.getCdmedio_pago(),entity.getDsmedio_pago(),entity.getId()
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
