package co.com.tdea.professionalservices.mapper;

import co.com.tdea.professionalservices.dto.CiudadesUsuarios;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CiudadesUsuariosMapper implements RowMapper<CiudadesUsuarios> {

    @Override
    public CiudadesUsuarios mapRow(ResultSet resultSet, int i) throws SQLException {
        CiudadesUsuarios entity = new CiudadesUsuarios();
		entity.setIdciudad( resultSet.getLong("idciudad"));		entity.setCddocumento( resultSet.getString("cddocumento"));		entity.setSnpreferencia( resultSet.getString("snpreferencia"));
        entity.setDataFromRs(resultSet);
        return entity;
    }
}
