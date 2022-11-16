package co.com.tdea.professionalservices.mapper;

import co.com.tdea.professionalservices.dto.MediosPago;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MediosPagoMapper implements RowMapper<MediosPago> {

    @Override
    public MediosPago mapRow(ResultSet resultSet, int i) throws SQLException {
        MediosPago entity = new MediosPago();
		entity.setId( resultSet.getLong("id"));		entity.setCdmedio_pago( resultSet.getString("cdmedio_pago"));		entity.setDsmedio_pago( resultSet.getString("dsmedio_pago"));
        entity.setDataFromRs(resultSet);
        return entity;
    }
}
