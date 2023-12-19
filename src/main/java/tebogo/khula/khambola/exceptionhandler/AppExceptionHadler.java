package tebogo.khula.khambola.exceptionhandler;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;


@RestControllerAdvice
public class AppExceptionHadler {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ResponseEntity<Object>  handleMethodArgumentTypeMismatchExceptio(
                                            HttpRequestMethodNotSupportedException ex) {
        String message = ex.getMessage();
        return new ResponseEntity<>(message, HttpStatus.METHOD_NOT_ALLOWED);
    }

    
    @ExceptionHandler(MissingServletRequestPartException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object>  handleMethodArgumentTypeMismatchExceptiop(
                                            MissingServletRequestPartException ex) {
        String message = "Invalid path variable.";
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }


    @ResponseStatus(HttpStatus.PAYLOAD_TOO_LARGE)
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<Object> handleUnreadableArgument(
                                            MaxUploadSizeExceededException err){

        String error =  err.getRootCause().getMessage();
        return new ResponseEntity<>(error, HttpStatus.PAYLOAD_TOO_LARGE);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument( 
                                            MethodArgumentNotValidException err){

        Map<String, String> errorMap = new HashMap<>();
        err.getBindingResult().getFieldErrors().forEach( error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap;
    }
    

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleUnreadableArgument(
                                            HttpMessageNotReadableException err){

        String error =  "Malformed payload.";
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleElementNotFound(
                                            NoSuchElementException err){

        String error =  err.getMessage();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(MultipartException.class)
    public ResponseEntity<Object> handleUnsupporteMediaType(
                                            MultipartException err){

        String error =  err.getMessage();
        return new ResponseEntity<>(error, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handleNullPointer(
                                            NullPointerException err){

        String error =  err.getMessage();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
