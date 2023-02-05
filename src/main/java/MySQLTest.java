import java.sql.*;
import java.util.ArrayList;

public class MySQLTest {

    private final String url;// ="jdbc:mysql://localhost:3306/memorymatrix";
    private final String username;// = "root";
    private final String password;// = "admin";

    private Connection connection;

    private JsonTest jsonParser;

    public MySQLTest(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
        connect();
    }

    public void connect() {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database");
        } catch (SQLException e) {
            System.out.println("something wrong with connection");
            throw new RuntimeException(e);
        }
        jsonParser = new JsonTest();
    }


    public void close() {
        try {
            connection.close();
            System.out.println("connection has been closed");
        } catch (SQLException e) {
            System.out.println("something wrong with closing connection");
            throw new RuntimeException(e);
        }
    }

    public void parse(ArrayList<Integer> array) {
        jsonParser.add("1", array);
    }

    public void insertArr(String table, Integer idx, String column1, String column2, ArrayList<Integer> array) {

        try {
            String queryIN = "INSERT INTO " + table + " (" + column1 + ", " + column2 + ") VALUES(?,?)";
            PreparedStatement statement = connection.prepareStatement(queryIN);
            for (Integer i : array) {
                statement.setInt(1, idx);
                statement.setInt(2, i);
                statement.executeUpdate();
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Integer> selectArr(String table, Integer idx, String column1, String column2) {
        String queryOUT = "SELECT " + column2 + " FROM " + table + " WHERE idx=" + idx;
        ArrayList<Integer> array = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(queryOUT);
            while (rs.next()) {
                // int id = rs.getInt(column1);
                int cell = rs.getInt(column2);

                array.add(cell);
                // print the results
                // System.out.format("%s, %s\n", id, cell);
            }
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return array;
    }

    public void deleteTable(String table) {
        String query = "DELETE FROM " + table;
        try {
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
