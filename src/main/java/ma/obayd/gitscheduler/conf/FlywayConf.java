package ma.obayd.gitscheduler.conf;
// package ma.obayd.gitscheduler.db;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import com.mchange.v2.c3p0.DataSources;

// import org.flywaydb.core.Flyway;
// // import org.flywaydb.core.api.configuration.FluentConfiguration;
// import org.springframework.boot.jdbc.DataSourceBuilder;

// import java.io.FileInputStream;
// import java.io.InputStream;
// import java.util.Properties;

// import javax.sql.DataSource;


// public class FlywayConf {
    
//     private FlywayConf() {
//         throw new IllegalStateException("Utility class");
//     }
//     private static Properties loadProperties() throws Exception {
//         String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//         String appConfigPath = "src/main/resources/application.properties";
//         // String catalogConfigPath = rootPath + "catalog";

//         Properties appProps = new Properties();
//         appProps.load(new FileInputStream(appConfigPath));

//         // Properties catalogProps = new Properties();
//         // catalogProps.load(new FileInputStream(catalogConfigPath));

//         return  appProps ;
//     }

//     /**
//      * config the flyway
//      * @return
//      * @throws Exception 
//      */
//     public static Flyway flyway() throws Exception {
//         Properties properties = loadProperties();
//         DataSource dataSource = DataSourceBuilder.create()
//                                 .url(properties.getProperty("spring.datasource.url"))
//                                 .username(properties.getProperty("spring.datasource.username"))
//                                 .password(properties.getProperty("spring.datasource.password"))
//                                 .driverClassName(properties.getProperty("spring.datasource.driver-class-name"))
//                                 .type(DataSource)
//                                 .build();
//         return new Flyway(Flyway.configure().dataSource(dataSource).locations("classpath:db/migrations").baselineOnMigrate(true)) ;
//     }
// }
