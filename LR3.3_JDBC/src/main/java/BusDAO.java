import javax.xml.crypto.Data;
import java.sql.*;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;

public class BusDAO implements DAO<Bus> {

    private LinkedHashMap<Long,Bus> data = new LinkedHashMap<>(100);
    private Connection connection = null;

    @Override
    public void refresh() {
        data.clear();
        Connection conn = DatabaseConnection.getConnection();
        try (Statement stmt = conn.createStatement()) {
            /* TODO: filtering ordering */
            ResultSet rs = stmt.executeQuery("SELECT * FROM Bus");
            while (rs.next()) {
                Bus bus = new Bus(
                        rs.getString("numberplate")
                );
                long id = rs.getLong("id");
                bus.setId(id);
                data.put(id, bus);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Bus getByID(long id) {
        refresh();
        return data.get(id);
    }

    @Override
    public Bus getByPosition(int pos) {
        refresh();
        if (pos >= 0 && pos < data.size()) {
            return (Bus)data.values().toArray()[pos];
        } else {
            return null;
        }
    }

    @Override
    public List<Bus> getAsList() {
        refresh();
        List list = new ArrayList(data.size());
        data.values().forEach(o -> list.add(o));
        return list;
    }

    @Override
    public long add(Bus bus) {
        long id = -1;

        try {
            if (connection == null) {
                connection = DatabaseConnection.getConnection();
            }
            PreparedStatement statement = connection.prepareStatement(
                    String.format("INSERT INTO Bus(numberplate) VALUES('%s')", bus.getNumberplate()),
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
    public boolean update(long id, Bus bus) {

        try {
            if (connection == null) {
                connection = DatabaseConnection.getConnection();
            }
            Statement statement = connection.createStatement();
            long res = statement.executeUpdate(String.format(
                    "UPDATE Bus SET numberplate='%s' WHERE id=%d",
                    bus.getNumberplate(), id)
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
            int res = statement.executeUpdate(String.format("DELETE FROM Bus WHERE id=%d", id));

            if (res != 0)
                return true;
        }
        catch (SQLException e) {

        }

        return false;
    }

    @Override
    public Iterator<Bus> iterator() {
        return data.values().iterator();
    }
}
