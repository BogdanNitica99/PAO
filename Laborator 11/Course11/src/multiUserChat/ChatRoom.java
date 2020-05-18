package multiUserChat;

import multiUserChat.server.ChatServer;

import static multiUserChat.util.ChatUtils.SERVER_PORT;

public class ChatRoom {

    public static void main(String[] args) {

        ChatServer chatServer = new ChatServer(SERVER_PORT);
        new Thread(chatServer).start();
    }

}
