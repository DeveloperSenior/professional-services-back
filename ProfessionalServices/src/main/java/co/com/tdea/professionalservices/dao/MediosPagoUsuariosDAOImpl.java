package co.com.tdea.professionalservices.dao;

import co.com.tdea.professionalservices.dto.MediosPagoUsuarios;
import co.com.tdea.professionalservices.mapper.MediosPagoUsuariosMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.sql.DataSource;
import java.util.List;


import org.springframework.stereotype.Repository;


@Repository
public class MediosPagoUsuariosDAOImpl implements MediosPagoUsuariosDAO  {

  private static final String INSERT ="INSERT INTO medios_pago_usuarios (idmedio_pago,cddocumento,snactivo, cdusuario, cdestado, dtfechacreacion) VALUES(?,?,?, ? ,?, now())";
    private static final String UPDATE ="UPDATE medios_pago_usuarios set snactivo = ?  , dtfechamodificacion = now() WHERE idmedio_pago = ? ";
    private static final String SELECT ="SELECT * FROM medios_pago_usuarios ";
    private static final String SELECTBYID = SELECT + " WHERE idmedio_pago = ?";
    private static final String DELETE="DELETE FROM medios_pago_usuarios WHERE idmedio_pago = ?";

    JdbcTemplate jdbcTemplate;

    public MediosPagoUsuariosDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<MediosPagoUsuarios> getAll() {
        return jdbcTemplate.query(SELECT, new MediosPagoUsuariosMapper());
    }

    @Override
    public MediosPagoUsuarios getById(Long id) {
        try{
            return jdbcTemplate.queryForObject(SELECTBYID, new MediosPagoUsuariosMapper(),id);
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public MediosPagoUsuarios insert(MediosPagoUsuarios entity) {
        jdbcTemplate.update(INSERT,
                entity.getIdmedio_pago(),entity.getCddocumento(),entity.getSnactivo(),
                entity.getCdusuario(),
                entity.getCdestado()
                );

        return entity;
    }

    @Override
    public MediosPagoUsuarios update(MediosPagoUsuarios entity) {
        jdbcTemplate.update(UPDATE,
               entity.getSnactivo(),entity.getIdmedio_pago()
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
