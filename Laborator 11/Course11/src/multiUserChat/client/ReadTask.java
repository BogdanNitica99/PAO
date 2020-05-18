package multiUserChat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

//This thread is responsible for reading server's input and printing it to the console

public class ReadTask implements Runnable {

    private BufferedReader reader;
    private Socket socket;

    public ReadTask(Socket socket) {
        this.socket = socket;
        try {
            InputStream input = this.socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(input));
        } catch (IOException ex) {
            System.out.println("Error getting input stream: " + ex.getMessage());
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                readMessagesFromServer();
            } catch (IOException e) {
                System.out.println("Error reading from server: " + e.getMessage());
            }
        }
    }

    private void readMessagesFromServer() throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

}
