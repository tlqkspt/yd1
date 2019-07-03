package test93.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import test93.savelog.TextLog;



public class ChatServer {

	public static ArrayList<PrintWriter> m_OutputList;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		m_OutputList = new ArrayList<PrintWriter>();
		TextLog logtest = new TextLog(); // 서버 로그 저장 //로그저장테스트 수정

		try {
			ServerSocket s_socket = new ServerSocket(8888);

			logtest.save("\r\n"+"===== 서버시작 ======"); // 서버 로그 저장 //로그저장테스트 수정
			
			while (true) {
			
//				// exit 입력하면 서버종료 하려고 설정 수정
//				BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(System.in));
//				String serverExit;
//				//  exit 입력하면 서버종료 하려고 설정 수정
				
				
				Socket c_socket = s_socket.accept();
				ClientManagerThread c_thread = new ClientManagerThread();
				c_thread.setSocket(c_socket);

				m_OutputList.add(new PrintWriter(c_socket.getOutputStream()));

				
				c_thread.start();

				m_OutputList.toString();
				
//				//  exit 입력하면 서버종료 하려고 설정 수정
//				serverExit = tmpbuf.readLine();
//				if (serverExit.equals("exit")) {
//					break;
//				}
//				// exit 입력하면 서버종료 하려고 설정 수정
				
			}
//			s_socket.close();		//서버종료 수정

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
