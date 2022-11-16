package co.com.tdea.professionalservices.mapper;

import co.com.tdea.professionalservices.dto.Profesiones;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfesionesMapper implements RowMapper<Profesiones> {

    @Override
    public Profesiones mapRow(ResultSet resultSet, int i) throws SQLException {
        Profesiones entity = new Profesiones();
		entity.setId( resultSet.getLong("id"));		entity.setDsnombre( resultSet.getString("dsnombre"));
        entity.setDataFromRs(resultSet);
        return entity;
    }
}
