package co.com.tdea.professionalservices.controller.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.cors.CorsConfiguration;

/**
 * @author andreslo
 */
@CrossOrigin(origins = CorsConfiguration.ALL, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.OPTIONS,RequestMethod.PATCH})
public class ResponseBase {
    public static final Logger logger = LogManager.getLogger(ResponseBase.class);

}
