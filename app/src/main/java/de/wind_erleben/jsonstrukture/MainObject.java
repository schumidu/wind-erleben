package de.wind_erleben.jsonstrukture;

public class MainObject {

    private boolean success;
    private DataObject data;

    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public DataObject getData() {
        return data;
    }
    public void setData(DataObject data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "MainObject [success=" + success + ", data=" + data + "]";
    }
    
}
