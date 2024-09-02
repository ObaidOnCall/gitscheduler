package ma.obayd.gitscheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GitschedulerApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(GitschedulerApplication.class, args);
		

	}

	// @Bean
    // public CommandLineRunner migrateDatabase() {
    //     return args -> {
    //         flyway.migrate();
    //         System.out.println("Database migration completed successfully.");
    //     };
    // }

}
