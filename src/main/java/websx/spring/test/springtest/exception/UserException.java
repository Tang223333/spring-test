package websx.spring.test.springtest.exception;

public class UserException extends Exception{

    public UserException(String message) {
        super(message);
        System.out.println(message);
    }
}
