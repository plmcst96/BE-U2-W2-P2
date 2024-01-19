package cristinapalmisani.BEU2W2P2.payloads.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ErrorPayloadWhithListDTO{
    String message;
    Date timestamp;
    List<String> errorlist;

}
