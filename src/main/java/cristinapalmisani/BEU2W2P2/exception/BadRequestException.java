package cristinapalmisani.BEU2W2P2.exception;

import org.springframework.validation.ObjectError;

import java.util.List;

public class BadRequestException extends RuntimeException{
    private List<ObjectError> errorlist;

    public BadRequestException(String message){
        super(message);
    }

    public BadRequestException(List<ObjectError> errors){
        super("Errors paylod");
        this.errorlist = errors;
    }
}
