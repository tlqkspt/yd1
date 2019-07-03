package test93.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import test93.savelog.TextLog;



public class ClientManagerThread extends Thread{

	private Socket m_socket;
	private String m_ID;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			BufferedReader tmpbuffer = new BufferedReader(new InputStreamReader(m_socket.getInputStream()));
			
			String text;
			
			TextLog logtest = new TextLog(); //로그저장테스트 수정
			
			while(true)
			{
				text = tmpbuffer.readLine();
				
				
				//로그저장테스트 수정
				if(m_ID != null && text != null)
				logtest.save(text,m_ID);
				
				if(text == null)
				{
					String outMessage = m_ID + " 이(가) 나갔습니다.";		//로그 수정
					logtest.save(outMessage);	//사용자 퇴장 로그 저장
					System.out.println(outMessage);	//로그 수정
					for(int i = 0; i < ChatServer.m_OutputList.size(); ++i)
					{
						ChatServer.m_OutputList.get(i).println(outMessage); //로그테스트 수정
						ChatServer.m_OutputList.get(i).flush();
					}
					break;
				}
				
				String[] split = text.split("highkrs12345");
				if(split.length == 2 && split[0].equals("ID"))
				{
					m_ID = split[1];
					
					String inMessage = m_ID + " 이(가) 입장하였습니다.";		//로그테스트 수정
					logtest.save(inMessage);							//로그테스트수정
		
					System.out.println(m_ID + " 이(가) 입장하였습니다.");
					for(int i = 0; i < ChatServer.m_OutputList.size(); ++i)
					{
						ChatServer.m_OutputList.get(i).println(m_ID + " 이(가) 입장하였습니다.");
						ChatServer.m_OutputList.get(i).flush();
					}
					continue;
				}
				
				for(int i = 0; i < ChatServer.m_OutputList.size(); ++i)
				{
					ChatServer.m_OutputList.get(i).println(m_ID + "> "+ text);
					ChatServer.m_OutputList.get(i).flush();
				}
			}
			
			ChatServer.m_OutputList.remove(new PrintWriter(m_socket.getOutputStream()));
			m_socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getM_ID() {
		return m_ID;
	}

	public void setSocket(Socket _socket)
	{
		m_socket = _socket;
	}
}
