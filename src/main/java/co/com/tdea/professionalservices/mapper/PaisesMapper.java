package co.com.tdea.professionalservices.mapper;

import co.com.tdea.professionalservices.dto.Paises;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaisesMapper implements RowMapper<Paises> {

    @Override
    public Paises mapRow(ResultSet resultSet, int i) throws SQLException {
        Paises entity = new Paises();
		entity.setId( resultSet.getLong("id"));
        entity.setDataFromRs(resultSet);
        return entity;
    }
}