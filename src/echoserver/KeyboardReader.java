package echoserver;

import java.io.IOException;
import java.lang.Thread;
import java.io.OutputStream;

public class KeyboardReader extends Thread{
  private OutputStream output;

  public KeyboardReader(OutputStream socketOutputStream) {
    this.output = socketOutputStream;
  }

  public void run() {
    try {
      int readByte;
  		while ((readByte = System.in.read()) != -1) {
        output.write(readByte);
      }
    } catch(IOException ioe) {
      System.out.println("KeyboardReader has an error");
      System.out.println(ioe);
    }

  }
}
