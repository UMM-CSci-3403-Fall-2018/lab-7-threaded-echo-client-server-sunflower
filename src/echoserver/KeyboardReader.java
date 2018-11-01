package echoserver;

import java.lang.Thread;
import java.io.OutputStream;

public class KeyboardReader extends Thread{
  private OutputStream output;

  public KeyboardReader(OutputStream socketOutputStream) {
    this.output = socketOutputStream;
  }

  public void run(){
    int readByte;
		while ((readByte = System.in.read()) != -1) {
      output.write(readByte);
    }
  }
}
