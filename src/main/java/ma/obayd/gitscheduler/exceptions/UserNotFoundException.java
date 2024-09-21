package ma.obayd.gitscheduler.exceptions;

import lombok.Setter;


public class UserNotFoundException  extends Exception{

    public UserNotFoundException (String message) {
        super(message) ;
    }   

}
