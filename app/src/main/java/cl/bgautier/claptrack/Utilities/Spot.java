package cl.bgautier.claptrack.Utilities;

public class Spot {
    private static int counter = 0;

    public long id;
    public String url;

    public Spot(String url) {
        this.id = counter++;
        this.url = url;
    }
}