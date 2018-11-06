package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.lang.Thread;

public class EchoClient{
	public static final int PORT_NUMBER = 6013;

	// Need 2 classes implementing runnable

	public static void main(String[] args) throws IOException, InterruptedException {
		EchoClient client = new EchoClient();
		client.start();
	}

	private void start() throws IOException, InterruptedException {
		try {
			Socket socket = new Socket("localhost", PORT_NUMBER);
			InputStream socketInputStream = socket.getInputStream();
			OutputStream socketOutputStream = socket.getOutputStream();

			Thread r = new Thread(new KeyboardReader(socket));
			r.start();
			r.join();
			Thread w = new Thread(new ScreenWriter(socketInputStream));
			w.start();
			w.join();
			//socket.shutdownOutput();

		} catch(IOException ioe) {
			System.out.println("EchoClient has an error");
      System.out.println(ioe);
		} catch(InterruptedException ie) {
			System.out.println("EchoClient has an error");
      System.out.println(ie);
		}

	}
}
