package grapecity.server;

import com.google.gson.Gson;
import grapecity.model.message;
import grapecity.model.sendMsg;
import org.springframework.stereotype.Component;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hello on 2018/5/20.
 */

@ServerEndpoint("/chat/{param}/{num}")
@Component
public class chatSocket {
    private static List<Session> sessions = new ArrayList<Session>();
    private static List<String>  usernames = new ArrayList<String>();
    private static Map<String, Session> userinfo1 = new HashMap<String, Session>();
    private static Map<String, String> userinfo2 = new HashMap<String, String>();//保存头像
    private static List<String>  nums = new ArrayList<String>();

    @OnOpen
    public void open(Session session, @PathParam(value = "param") String username,
                     @PathParam(value = "num") String num) throws IOException {
        message m = new message();
        userinfo1.put(username, session);
        userinfo2.put(username, num);
        usernames.add(username);
        nums.add(num);
        sessions.add(session);
        m.setUsername(usernames);
        m.setNum(nums);
        broadcast(sessions, m.toJson());
    }

    public void broadcast(List<Session> sessions, String msg) throws IOException {
        for (Session session : sessions) {
            session.getBasicRemote().sendText(msg);
        }
    }
    @OnMessage
    public void message(Session session,String json) throws IOException {
        sendMsg m=new Gson().fromJson(json,sendMsg.class);
        Session session1=userinfo1.get(m.getTo());
        message mss=new message();
        mss.setMessage(m.getMsg());
        session1.getBasicRemote().sendText(mss.toJson());
    }
}
