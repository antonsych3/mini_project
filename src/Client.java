import java.io.*;
import java.net.Socket;

public class Client {
    public static  MainFrame menuFrame = new MainFrame();
    public static AddFrame addFrame = new AddFrame();
    public static ListFrame listFrame = new ListFrame();
    public static ObjectInputStream inputStream;
    public static ObjectOutputStream outStream;
    private static Socket socket;


    public static void main(String[] args) throws IOException {
        menuFrame.setVisible(true);
        addFrame.setVisible(false);
        listFrame.setVisible(false);
        socket = new Socket("127.0.0.1", 1010);
        inputStream = new ObjectInputStream(socket.getInputStream());
        outStream = new ObjectOutputStream(socket.getOutputStream());
    }

}
