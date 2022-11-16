package co.com.tdea.professionalservices.util;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.sql.Timestamp;

public class Auditoria {
    private String cdestado;
    private String cdusuario;
    private LocalDateTime dtfechacreacion;
    private LocalDateTime dtfechamodificacion;

    public String getCdestado() {
        return cdestado;
    }

    public void setCdestado(String cdestado) {
        this.cdestado = cdestado;
    }

    public String getCdusuario() {
        return cdusuario;
    }

    public void setCdusuario(String cdusuario) {
        this.cdusuario = cdusuario;
    }

    public LocalDateTime getDtfechacreacion() {
        return dtfechacreacion;
    }

    public void setDtfechacreacion(LocalDateTime dtfechacreacion) {
        this.dtfechacreacion = dtfechacreacion;
    }

    public LocalDateTime getDtfechamodificacion() {
        return dtfechamodificacion;
    }

    public void setDtfechamodificacion(LocalDateTime dtfechamodificacion) {
        this.dtfechamodificacion = dtfechamodificacion;
    }

    @JsonIgnore
    public void setDataFromRs(ResultSet rs) throws SQLException {
        cdestado = rs.getString("cdestado");
        cdusuario = rs.getString("cdusuario");
        dtfechacreacion =getLocalDateTime (rs.getTimestamp("dtfechacreacion"));
        dtfechamodificacion=getLocalDateTime (rs.getTimestamp("dtfechamodificacion"));
    }

    public LocalDateTime getLocalDateTime(Timestamp tmp){
        if(tmp == null){
            return null;
        }
        return tmp.toLocalDateTime();
    }
}
