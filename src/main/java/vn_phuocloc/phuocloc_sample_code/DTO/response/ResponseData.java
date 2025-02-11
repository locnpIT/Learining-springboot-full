package vn_phuocloc.phuocloc_sample_code.DTO.response;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ResponseData<T> {

    private int status;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL) // neu data ma null thi khong hien thi
    private T data;

    // Get Post
    public ResponseData(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    // Put Patch Delete
    public ResponseData(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
