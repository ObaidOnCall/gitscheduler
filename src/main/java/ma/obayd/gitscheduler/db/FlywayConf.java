package ma.obayd.gitscheduler.db;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.flywaydb.core.Flyway;
// import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import javax.sql.DataSource;


@Configuration
public class FlywayConf {

    /**
     * config the flyway
     * @return
     */
    @Bean
    public Flyway flyway() {
        DataSource dataSource = DataSourceBuilder.create()
                                .url("jdbc:mysql://localhost:3306/gitschedulerDB")
                                .username("root")
                                .password("Hour123*/*@@")
                                .driverClassName("com.mysql.cj.jdbc.Driver")
                                .type(org.apache.tomcat.jdbc.pool.DataSource.class)
                                .build();
        // FluentConfiguration flywayConf = new FluentConfiguration();
        // flywayConf.locations("filesystem:/migrations");
        // flywayConf.dataSource(dataSource);
        // flyway.setSchemas("my_schema");
        Flyway flyway = new Flyway(Flyway.configure().dataSource(dataSource).locations("classpath:db/migrations").baselineOnMigrate(true)) ;
        return flyway;
    }
}
