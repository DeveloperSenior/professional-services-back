package co.com.tdea.professionalservices.mapper;

import co.com.tdea.professionalservices.dto.Departamentos;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartamentosMapper implements RowMapper<Departamentos> {

    @Override
    public Departamentos mapRow(ResultSet resultSet, int i) throws SQLException {
        Departamentos entity = new Departamentos();
		entity.setId( resultSet.getLong("id"));		entity.setCddepartamento( resultSet.getString("cddepartamento"));		entity.setDsdepartamento( resultSet.getString("dsdepartamento"));		entity.setId_pais( resultSet.getLong("id_pais"));
        entity.setDataFromRs(resultSet);
        return entity;
    }
}
