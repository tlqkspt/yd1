package co.kdw.Client;

import java.io.IOException;
import java.net.Socket;

public class MainClient {
	public static void main(String[] args) {

		try {

			Socket c_socket = new Socket("192.168.0.103",8888);

			ReceiveThread rec_thread = new ReceiveThread();
			rec_thread.setSocket(c_socket);

			SendThread send_thread = new SendThread();
			send_thread.setSocket(c_socket);

			rec_thread.start();
			send_thread.start();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
