import java.net.Socket;
import java.net.ServerSocket;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class SimpleJavaSocketServer {

    static Socket socket;
    static ServerSocket serverSocket;
    static InputStreamReader inputStreamReader;
    static BufferedReader bufferedReader;
    static String message;

    public static void main(String[] args) throws Exception {
        System.out.println("Server Started :)"); // System Output

        try {
            serverSocket = new ServerSocket(1234); // Server TCP Port
            while (true) { // Infinite Loop to receive multiple messages
                socket = serverSocket.accept();
                inputStreamReader = new InputStreamReader(socket.getInputStream());
                bufferedReader = new BufferedReader(inputStreamReader);
                message = bufferedReader.readLine();
                System.out.println(message); // Print message received to terminal

            }

        } catch (IOException e) {
            e.printStackTrace(); // Print Error
        }

    }
}