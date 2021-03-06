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
      int socketByte;
      // Writes while there is data to be written
      while ((socketByte = input.read()) != -1) {
        System.out.write(socketByte);
      }
      // Send any remaining data
      System.out.flush();
    } catch(IOException ioe) {
      System.out.println("ScreenWriter has an error");
      System.out.println(ioe);
    }

  }
}
