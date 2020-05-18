package multiUserChat.client;

import multiUserChat.util.ChatUtils;

import java.io.IOException;
import java.net.Socket;

public class ChatClient {

    private final String serverName;
    private final int serverPort;
    private Socket socket;

    public ChatClient(String serverName, int serverPort) {
        this.serverName = serverName;
        this.serverPort = serverPort;
    }

    public static void main(String[] args) {

        ChatClient client = new ChatClient(ChatUtils.SERVER_ADDRESS, ChatUtils.SERVER_PORT);

        if (client.connect()) {
            System.out.println("connected to chat server");
            ChatUtils.THREAD_POOL.execute(new ReadTask(client.socket));
            ChatUtils.THREAD_POOL.execute(new WriteTask(client.socket));
        }
    }

    private boolean connect() {
        try {
            socket = new Socket(serverName, serverPort);
            return true;
        } catch (IOException e) {
            System.err.println("Connection failed");
            return false;
        }
    }
    
}
