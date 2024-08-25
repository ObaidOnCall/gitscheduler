package ma.obayd.gitscheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.flywaydb.core.Flyway;

@SpringBootApplication
public class GitschedulerApplication {
	
	@Autowired
	private Flyway flyway;

	// public static void migrateDatabase() {
	// 	flyway.migrate();
	// }
	public static void main(String[] args) {
		SpringApplication.run(GitschedulerApplication.class, args);
		

	}

	@Bean
    public CommandLineRunner migrateDatabase() {
        return args -> {
            flyway.migrate();
            System.out.println("Database migration completed successfully.");
        };
    }

}
