package cl.bgautier.claptrack.Utilities;

public class TouristSpot {
    public String url;
    public String name;
    public String genre;
    public String ranking;

    public TouristSpot(String name, String genre, String ranking, String url) {

        this.genre = genre;
        this.url = url;
        this.name = name;
        this.ranking = ranking;
    }
}