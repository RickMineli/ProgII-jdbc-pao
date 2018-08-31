package pkg3esoft2018.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionManager {
    private Connection conn;
    private static ConnectionManager me;

    private ConnectionManager() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/3esoft2018","root","");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ConnectionManager getInstance() {
        if (me == null) {
            me = new ConnectionManager();
        }
        return me;
    }

    //exemplo de delegação de comportamento (delegation).
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return this.conn.prepareStatement(sql);
    }

}
