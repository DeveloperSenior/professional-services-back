package co.com.tdea.professionalservices.mapper;

import co.com.tdea.professionalservices.dto.Ciudades;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CiudadesMapper implements RowMapper<Ciudades> {

    @Override
    public Ciudades mapRow(ResultSet resultSet, int i) throws SQLException {
        Ciudades entity = new Ciudades();
		entity.setId( resultSet.getLong("id"));
        entity.setDataFromRs(resultSet);
        return entity;
    }
}