import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    private static final String USERNAME = "osamoile";
    private static final String PASSWORD = "osamoile";
    private static final String URL = "jdbc:mysql://localhost/Scoreboard";

    private static DatabaseConnection instance = null; /* singleton object */
    private Connection connection = null;

    private DatabaseConnection() throws SQLException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static Connection getConnection() {
        if (instance == null) {
            try {
                instance = new DatabaseConnection();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instance.connection;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

}
