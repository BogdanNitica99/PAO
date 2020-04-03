package Products;

public class Game extends Software {

    private int numberOfPlayers;
    private int size;
    private String platform;

    public Game(String name, int version, int cost, int numberOfPlayers, int size, String platform) {
        super(name, version, cost);
        this.numberOfPlayers = numberOfPlayers;
        this.size = size;
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "Game{" +
                "numberOfPlayers=" + numberOfPlayers +
                ", size=" + size +
                ", platform='" + platform + '\'' +
                super.toString() +
                '}';
    }
}
