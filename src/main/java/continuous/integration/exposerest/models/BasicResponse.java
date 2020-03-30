package continuous.integration.exposerest.models;

public class BasicResponse {

    private boolean isSuccess;
    private String message;

    public BasicResponse(){

    }

    public BasicResponse( boolean isSuc, String msg ){
        this.isSuccess = isSuc;
        this.message = msg;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
