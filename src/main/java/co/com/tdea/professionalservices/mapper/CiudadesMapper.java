package co.com.tdea.professionalservices.mapper;

import co.com.tdea.professionalservices.dto.Ciudades;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CiudadesMapper implements RowMapper<Ciudades> {

    @Override
    public Ciudades mapRow(ResultSet resultSet, int i) throws SQLException {
        Ciudades entity = new Ciudades();
		entity.setId( resultSet.getLong("id"));		entity.setCdciudad( resultSet.getString("cdciudad"));		entity.setCdindicativo( resultSet.getString("cdindicativo"));		entity.setDsciudad( resultSet.getString("dsciudad"));		entity.setIddepartamento( resultSet.getLong("iddepartamento"));
        entity.setDataFromRs(resultSet);
        return entity;
    }
}
