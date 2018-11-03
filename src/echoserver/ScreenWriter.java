package echoserver;

import java.io.IOException;
import java.lang.Thread;
import java.io.InputStream;

public class ScreenWriter extends Thread{

  private InputStream input;

  public ScreenWriter(InputStream socketInputStream) {
    this.input = socketInputStream;
  }

  public void run(){
    try {
      int readByte;
      while ((readByte = System.in.read()) != -1) {
        int socketByte = input.read();
        System.out.write(socketByte);
      }
      System.out.flush();

    } catch(IOException ioe) {
      System.out.println("ScreenWriter has an error");
      System.out.println(ioe);
    }

  }
}
