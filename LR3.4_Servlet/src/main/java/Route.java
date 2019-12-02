public class Route {

    private long id = -1;
    private String startCity = "";
    private String endCity = "";
    private int distance;

    public Route(String startCity,
                 String endCity,
                 int distance) {
        this.startCity = startCity;
        this.endCity = endCity;
        this.distance = distance;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
    public String getStartCity() {
        return startCity;
    }
    public String getEndCity() { return endCity; }
    public int getDistance() { return distance; }
}