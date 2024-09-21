package ma.obayd.gitscheduler.utils;

import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Hash {

    private Hash () {}

    private static final int SALT_LENGTH = 16; // Salt length in bytes
    private static final int ITERATIONS = 20536; //The number of iterations (, 65,536) directly impacts the time taken to hash the password. This is intentional to make brute-force attacks harder. 
    private static final int KEY_LENGTH = 512; // Key length in bits

    
    private static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        try {
            random.nextBytes(salt);
        } catch (Exception e) {
            throw new IllegalArgumentException("Can not generate a Slat") ;
        }
        return salt;
    }


    public static String hashPassword(String password) {
        String hashBase64 = "";

        try {
            byte[] salt = Hash.generateSalt(); // Generate salt
            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = factory.generateSecret(spec).getEncoded(); // Hash the password

            // Encode the hash and salt to Base64
            hashBase64 = Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            throw new ExceptionInInitializerError("Can not Init Password there is somthing warng with Hash class .") ;
        }
        


        return hashBase64;
    }
}
