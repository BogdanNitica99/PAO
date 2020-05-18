package fileTransfer;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class FileClient {

    private Socket clientSocket;
    private static final String FILE_PATH = "src\\ocpcurs\\sockets\\filetransfer\\FileClient.java";

    public FileClient(String host, int port) {
        try {
            clientSocket = new Socket(host, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendFile(String file) {
        try (DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
             FileInputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[4096];
            int read;
            while ((read = fis.read(buffer)) > 0) {
                dos.write(buffer, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileClient client = new FileClient("127.0.0.1", 8090);
        client.sendFile(FILE_PATH);
    }

}
