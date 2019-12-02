public class BusOnRoute {

    private long id = -1;
    private Bus bus;
    private Route route;

    public BusOnRoute(Bus bus, Route route) {
        this.bus = bus;
        this.route = route;
    }

    public long getId() {
        return id;
    }
    public Bus getBus() { return bus; }
    public Route getRoute() { return route; }
    public String getNumberplate() { return bus.getNumberplate(); }
    public String getStartCity() { return route.getStartCity(); }
    public String getEndCity() { return route.getEndCity(); }
    public int getDistance() { return route.getDistance(); }

    public void setId(long id) {
        this.id = id;
    }

}