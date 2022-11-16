package co.com.tdea.professionalservices.mapper;

import co.com.tdea.professionalservices.dto.ProfesionesUsuarios;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfesionesUsuariosMapper implements RowMapper<ProfesionesUsuarios> {

    @Override
    public ProfesionesUsuarios mapRow(ResultSet resultSet, int i) throws SQLException {
        ProfesionesUsuarios entity = new ProfesionesUsuarios();
		entity.setId_profesion( resultSet.getLong("id_profesion"));		entity.setCddocumento( resultSet.getString("cddocumento"));
        entity.setDataFromRs(resultSet);
        return entity;
    }
}
