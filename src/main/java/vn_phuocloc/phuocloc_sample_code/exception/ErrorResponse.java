package vn_phuocloc.phuocloc_sample_code.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErrorResponse {

    private Date timestamp;
    private int status;
    private String path;
    private String error;
    private List<String> message = new ArrayList<>();

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

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<String> getMessage() {
        return this.message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public void addMessage(String message) {
        this.message.add(message);
    }

}
