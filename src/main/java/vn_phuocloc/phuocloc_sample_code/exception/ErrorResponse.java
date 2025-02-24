package vn_phuocloc.phuocloc_sample_code.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErrorResponse {

    private Date timestamp;
    private int status;
    private String path;
    private List<String> error = new ArrayList<>();
    private String message;

    public ErrorResponse() {

    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<String> getError() {
        return this.error;
    }

    public void setError(List<String> error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void addError(String message) {
        this.error.add(message);
    }

}
