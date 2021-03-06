package com.newlecture.web.service;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;

//소켓 : IP(건물번호) + Port(사서함번호) / + Web(웹소켓)
//내 IP + 80번포트 + Web주소(더 자세함)
@ServerEndpoint("/resource/chatserver") //외부에서 직접 요청해주게 하기 위해 디스패처에서 예외시킴
public class ChatServerEndPoint {
	//컬렉션의 종류 3가지 식별자에 따라..(값, index, 다른 무언가)
	private static Set<Session> clients;
	
	// CUD / R 로 나눔 -> 읽고있을때 조작하면 안됨. -> 동기화가 필요(1.라이브러리사용 2.직접동기화)
	// 스레드환경하에 모든 스레드가 Set에 들어가야함. -> static으로 만든 이유
	static {
		//누군가가 로딩중일때 조작이 들어오는 스레드를 막아주는 동기화셋으로 해쉬셋을 감싸줌
		clients = Collections.synchronizedSet(new HashSet<>());
	}
	
	//함수이름은 내 맘대로 OnOpen이라는 어노테이션으로 소켓 구분을 해주는거지용
	@OnOpen
	public void OnOpen(Session session, EndpointConfig config){
		clients.add(session);
		//접속되었는지 콘솔에 찍어보쟈
		//System.out.println(session.getBasicRemote());
		System.out.println(session.toString() + ": connected");
	}
	
	//메시지가 왔다며는? -> 나에게 전달해줘야지.
	//TCP -> 세션이 각각 구별되어있음  // UDP -> 같은 세션으로 들어오게됨. 
	@OnMessage
	public void onTextMessage(Session session, String data) throws IOException{
		
		System.out.println(data);
		//메시지 보낸친구에게 echo (1:1 채팅할꺼면 여기서 모으면 되겠다.)
		//session.getBasicRemote().sendText(data);
		
		ChatData chatData = new Gson().fromJson(data, ChatData.class);
		
		for(Session s : clients)
			s.getBasicRemote().sendText(data);
			
		//System.out.println();		
	}
	
	@OnClose
	public void OnClose(Session session){
		clients.remove(session);
		System.out.println(session.toString() + ": disconneted");
	}
	
		
}
