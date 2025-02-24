package vn_phuocloc.phuocloc_sample_code.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import jakarta.validation.ConstraintViolationException;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // Ghi log
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({ MethodArgumentNotValidException.class,
            ConstraintViolationException.class,
            HandlerMethodValidationException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidationException(Exception e, WebRequest request) {
        System.out.println("======> handlevalidationException");
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimestamp(new Date());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setPath(request.getDescription(false).replace("uri=", ""));

        // get message from error
        String message = e.getMessage();

        if (e instanceof MethodArgumentNotValidException) {
            int start = message.lastIndexOf("[");
            int end = message.lastIndexOf("]");
            message = message.substring(start + 1, end - 1);
            errorResponse.setError("Payload invalid");

            List<FieldError> fieldErrors = ((MethodArgumentNotValidException) e).getBindingResult().getFieldErrors();

            for (FieldError fieldError : fieldErrors) {
                errorResponse.addMessage(fieldError.getDefaultMessage());
            }
            // errorResponse.setMessage(message);

        }
        // HandlerMethodValidationException dùng để xử lí các tham số phương thức như
        // @Min @Max,...
        else if (e instanceof HandlerMethodValidationException) {
            message = message.substring(message.indexOf(" ") + 1);
            errorResponse.setError("Pathvariable invalid");
        }
        LOGGER.error(e.getMessage(), e);
        return errorResponse;
    }

    @ExceptionHandler({ MethodArgumentTypeMismatchException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleInternalServerErrorException(Exception e,
            WebRequest request) {
        System.out.println("======> handleInternalServerErrorException");
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimestamp(new Date());
        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        errorResponse.setPath(request.getDescription(false).replace("uri=", ""));
        if (e instanceof MethodArgumentTypeMismatchException) {
            // errorResponse.setMessage("Failed to convert value of type");
            errorResponse.addMessage("Failed to convert value of type");
        }
        // errorResponse.setMessage("");

        LOGGER.error(e.getMessage(), e);
        return errorResponse;
    }

}
