package fi.gamb77.jwtdemo.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MonsterNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(
            MonsterNotFoundException ex) {

        List<String> details = new ArrayList<String>();
        details.add(ex.getMessage());
        ApiError err = new ApiError(
                LocalDateTime.now(),
                "Monster Not Found" ,
                details);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
