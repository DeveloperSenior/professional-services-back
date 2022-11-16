package co.com.tdea.professionalservices.dao;

import co.com.tdea.professionalservices.dto.AvailableServicesPager;
import co.com.tdea.professionalservices.dto.ServiciosDisponibles;
import co.com.tdea.professionalservices.dto.Usuarios;
import co.com.tdea.professionalservices.mapper.ServiciosDisponiblesMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Types;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Repository
public class ServiciosDisponiblesDAOImpl implements ServiciosDisponiblesDAO  {

    public static final String IN_DSPROFESION  = "IN_DSPROFESION"   ;
    public static final String IN_DSNOMBRE     = "IN_DSNOMBRE"      ;
    public static final String IN_DSUBICACION  = "IN_DSUBICACION"   ;
    public static final String IN_NMRATING     = "IN_NMRATING"      ;
    public static final String IN_NMVALOR_INICIO = "IN_NMVALOR_INICIO";
    public static final String IN_NMVALOR_FIN  = "IN_NMVALOR_FIN"   ;
    public static final String IN_NI_NMOFFSET  = "IN_NI_NMOFFSET"   ;
    public static final String IN_NI_NMPAGESIZE = "IN_NI_NMPAGESIZE"  ;
    private static final String OUT_NO_TOTAL = "NO_TOTAL";
    private static final String OUT_CURO_DATOS = "OUT_CURO_DATOS";
  
  private static final String INSERT ="INSERT INTO servicios_disponibles (cddocumento,id_profesion,idciudad,dsdescripcion,fedisponible_inicio,fedisponible_fin,nmvalor_inicio,nmvalor_fin,sndisponible, cdusuario, cdestado, dtfechacreacion) VALUES(?,?,?,?,?,?,?,?,?, ? ,?, now())";
    private static final String UPDATE ="UPDATE servicios_disponibles set dsdescripcion = ? ,fedisponible_inicio = ? ,fedisponible_fin = ? ,nmvalor_inicio = ? ,nmvalor_fin = ? ,sndisponible = ?  , dtfechamodificacion = now() WHERE id = ? ";
    private static final String SELECT ="SELECT T.* " +
            "FROM (SELECT * " +
            "      FROM SERVICIOS_DISPONIBLES " +
            "      ORDER BY 1 OFFSET ? ROWS " +
            "      FETCH NEXT ? ROWS ONLY) T";
    private static final String SELECT_COUNT ="SELECT COUNT(1) TOTAL FROM SERVICIOS_DISPONIBLES";
    private static final String SELECTBYID = SELECT + " WHERE id = ?";
    private static final String DELETE="DELETE FROM servicios_disponibles WHERE id = ?";

    JdbcTemplate jdbcTemplate;

    SimpleJdbcCall call;

    public ServiciosDisponiblesDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public AvailableServicesPager getAll(AvailableServicesPager pager) {
        AvailableServicesPager page = new AvailableServicesPager();
        ServiciosDisponibles filter = pager.getFilter();

        SqlParameterSource inParams = new MapSqlParameterSource()
                .addValue(IN_DSPROFESION, filter.getDsProfesion())
                .addValue(IN_DSNOMBRE, filter.getDsDescripcion())
                .addValue(IN_DSUBICACION, filter.getDsCiudad())
                .addValue(IN_NMRATING, filter.getNmRating())
                .addValue(IN_NMVALOR_INICIO, filter.getNmvalor_inicio())
                .addValue(IN_NMVALOR_FIN, filter.getNmvalor_fin())
                .addValue(IN_NI_NMOFFSET,pager.getOffset())
                .addValue(IN_NI_NMPAGESIZE,pager.getSize());
        this.call = new SimpleJdbcCall(this.jdbcTemplate);
        this.call.withFunctionName("fn_get_available_services")
                .withoutProcedureColumnMetaDataAccess()
                .useInParameterNames(Objects.requireNonNull(inParams.getParameterNames()))
                .declareParameters(
                                  new SqlParameter(IN_DSPROFESION, Types.VARCHAR),
                                  new SqlParameter(IN_DSNOMBRE, Types.VARCHAR),
                                  new SqlParameter(IN_DSUBICACION, Types.VARCHAR),
                                  new SqlParameter(IN_NMRATING, Types.NUMERIC),
                                  new SqlParameter(IN_NMVALOR_INICIO, Types.NUMERIC),
                                  new SqlParameter(IN_NMVALOR_FIN, Types.NUMERIC),
                                  new SqlParameter(IN_NI_NMOFFSET, Types.NUMERIC),
                                  new SqlParameter(IN_NI_NMPAGESIZE, Types.NUMERIC),
                                  new SqlOutParameter(OUT_NO_TOTAL, Types.NUMERIC),
                                  new SqlOutParameter(OUT_CURO_DATOS, Types.REF_CURSOR,(RowMapper<ServiciosDisponibles>) (resultSet, rowNum) -> {

                                      ServiciosDisponibles entity = new ServiciosDisponibles();
                                      Usuarios usuario = new Usuarios();
                                      usuario.setCddocumento(resultSet.getString("CDDOCUMENTO_PROFESIONAL"));
                                      usuario.setDsprimer_nombre(resultSet.getString("DSPRIMER_NOMBRE"));
                                      usuario.setDsprimer_apellido(resultSet.getString("DSPRIMER_APELLIDO"));
                                      usuario.setDssegundo_nombre(resultSet.getString("DSSEGUNDO_NOMBRE"));
                                      usuario.setDssegundo_apellido(resultSet.getString("DSSEGUNDO_APELLIDO"));
                                      entity.setUsuario(usuario);
                                      entity.setId_profesion( resultSet.getLong("ID_PROFESION"));
                                      entity.setDsProfesion(resultSet.getString("DSPROFESION"));
                                      entity.setNmRating(resultSet.getInt("NMRATING"));
                                      entity.setDsCiudad(resultSet.getString("DSCIUDAD"));
                                      return entity;
                                  }) ).compile();


        Map<String, Object> results;
        results = this.call.execute(inParams);
        page.setAvailableServices((List<ServiciosDisponibles>) results.get(OUT_CURO_DATOS));
        page.setTotal(((BigDecimal)results.get(OUT_NO_TOTAL)).longValue());
        return page;

    }

    @Override
    public ServiciosDisponibles getById(Long id) {
        try{
            return jdbcTemplate.queryForObject(SELECTBYID, new ServiciosDisponiblesMapper(),id);
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public ServiciosDisponibles insert(ServiciosDisponibles entity) {
        jdbcTemplate.update(INSERT,entity.getUsuario().getCddocumento(),entity.getId_profesion(),entity.getIdciudad(),entity.getDsDescripcion(),entity.getFedisponible_inicio(),entity.getFedisponible_fin(),entity.getNmvalor_inicio(),entity.getNmvalor_fin(),entity.getSndisponible(),
                entity.getCdusuario(),
                entity.getCdestado()
                );

        return entity;
    }

    @Override
    public ServiciosDisponibles update(ServiciosDisponibles entity) {
        jdbcTemplate.update(UPDATE,
               entity.getDsDescripcion(),entity.getFedisponible_inicio(),entity.getFedisponible_fin(),entity.getNmvalor_inicio(),entity.getNmvalor_fin(),entity.getSndisponible(),entity.getId()
        );
        return entity;
    }

    @Override
    public Boolean delete(Long id) {
        return jdbcTemplate.update(DELETE,
                id
        )>0;
    }


}
