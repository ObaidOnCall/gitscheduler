package ma.obayd.gitscheduler.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UtilsConf {

    @Bean("propertiesLoader1")
    public PropertiesLoader propertiesLoader() {
        return PropertiesLoader.builder().build() ;
    }
}
