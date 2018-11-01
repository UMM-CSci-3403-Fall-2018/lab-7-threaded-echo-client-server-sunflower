package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.lang.Thread;

public class EchoClient{
	public static final int PORT_NUMBER = 6013;

	// Need 2 classes implementing runnable

	public static void main(String[] args) throws IOException {
		EchoClient client = new EchoClient();
		client.start();
	}

	private void start() throws IOException {
		Socket socket = new Socket("localhost", PORT_NUMBER);
		InputStream socketInputStream = socket.getInputStream();
		OutputStream socketOutputStream = socket.getOutputStream();

		Thread r = new Thread(new KeyboardReader(socketOutputStream));
		r.start();
		Thread w = new Thread(new ScreenWriter(socketInputStream));
		w.start();
	}
}
