package tebogo.khula.khambola.ExceptionHadler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class AppExceptionHadler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument( MethodArgumentNotValidException err){
        Map<String, String> errorMap = new HashMap<>();
        err.getBindingResult().getFieldErrors().forEach( error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> HandleUnreadableArgument(
                                                            HttpMessageNotReadableException err,
                                                            WebRequest request){
        String error =  "Malformed payload!! " + err.getMessage();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
