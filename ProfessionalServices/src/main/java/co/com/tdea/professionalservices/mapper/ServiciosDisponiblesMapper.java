package co.com.tdea.professionalservices.mapper;

import co.com.tdea.professionalservices.dto.ServiciosDisponibles;
import co.com.tdea.professionalservices.dto.Usuarios;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiciosDisponiblesMapper implements RowMapper<ServiciosDisponibles> {

    @Override
    public ServiciosDisponibles mapRow(ResultSet resultSet, int i) throws SQLException {
        ServiciosDisponibles entity = new ServiciosDisponibles();
		entity.setId( resultSet.getLong("id"));
		Usuarios usuario = new Usuarios();
		usuario.setCddocumento( resultSet.getString("cddocumento"));
		entity.setUsuario(usuario);
		entity.setId_profesion( resultSet.getLong("id_profesion"));
		entity.setIdciudad( resultSet.getLong("idciudad"));
		entity.setDsDescripcion( resultSet.getString("dsdescripcion"));
		entity.setFedisponible_inicio( resultSet.getTimestamp("fedisponible_inicio").toLocalDateTime());
		entity.setFedisponible_fin( resultSet.getTimestamp("fedisponible_fin").toLocalDateTime());
		entity.setNmvalor_inicio( resultSet.getDouble("nmvalor_inicio"));
		entity.setNmvalor_fin( resultSet.getDouble("nmvalor_fin"));
		entity.setSndisponible( resultSet.getString("sndisponible"));

        entity.setDataFromRs(resultSet);
        return entity;
    }
}
