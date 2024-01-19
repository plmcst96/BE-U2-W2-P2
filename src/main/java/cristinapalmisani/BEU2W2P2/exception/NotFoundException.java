package cristinapalmisani.BEU2W2P2.exception;

import lombok.Getter;

import java.util.UUID;

@Getter
public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
    public NotFoundException(UUID id){
        super("The items with id " + id + " it's not found!");
    }
}
