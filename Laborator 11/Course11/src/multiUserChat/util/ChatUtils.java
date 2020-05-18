package multiUserChat.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatUtils {

    public static final String SERVER_ADDRESS = "127.0.0.1";
    public static final int SERVER_PORT = 8088;
    public static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(50);

}
