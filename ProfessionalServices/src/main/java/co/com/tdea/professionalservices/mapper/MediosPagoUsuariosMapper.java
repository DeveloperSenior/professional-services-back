package co.com.tdea.professionalservices.mapper;

import co.com.tdea.professionalservices.dto.MediosPagoUsuarios;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MediosPagoUsuariosMapper implements RowMapper<MediosPagoUsuarios> {

    @Override
    public MediosPagoUsuarios mapRow(ResultSet resultSet, int i) throws SQLException {
        MediosPagoUsuarios entity = new MediosPagoUsuarios();
		entity.setIdmedio_pago( resultSet.getLong("idmedio_pago"));		entity.setCddocumento( resultSet.getString("cddocumento"));		entity.setSnactivo( resultSet.getString("snactivo"));
        entity.setDataFromRs(resultSet);
        return entity;
    }
}
