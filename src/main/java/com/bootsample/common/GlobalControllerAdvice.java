package com.bootsample.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bootsample.common.dto.ErrorEntity;

@RestControllerAdvice
public class GlobalControllerAdvice {

/*
 * 
 */
  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public ResponseEntity MethodArgumentNotValidException(MethodArgumentNotValidException e){
      ErrorEntity errorEntity = new ErrorEntity();
      errorEntity.setHttpCode(e.getStatusCode().value());
      errorEntity.setErrorType("Bad Request");
      
      StringBuilder message = new StringBuilder();
      for(int index=0;index<e.getFieldErrors().size();index++) {
            FieldError fieldError = e.getFieldErrors().get(index);
            if(index != 0) message.append(", ");
            message.append("[").append(fieldError.getField()).append("]").append(" : ");
            String errCode = String.valueOf(fieldError.getCode());
            switch(errCode) {
            case "NotNull":
                message.append("must not be null");
                break;
            case "NotBlank":
                message.append("must not be blank");
                break;
            case "NotEmpty":
                message.append("must not be empty");
                break;
                default:
                    message.append(fieldError.getDefaultMessage());
                    break;
            }
        }
      
      errorEntity.setErrorMesage(message.toString());
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorEntity);
  }
}