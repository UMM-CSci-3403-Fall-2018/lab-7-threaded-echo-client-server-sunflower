package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.lang.Thread;

public class EchoClient{
	public static final int PORT_NUMBER = 6013;

	public static void main(String[] args) throws IOException, InterruptedException {
		EchoClient client = new EchoClient();
		client.start();
	}

	private void start() throws IOException, InterruptedException {
		try {
			Socket socket = new Socket("localhost", PORT_NUMBER);
			InputStream socketInputStream = socket.getInputStream();

			// KeyboardReader needs socket to let the server know when input is finished
			// ScreenWriter needs socketInputStream and not socket because it does not communicate with the socket
			Thread r = new Thread(new KeyboardReader(socket));
			r.start();
			r.join();
			Thread w = new Thread(new ScreenWriter(socketInputStream));
			w.start();
			w.join();
		} catch(IOException ioe) {
			System.out.println("EchoClient has an error");
      System.out.println(ioe);
		} catch(InterruptedException ie) {
			System.out.println("EchoClient has an error");
      System.out.println(ie);
		}

	}
}
