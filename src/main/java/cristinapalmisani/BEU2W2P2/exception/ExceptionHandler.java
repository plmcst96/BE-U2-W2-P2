package cristinapalmisani.BEU2W2P2.exception;

import cristinapalmisani.BEU2W2P2.payloads.exception.ErrorPayloadWhithListDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class ExceptionHandler {

   /* @org.springframework.web.bind.annotation.ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorPayloadWhithListDTO handeBadRequest(BadRequestException ex){
        List<String> errorsMessage = new ArrayList<>();
        if ()
    }*/
}
