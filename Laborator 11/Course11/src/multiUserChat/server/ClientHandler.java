package multiUserChat.server;

import multiUserChat.domain.User;
import multiUserChat.service.UserService;
import multiUserChat.service.UserServiceMySql;

import java.io.*;
import java.net.Socket;
import java.util.*;
import java.util.stream.Collectors;

import static multiUserChat.domain.Command.*;

public class ClientHandler implements Runnable {

    private final Socket client;
    private final ChatServer chatServer;
    private User user;
    private BufferedReader br;
    private PrintWriter pw;
    private final UserService userService;

    public ClientHandler(ChatServer chatServer, Socket clientSocket) {
        this.chatServer = chatServer;
        this.client = clientSocket;
        this.userService = UserServiceMySql.getInstance();
        try {
            InputStream is = client.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            OutputStream os = client.getOutputStream();
            pw = new PrintWriter(os, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            handleClient();
        } catch (IOException e) {
            System.err.println("Error in client handler: " + e.getMessage());
        }
    }

    private void handleClient() throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            String[] tokens = line.split(" ");
            if (tokens.length > 0) {
                String command = tokens[0];
                if (LOGIN.getCommand().equalsIgnoreCase(command)) {
                    handleLogin(tokens);
                } else if (LOGOUT.getCommand().equalsIgnoreCase(command)) {
                    handleLogout();
                } else if (MSG.getCommand().equalsIgnoreCase(command)) {
                    handleMessage(tokens);
                } else {
                    handleUnknownCommand(command);
                }
            }
        }
    }

    private void handleUnknownCommand(String command) {
        String message = "unknown command " + command + "\n";
        System.err.println(message);
        sendMessageToClient(message, this);
    }

    private void handleMessage(String[] tokens) {
        // check user sending message command is logged in
        if (user != null) {
            String targetUsername = tokens[1];
            // check if target user exists in DB
            Optional<User> user = userService.getUserByUsername(targetUsername);
            if (user.isPresent()) {
                // check target user is connected to server
                Optional<ClientHandler> targetClient = chatServer.getClients().stream()
                        .filter(client -> client.getUser().getUsername().equalsIgnoreCase(targetUsername))
                        .findFirst();
                if (targetClient.isPresent()) {
                    // check target user is logged in
                    if (targetClient.get().getUser() != null) {
                        String message = this.getUser().getUsername() + " says: " +
                                Arrays.stream(tokens)
                                        .skip(2)
                                        .collect(Collectors.joining(" "));
                        sendMessageToClient(message, targetClient.get());
                    } else {
                        String message = "Target user " + targetUsername + " is not logged in";
                        System.err.println(message);
                        sendMessageToClient(message, this);
                    }
                } else {
                    String message = "Target user " + targetUsername + " is not connected to server";
                    System.err.println(message);
                    sendMessageToClient(message, this);
                }
            } else {
                String msg = "user not found for username: " + targetUsername;
                System.err.println(msg);
                sendMessageToClient(msg, this);
            }
        } else {
            String message = "login first before trying to send messages";
            System.err.println(message);
            sendMessageToClient(message, this);
        }
    }

    private void handleLogout() {
        if (user != null) {
            String message = user.getUsername() + " logged out";
            System.out.println(message);
            broadcast(message, new ArrayList<>());
            this.user = null;
            chatServer.getClients().remove(this);
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            String message = "login first before logging out";
            System.err.println(message);
            sendMessageToClient(message, this);
        }
    }

    private void handleLogin(String[] tokens) {
        if (tokens.length == 3) {
            String username = tokens[1];
            String password = tokens[2];
            if (user != null) {
                String message = user.getUsername() + " already logged in";
                System.err.println(message);
                sendMessageToClient(message, this);
            } else {
                Optional<User> user = userService.getUserByUsername(username);
                if (user.isPresent() && user.get().getPassword().equals(password)) {
                    this.user = user.get();
                    String message = username + " logged in";
                    System.out.println(message);
                    broadcast(message, Collections.singletonList(this));
                    sendMessageToClient("you are now logged in", this);
                } else {
                    String errorMessage = "invalid username or password";
                    System.err.println(errorMessage);
                    sendMessageToClient(errorMessage, this);
                }
            }
        } else {
            String errorMessage = "incorrect message format";
            System.err.println(errorMessage);
            sendMessageToClient(errorMessage, this);
        }
    }

    private void broadcast(String message, List<ClientHandler> excluded) {
        Set<ClientHandler> audience = chatServer.getClients()
                .stream()
                .filter(client -> client.getUser() != null)
                .collect(Collectors.toSet());
        audience.removeAll(excluded);
        audience.forEach(client -> client.pw.println(message));
    }

    private void sendMessageToClient(String message, ClientHandler client) {
        client.pw.println(message);
    }

    public User getUser() {
        return user;
    }

}
