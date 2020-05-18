package fileTransfer;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer extends Thread {

    private ServerSocket serverSocket;

    public FileServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        FileServer server = new FileServer(8090);
        server.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Server listening for incoming connections..");
                listen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void listen() throws IOException {
        Socket client = serverSocket.accept();
        String clientAddress = client.getInetAddress().getHostAddress();
        System.out.println(clientAddress + " connected to server");
        saveFile(client);
        System.out.println("File received.");
    }

    private void saveFile(Socket clientSocket) {
        try (DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
             FileOutputStream fos = new FileOutputStream("test", true)) {
            System.out.println("Receiving file from client...");
            byte[] buffer = new byte[4096];
            int read;
            while ((read = dis.read(buffer)) > 0) {
                fos.write(buffer, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
