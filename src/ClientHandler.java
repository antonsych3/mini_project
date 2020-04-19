import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;

public class ClientHandler extends Thread {
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                DBManager manager = new DBManager();
                manager.connect();
                ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                PackageData pd;

                while ((pd = (PackageData)inputStream.readObject()) != null) {
                    if (pd.getOperationType().equals("ADD_STUDENT")){
                        if(Server.resultPd.addStudent(pd.getStudent())){
                            System.out.println(pd.student);
                            manager.addStudent(pd.student);
                            pd.setOperationType("Added");
                            outStream.writeObject(pd);
                        }else {
                            outStream.writeObject(pd);
                        }

                    }else if(pd.getOperationType().equals("LIST_STUDENTS")){
                        Server.resultPd.setStudents(manager.getAllStudents());
                        outStream.writeObject(Server.resultPd);
                        System.out.println(Server.resultPd.getStudents().size());

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
