package io.github.dunwu.springboot.reverse;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/reverse")
public class ReverseWebSocketEndpoint {

	@OnMessage
	public void handleMessage(Session session, String message) throws IOException {
		session.getBasicRemote().sendText("Reversed: " + new StringBuilder(message).reverse());
	}

}
