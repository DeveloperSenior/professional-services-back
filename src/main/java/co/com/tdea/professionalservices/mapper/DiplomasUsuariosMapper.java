package co.com.tdea.professionalservices.mapper;

import co.com.tdea.professionalservices.dto.DiplomasUsuarios;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DiplomasUsuariosMapper implements RowMapper<DiplomasUsuarios> {

    @Override
    public DiplomasUsuarios mapRow(ResultSet resultSet, int i) throws SQLException {
        DiplomasUsuarios entity = new DiplomasUsuarios();
		entity.setId( resultSet.getLong("id"));
        entity.setDataFromRs(resultSet);
        return entity;
    }
}