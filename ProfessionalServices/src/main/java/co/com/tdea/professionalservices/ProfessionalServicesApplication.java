package co.com.tdea.professionalservices;


import co.com.tdea.professionalservices.util.Constant;
import co.com.tdea.professionalservices.util.DefaultProfileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;

@SpringBootApplication
@EnableTransactionManagement
@ServletComponentScan
public class ProfessionalServicesApplication {
	private static final Logger log = LoggerFactory.getLogger(ProfessionalServicesApplication.class);

	private final Environment env;

	public ProfessionalServicesApplication(Environment env) {
		this.env = env;
	}

	static {
		/* se define esta propiedad para crear archivos tipo imagenes en servidores no graficos (Linux, UNIX)*/
		System.setProperty("java.awt.headless", "true");
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ProfessionalServicesApplication.class);
		DefaultProfileUtil.addDefaultProfile(app);
		Environment env = app.run(args).getEnvironment();
		logApplicationStartup(env);
	}

	private static void logApplicationStartup(Environment env) {
		String protocol = "http";
		String swaggerUi = "swagger-ui";
		if (env.getProperty("server.ssl.key-store") != null) {
			protocol = "https";
		}
		String serverPort = env.getProperty("server.port");
		String contextPath = env.getProperty("server.servlet.context-path");
		if ("".equals(contextPath) || contextPath == null) {
			contextPath = "/";
		}
		String hostAddress = "localhost";
		try {
			hostAddress = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			log.warn("The host name could not be determined, using `localhost` as fallback");
		}
		log.info("\n----------------------------------------------------------\n\t" +
						"Application '{}' is running! Access URLs:\n\t" +
						"Local: \t\t{}://localhost:{}{}\n\t" +
						"External: \t{}://{}:{}{}\n\t" +
						"Profile(s): \t{}\n\t"+
						"Swagger Local: {}://localhost:{}{}{}/\n\t" +
						"Swagger External: {}://{}:{}{}{}/\n\t" +
						"\n----------------------------------------------------------",
				env.getProperty("spring.application.name"),
				protocol,
				serverPort,
				contextPath,
				protocol,
				hostAddress,
				serverPort,
				contextPath,
				env.getActiveProfiles(),
				protocol,
				serverPort,
				contextPath,
				swaggerUi,
				protocol,
				hostAddress,
				serverPort,
				contextPath,
				swaggerUi);
	}


	/**
	 * Initializes ProfessionalServicesApplication.
	 * <p>
	 * Spring profiles can be configured with a program argument --spring.profiles.active=your-active-profile
	 * <p>
	 */
	@PostConstruct
	public void initApplication() {
		Collection<String> activeProfiles = Arrays.asList(env.getActiveProfiles());
		if (activeProfiles.contains(Constant.SPRING_PROFILE_DEVELOPMENT) && activeProfiles.contains(Constant.SPRING_PROFILE_PRODUCTION)) {
			log.error("You have misconfigured your application! It should not run " +
					"with both the 'dev' and 'prod' profiles at the same time.");
		}
		if (activeProfiles.contains(Constant.SPRING_PROFILE_DEVELOPMENT) && activeProfiles.contains(Constant.SPRING_PROFILE_CLOUD)) {
			log.error("You have misconfigured your application! It should not " +
					"run with both the 'dev' and 'cloud' profiles at the same time.");
		}
	}

}
