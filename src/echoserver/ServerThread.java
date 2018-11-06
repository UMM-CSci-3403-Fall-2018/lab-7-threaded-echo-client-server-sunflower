package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerThread extends Thread{
  private InputStream input;
  private OutputStream output;
  private Socket socket;

  public ServerThread(Socket socket) throws IOException {
    try {
      // Setters to be used in run() later
      this.socket = socket;
      this.input = socket.getInputStream();
      this.output = socket.getOutputStream();
    } catch(IOException ioe) {
      System.out.println("ServerThread has an error");
      System.out.println(ioe);
    }
  }

  public void run() {
    try{
      // Writes until KeyboardReader shutsdown output
      int b;
      while ((b = input.read()) != -1) {
        output.write(b);
      }
      socket.shutdownOutput();
    } catch(IOException ioe) {
			System.out.println("ServerThread has an error");
      System.out.println(ioe);
		}
  }
}
