import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InitDB {
    private String url;
    private String userName;
    private String password;
    private Connection connection;

    public InitDB(String url, String userName, String password) {
        this.url = url;
        this.userName = userName;
        this.password = password;
        Connect();
    }

    private void Connect() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://" + url + "?serverTimezone=Europe/Moscow", userName, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
