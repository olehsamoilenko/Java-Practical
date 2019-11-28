public class Main {

    public static void main(String[] args) {

        System.out.println("Start:");
        BusDAO buses = new BusDAO();
        System.out.println(buses.getAsList() + "\n");

        System.out.println("After add:");
        long res = buses.add(new Bus("AA7777AA"));
        System.out.println(buses.getAsList() + "\n");

        System.out.println("By ID: " + buses.getByID(res));
        System.out.println("By position: " + buses.getByPosition((int)res) + "\n");

        System.out.println("After update:");
        buses.update(res, new Bus("AA8888AA"));
        System.out.println(buses.getAsList() + "\n");

        System.out.println("After delete:");
        buses.delete(res);
        System.out.println(buses.getAsList());
    }
}
