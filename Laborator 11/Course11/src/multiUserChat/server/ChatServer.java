package multiUserChat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import static multiUserChat.util.ChatUtils.THREAD_POOL;

public class ChatServer implements Runnable {

    private final int serverPort;
    private final Set<ClientHandler> clients = new CopyOnWriteArraySet<>();

    public ChatServer(int serverPort) {
        this.serverPort = serverPort;
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(serverPort)) {
            System.out.println("Chat Server is listening on port " + serverPort);
            while (true) {
                System.out.println("Server ready to accept client connection...");
                Socket client = serverSocket.accept();
                System.out.println("Accepted connection from " + client);
                ClientHandler handler = new ClientHandler(this, client);
                clients.add(handler);
                THREAD_POOL.execute(handler);
            }
        } catch (IOException e) {
            System.out.println("Internal server error: " + e.getMessage());
        }
    }

    public Set<ClientHandler> getClients() {
        return clients;
    }

}
