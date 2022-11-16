package co.com.tdea.professionalservices.mapper;

import co.com.tdea.professionalservices.dto.ServiciosClientes;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiciosClientesMapper implements RowMapper<ServiciosClientes> {

    @Override
    public ServiciosClientes mapRow(ResultSet resultSet, int i) throws SQLException {
        ServiciosClientes entity = new ServiciosClientes();
		entity.setIdservicio( resultSet.getLong("idservicio"));		entity.setCddocumento_cliente( resultSet.getString("cddocumento_cliente"));
        entity.setDataFromRs(resultSet);
        return entity;
    }
}
