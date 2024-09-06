package ma.obayd.gitscheduler.confbeans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ma.obayd.gitscheduler.utils.PropertiesLoader;

import java.util.Properties;

import javax.sql.DataSource;


@Configuration
public class QuartzDBConf {

    private final PropertiesLoader propertiesLoader ;

    public QuartzDBConf (@Qualifier("propertiesLoader1") PropertiesLoader propertiesLoader){
        this.propertiesLoader = propertiesLoader;
    }

    @Bean(name = "quartzDataSource")
    @QuartzDataSource
    public DataSource quartzDataSource() {
        Properties properties = propertiesLoader.loadProperties("src/main/resources/quartz.properties") ;
        return DataSourceBuilder.create()
            .url(properties.getProperty("org.quartz.dataSource.quartzDataSource.URL"))
            .username(properties.getProperty("org.quartz.dataSource.quartzDataSource.user"))
            .password(properties.getProperty("org.quartz.dataSource.quartzDataSource.password"))
            .driverClassName(properties.getProperty("org.quartz.dataSource.quartzDataSource.driver"))
            .build();
    }
}
