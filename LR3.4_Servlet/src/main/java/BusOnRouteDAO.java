import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class BusOnRouteDAO implements DAO<BusOnRoute> {

    private LinkedHashMap<Long,BusOnRoute> data = new LinkedHashMap<>(100);
    private Connection connection = null;

    @Override
    public void refresh() {
        data.clear();
        Connection conn = DatabaseConnection.getConnection();
        try (Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM Shedule " +
                    "JOIN Bus ON Bus.id = Shedule.Bus " +
                    "JOIN Route ON Route.id = Shedule.Route");
            while (rs.next()) {
                Bus bus = new Bus(
                        rs.getString("numberplate")
                );
                Route route = new Route(
                        rs.getString("StartCity"),
                        rs.getString("EndCity"),
                        rs.getInt("Distance")
                );
                BusOnRoute busOnRoute = new BusOnRoute(bus, route);
                long id = rs.getLong("id");
                bus.setId(id);
                data.put(id, busOnRoute);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public BusOnRoute getByID(long id) {
        refresh();
        return data.get(id);
    }

    @Override
    public BusOnRoute getByPosition(int pos) {
        refresh();
        if (pos >= 0 && pos < data.size()) {
            return (BusOnRoute) data.values().toArray()[pos];
        } else {
            return null;
        }
    }

    @Override
    public List<BusOnRoute> getAsList() {
        refresh();
        List list = new ArrayList(data.size());
        data.values().forEach(o -> list.add(o));
        return list;
    }

    @Override
    public long add(BusOnRoute bus) {
        long id = -1;

//        try {
//            if (connection == null) {
//                connection = DatabaseConnection.getConnection();
//            }
//            PreparedStatement statement = connection.prepareStatement(
//                    String.format("INSERT INTO Bus(numberplate) VALUES('%s')", bus.getNumberplate()),
//                    Statement.RETURN_GENERATED_KEYS
//            );
//            statement.executeUpdate();
//            ResultSet resultSet = statement.getGeneratedKeys();
//            if (resultSet.next()) {
//                id = resultSet.getLong(1);
//            }
//        }
//        catch (SQLException e) {
//            System.err.println(e);
//        }

        return id;
    }

    @Override
    public boolean update(long id, BusOnRoute bus) {

//        try {
//            if (connection == null) {
//                connection = DatabaseConnection.getConnection();
//            }
//            Statement statement = connection.createStatement();
//            long res = statement.executeUpdate(String.format(
//                    "UPDATE Bus SET numberplate='%s' WHERE id=%d",
//                    bus.getNumberplate(), id)
//            );
//
//            if (res != 0)
//                return true;
//        }
//        catch (SQLException e) {
//
//        }

        return false;
    }

    @Override
    public boolean delete(long id) {

//        try {
//            if (connection == null) {
//                connection = DatabaseConnection.getConnection();
//            }
//            Statement statement = connection.createStatement();
//            int res = statement.executeUpdate(String.format("DELETE FROM Bus WHERE id=%d", id));
//
//            if (res != 0)
//                return true;
//        }
//        catch (SQLException e) {
//
//        }

        return false;
    }

    @Override
    public Iterator<BusOnRoute> iterator() {
        return data.values().iterator();
    }
}
