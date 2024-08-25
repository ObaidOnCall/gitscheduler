package ma.obayd.gitscheduler.db;

import java.lang.reflect.Method;

/**
 * 
 * 
 * check here to see how you can run a spicifc class using maven :
 * @ : https://stackoverflow.com/questions/9846046/run-main-class-of-maven-project
 */

public class ReflectionRunner {

    public static void main(String[] args) {
        try {

            if (args.length != 2) {
                System.err.println("Usage: java ReflectionRunner <className> <methodName>");
                System.exit(1);
            }
    
            String className = args[0];
            String methodName = args[1];

            // Load the class
            Class<?> clazz = Class.forName(className);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            // Find the method
            Method method = clazz.getMethod(methodName);

            /**
             * 
             *@  Invoke the method (Invoking a method means calling or executing it)
             * 
             */
            method.invoke(instance);

            /**
             * Exit with a success code
             */

            // System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            /**
             * Exit with an error code if an exception occurs
             */
            System.exit(1);
        }
    }

}
