import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

public class Server {
    public static PackageData resultPd = new PackageData();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1010);
        System.out.println("Waiting...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Ok");
            ClientHandler clientHandler = new ClientHandler(socket);
            clientHandler.start();
        }

    }
}
