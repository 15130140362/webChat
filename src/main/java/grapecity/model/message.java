package grapecity.model;

import com.google.gson.Gson;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;

import java.util.List;

/**
 * Created by hello on 2018/5/20.
 */
public class message {
    private List<String> num;
    private String message;
    private List<String> username;
    private Gson gson = new Gson();

    public List<String> getNum() {
        return num;
    }

    public void setNum(List<String> num) {
        this.num = num;
    }

    public void setUsername(List<String> username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }

    public String toJson() {
        return gson.toJson(this);
    }
}
