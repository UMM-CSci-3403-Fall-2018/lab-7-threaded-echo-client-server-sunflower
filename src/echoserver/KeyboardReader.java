package echoserver;

import java.io.IOException;
import java.lang.Thread;
import java.io.OutputStream;
import java.net.Socket;

public class KeyboardReader extends Thread{
  private OutputStream output;
  private Socket socket;

  public KeyboardReader(Socket socket) throws IOException {
    try {
      this.socket = socket;
      this.output = socket.getOutputStream();
    } catch(IOException ioe) {
      System.out.println("KeyboardReader has an error");
      System.out.println(ioe);
    }
  }

  public void run() {
    try {
      int readByte;
  		while ((readByte = System.in.read()) != -1) {
        output.write(readByte);
      }
      socket.shutdownOutput();
    } catch(IOException ioe) {
      System.out.println("KeyboardReader has an error");
      System.out.println(ioe);
    }
  }
}
