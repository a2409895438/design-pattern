package proxy_pattern;

public class static_proxy {
    public static void main(String[] args) {
        Player player = new VPlayer();
        Player playerProxy = new VPlayerProxy(player);
        playerProxy.playVideo("xixi");
    }
}

interface Player{
    void playVideo(String filename);
}

class VPlayer implements Player{
    @Override
    public void playVideo(String filename) {
        System.out.println("play..." + filename);
    }
}

class VPlayerProxy implements Player{
    private Player player;

    public VPlayerProxy(Player player) {
        this.player = player;
    }

    @Override
    public void playVideo(String filename) {
        System.out.println("before...");
        player.playVideo("hello");
        System.out.println("after");
    }
}

