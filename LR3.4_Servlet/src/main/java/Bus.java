public class Bus {

    private long id = -1; /* TODO: get rid of */
    private String numberplate = "";

    public Bus(String numberplate) {
        this.numberplate = numberplate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumberplate() {
        return numberplate;
    }

    public void setNumberplate(String numberplate) {
        this.numberplate = numberplate;
    }

    @Override
    public String toString() {
        return String.format("%d:%s", id, numberplate);
    }
}