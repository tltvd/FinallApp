package network;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("THE SERVER WAS STARTED SUCCESSFULLY");
            System.out.println("WAITING CLIENTS");
            while(true){
                Socket socket=ss.accept();

                ServerThread st = new ServerThread(socket);
                st.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
