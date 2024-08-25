package ma.obayd.gitscheduler.db;

// import ma.obayd.gitscheduler.db.FlywayConf;

public class FlywayRun {


    public static void migrate () {

        FlywayConf.flyway().migrate() ;
    }
    


    

}
