import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

    public class ClientHandler extends Thread {
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                PackageData pd;
                while ((pd = (PackageData)inputStream.readObject()) != null) {
                    if (pd.getOperationType().equals("ADD_STUDENT")){
                        System.out.println("add");
                    }else if(pd.getOperationType().equals("LIST_STUDENTS")){
                        System.out.println("list");
                    }
                }
                inputStream.close();
                outStream.close();
                socket.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
