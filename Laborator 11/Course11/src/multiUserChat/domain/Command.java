package multiUserChat.domain;

public enum Command {

    LOGIN("login"), MSG("msg"), LOGOUT("logout");

    private String command;

    // private constructor implicitly
    Command(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

}
