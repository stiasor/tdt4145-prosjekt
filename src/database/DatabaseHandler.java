package database;

import java.sql.*;

public class DatabaseHandler {

    private Connection con;

    public DatabaseHandler(String dbClass, String host, String user, String pass)   {
        try {
            Class.forName(dbClass);
            this.con = DriverManager.getConnection(host, user, pass);
            if (con != null) {
                System.out.println("connected to database \n");
            } else {
                System.out.println("Something went wrong, connection not established.");
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public PreparedStatement prepQuery(String query) throws SQLException {
        return con.prepareStatement(query);
    }

    public int displayResults(ResultSet result) throws SQLException {
        ResultSetMetaData meta = result.getMetaData();
        int columnsNumber = meta.getColumnCount();
        while(result.next()){
            for (int i = 0; i <= columnsNumber; i++){
                System.out.println(result.getString(i) + " ");
            }
            System.out.println();
        }
        return 0;
    }
}