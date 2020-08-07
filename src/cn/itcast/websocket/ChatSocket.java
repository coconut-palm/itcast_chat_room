package cn.itcast.websocket;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;

@ServerEndpoint(value = "/websocket")
public class ChatSocket {

    private static Session session;
    private static HttpSession httpSession;
    private static Map<HttpSession, ChatSocket> onlineUsers = new HashMap<HttpSession, ChatSocket>();
    private static int onlineCount = 0;

    @OnOpen
    public void onOpen(Session session, EndpointConfig config){
    this.session = session;
    }
}
