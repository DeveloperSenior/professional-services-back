package co.com.tdea.professionalservices.util;
/**
 * @author andreslo
 */
public class Constant {

    public enum DataBaseDialect{
        MYSQL,ORACLE,POSTGRESQL,SQLSERVER,H2;
    }

    public static final String CONF_S = "S";
    public static final String CONF_N = "N";
    public static final String PACKAGE = "PACKAGE";
    public static final String DEFAULT_ROLE = "ROLE.DEFAULT";
    public static final String HEADER_CONTENT_DIPOSITION = "Content-Disposition";
    public static final String HEADER_CONTROL_HEADERS = "access-control-request-headers";
    public static final String HEADER_TOKEN = "Authorization";
    public static final String HEADER_TOKEN_PREFIX = "Bearer ";
    public static final String MEDIA_OCTET_STREAM = "application/octet-stream";
    public static final String MEDIA_JSON = "application/json";
    public static final String CHARACTER_ENCODING = "UTF-8";
    public static final String SEPARATOR = ".";
    public static final String RAGNAROK_SURA = "iss";
    public static final String CONF_ID = "ID.LOGIN";
    public static final String CONF_KEY = "KEY.LOGIN";
    public static final String EXPIRATION = "SESSION.TIMEOUT";
    public static final String SUBJECT = "SESSION.SUBJECT";
    public static final String ACTIVATE_SESSION_EXPIRED = "SESSION.ACTIVATE.EXPIRED";
    public static final String ACTIVATE_AUTH = "SESSION.ACTIVATE.AUTH";
    public static final String DDMMYYYY = "dd-MM-yyyy";
    public static final String YYYYMMDD = "yyyy/MM/dd";
    public static final String TIME_ZONE = "America/Panama";
    public static final String YYYYMMDD_TIME_ZONE = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";


    public static final String LOGGER_NAME = "fileService";

    public static final String APP_URL_AUTH = "URL_AUTH";
    public static final String APP_USER_AUTH = "USER_AUTH";
    public static final String APP_PASS_AUTH = "PASS_AUTH";
    public static final String APP_URL_FIND_POLICY = "URL_FIND_POLICY";
    public static final String APP_URL_FIND_POLICY_v2 = "URL_FIND_POLICY_V2";
    public static final String APP_URL_FIND_BALANCE = "APP_URL_FIND_BALANCE";

    public static final String APP_URL_FLAG_NOTIFY_POLICY_CORE = "APP_URL_FLAG_NOTIFY_POLICY_CORE";

    /** Constant <code>SPRING_PROFILE_DEVELOPMENT="dev"</code> */
    public static final String SPRING_PROFILE_DEVELOPMENT = "dev";
    /** Constant <code>SPRING_PROFILE_TEST="test"</code> */
    public static final String SPRING_PROFILE_TEST = "test";
    /** Constant <code>SPRING_PROFILE_PRODUCTION="prod"</code> */
    public static final String SPRING_PROFILE_PRODUCTION = "prod";
    /** Spring profile used when deploying with Spring Cloud (used when deploying to CloudFoundry)
     Constant <code>SPRING_PROFILE_CLOUD="cloud"</code> */
    public static final String SPRING_PROFILE_CLOUD = "cloud";
    /** Spring profile used when deploying to Heroku
     Constant <code>SPRING_PROFILE_HEROKU="heroku"</code> */
    public static final  String SPRING_PROFILE_HEROKU = "heroku";
    /** Spring profile used when deploying to Amazon ECS
     Constant <code>SPRING_PROFILE_AWS_ECS="aws-ecs"</code> */
    public static final String SPRING_PROFILE_AWS_ECS = "aws-ecs";
    /** Spring profile used when deploying to Microsoft Azure
     Constant <code>SPRING_PROFILE_AZURE="azure"</code> */
    public static final String SPRING_PROFILE_AZURE = "azure";
    /** Spring profile used to enable swagger
     Constant <code>SPRING_PROFILE_SWAGGER="swagger"</code> */
    public static final String SPRING_PROFILE_SWAGGER = "swagger";
    /** Spring profile used to disable running liquibase
     Constant <code>SPRING_PROFILE_NO_LIQUIBASE="no-liquibase"</code> */
    public static final String SPRING_PROFILE_NO_LIQUIBASE = "no-liquibase";
    /** Spring profile used when deploying to Kubernetes and OpenShift
     Constant <code>SPRING_PROFILE_K8S="k8s"</code> */
    public static final String SPRING_PROFILE_K8S = "k8s";

}
