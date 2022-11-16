package co.com.tdea.professionalservices.dao;

import co.com.tdea.professionalservices.dto.Usuarios;
import co.com.tdea.professionalservices.mapper.UsuariosMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.sql.DataSource;
import java.util.List;


@Repository
public class UsuariosDAOImpl implements UsuariosDAO  {

  private static final String INSERT ="INSERT INTO usuarios (cddocumento,cdtipo_documento,dsprimer_nombre,dssegundo_nombre,dsprimer_apellido,dssegundo_apellido,dsemail,nmcelular,fenacimiento,dsfacebook,dsinstagram,dswhatsapp,dsyoutube,dsotra_redsocial,dsusername,dspassword,feultimo_ingreso, cdusuario, cdestado, dtfechacreacion) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ? ,?, now())";
    private static final String UPDATE ="UPDATE usuarios set cdtipo_documento = ? ,dsprimer_nombre = ? ,dssegundo_nombre = ? ,dsprimer_apellido = ? ,dssegundo_apellido = ? ,dsdemail = ? ,nmcelular = ? ,fenacimiento = ? ,dsfacebook = ? ,dsinstagram = ? ,dswhatsapp = ? ,dsyoutube = ? ,dsotra_redsocial = ? ,dsusername = ? ,dspassword = ? ,feultimo_ingreso = ?  , dtfechamodificacion = now() WHERE cddocumento = ? ";
    private static final String SELECT ="SELECT * FROM usuarios ";
    private static final String SELECTBYID = SELECT + " WHERE cddocumento = ?";
    private static final String SELECTBYEMAIL = SELECT + " WHERE dsemail = ?";

    private static final String DELETE="DELETE FROM usuarios WHERE cddocumento = ?";

    JdbcTemplate jdbcTemplate;

    public UsuariosDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Usuarios> getAll() {
        return jdbcTemplate.query(SELECT, new UsuariosMapper());
    }

    @Override
    public Usuarios getById(String id) {
        try{
            return jdbcTemplate.queryForObject(SELECTBYID, new UsuariosMapper(),id);
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public Usuarios getByEmail(String email) {
        try{
            return jdbcTemplate.queryForObject(SELECTBYEMAIL, new UsuariosMapper(),email);
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public Usuarios insert(Usuarios entity) {
        jdbcTemplate.update(INSERT,
                entity.getCddocumento(),entity.getCdtipo_documento(),entity.getDsprimer_nombre(),entity.getDssegundo_nombre(),entity.getDsprimer_apellido(),entity.getDssegundo_apellido(),entity.getDsemail(),entity.getNmcelular(),entity.getFenacimiento(),entity.getDsfacebook(),entity.getDsinstagram(),entity.getDswhatsapp(),entity.getDsyoutube(),entity.getDsotra_redsocial(),entity.getDsusername(),entity.getDspassword(),entity.getFeultimo_ingreso(),
                entity.getCdusuario(),
                entity.getCdestado()
                );

        return entity;
    }

    @Override
    public Usuarios update(Usuarios entity) {
        jdbcTemplate.update(UPDATE,
               entity.getCdtipo_documento(),entity.getDsprimer_nombre(),entity.getDssegundo_nombre(),entity.getDsprimer_apellido(),entity.getDssegundo_apellido(),entity.getDsemail(),entity.getNmcelular(),entity.getFenacimiento(),entity.getDsfacebook(),entity.getDsinstagram(),entity.getDswhatsapp(),entity.getDsyoutube(),entity.getDsotra_redsocial(),entity.getDsusername(),entity.getDspassword(),entity.getFeultimo_ingreso(),entity.getCddocumento()
        );
        return entity;
    }

    @Override
    public Boolean delete(String id) {
        return jdbcTemplate.update(DELETE,
                id
        )>0;
    }


}
