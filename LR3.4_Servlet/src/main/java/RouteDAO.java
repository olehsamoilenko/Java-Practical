import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class RouteDAO implements DAO<Route> {

    private LinkedHashMap<Long,Route> data = new LinkedHashMap<>(100);
    private Connection connection = null;

    @Override
    public void refresh() {
        data.clear();
        Connection conn = DatabaseConnection.getConnection();
        try (Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM Route");
            while (rs.next()) {
                Route route = new Route(
                        rs.getString("StartCity"),
                        rs.getString("EndCity"),
                        rs.getInt("Distance")
                );
                long id = rs.getLong("id");
                route.setId(id);
                data.put(id, route);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Route getByID(long id) {
        refresh();
        return data.get(id);
    }

    @Override
    public Route getByPosition(int pos) {
        refresh();
        if (pos >= 0 && pos < data.size()) {
            return (Route) data.values().toArray()[pos];
        } else {
            return null;
        }
    }

    @Override
    public List<Route> getAsList() {
        refresh();
        List list = new ArrayList(data.size());
        data.values().forEach(o -> list.add(o));
        return list;
    }

    @Override
    public long add(Route route) {
        long id = -1;

        try {
            if (connection == null) {
                connection = DatabaseConnection.getConnection();
            }
            PreparedStatement statement = connection.prepareStatement(
                    String.format("INSERT INTO Route(StartCity, EndCity, Distance) " +
                            "VALUES('%s', '%s', '%d')",
                            route.getStartCity(),
                            route.getEndCity(),
                            route.getDistance()),
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getLong(1);
            }
        }
        catch (SQLException e) {
            System.err.println(e);
        }

        return id;
    }

    @Override
    public boolean update(long id, Route route) {

        try {
            if (connection == null) {
                connection = DatabaseConnection.getConnection();
            }
            Statement statement = connection.createStatement();
            long res = statement.executeUpdate(String.format(
                    "UPDATE Route SET " +
                    "StartCity='%s' " +
                    "EndCity='%s' " +
                    "Distance='%d' " +
                    "WHERE id=%d",
                    route.getStartCity(),
                    route.getEndCity(),
                    route.getDistance(),
                    id)
            );

            if (res != 0)
                return true;
        }
        catch (SQLException e) {

        }

        return false;
    }

    @Override
    public boolean delete(long id) {

        try {
            if (connection == null) {
                connection = DatabaseConnection.getConnection();
            }
            Statement statement = connection.createStatement();
            int res = statement.executeUpdate(String.format("DELETE FROM Route WHERE id=%d", id));

            if (res != 0)
                return true;
        }
        catch (SQLException e) {

        }

        return false;
    }

    @Override
    public Iterator<Route> iterator() {
        return data.values().iterator();
    }
}
