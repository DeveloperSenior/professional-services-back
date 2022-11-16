package co.com.tdea.professionalservices.mapper;

import co.com.tdea.professionalservices.dto.Usuarios;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuariosMapper implements RowMapper<Usuarios> {

    @Override
    public Usuarios mapRow(ResultSet resultSet, int i) throws SQLException {
        Usuarios entity = new Usuarios();
		entity.setCddocumento( resultSet.getString("cddocumento"));
		entity.setCdtipo_documento( resultSet.getString("cdtipo_documento"));
		entity.setDsprimer_nombre( resultSet.getString("dsprimer_nombre"));
		entity.setDssegundo_nombre( resultSet.getString("dssegundo_nombre"));
		entity.setDsprimer_apellido( resultSet.getString("dsprimer_apellido"));
		entity.setDssegundo_apellido( resultSet.getString("dssegundo_apellido"));
		entity.setDsemail( resultSet.getString("dsemail"));
		entity.setNmcelular( resultSet.getString("nmcelular"));
		entity.setFenacimiento( resultSet.getTimestamp("fenacimiento").toLocalDateTime());
		entity.setDsfacebook( resultSet.getString("dsfacebook"));
		entity.setDsinstagram( resultSet.getString("dsinstagram"));
		entity.setDswhatsapp( resultSet.getString("dswhatsapp"));
		entity.setDsyoutube( resultSet.getString("dsyoutube"));
		entity.setDsotra_redsocial( resultSet.getString("dsotra_redsocial"));
		entity.setDsusername( resultSet.getString("dsusername"));
		entity.setDspassword( resultSet.getString("dspassword"));
		entity.setFeultimo_ingreso( resultSet.getTimestamp("feultimo_ingreso").toLocalDateTime());

        entity.setDataFromRs(resultSet);
        return entity;
    }
}
