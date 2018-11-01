package echoserver;

import java.lang.Thread;
import java.io.InputStream;

public class ScreenWriter extends Thread{

  private InputStream input;

  public ScreenWriter(InputStream socketInputStream) {
    this.input = socketInputStream;
  }

  public void run(){
    int readByte;
    while ((readByte = System.in.read()) != -1) {
      int socketByte = socketInputStream.read();
      System.out.write(socketByte);
    }
    System.out.flush();
  }
}
