package co.com.tdea.professionalservices.mapper;

import co.com.tdea.professionalservices.dto.DiplomasUsuarios;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DiplomasUsuariosMapper implements RowMapper<DiplomasUsuarios> {

    @Override
    public DiplomasUsuarios mapRow(ResultSet resultSet, int i) throws SQLException {
        DiplomasUsuarios entity = new DiplomasUsuarios();
		entity.setId( resultSet.getLong("id"));		entity.setId_profesion( resultSet.getLong("id_profesion"));		entity.setCddocumento( resultSet.getString("cddocumento"));		entity.setDsruta_diploma( resultSet.getString("dsruta_diploma"));		entity.setCdtarjeta_profesional( resultSet.getString("cdtarjeta_profesional"));		entity.setFediploma( resultSet.getTimestamp("fediploma").toLocalDateTime());
        entity.setDataFromRs(resultSet);
        return entity;
    }
}
