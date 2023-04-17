package main;

import java.awt.*;
import java.sql.*;
import java.util.Date;

public class Database {

    static final String DIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    static final String DB_URl = "jdbc:mysql://localhost:3306/theWar";
    static final String USER = "root";
    static final String PASSWORD = "";

    private Connection connection = null;
    private Statement statement = null;

    GamePanel gp;

    public Database(GamePanel gp)
    {
        this.gp = gp;
    }

    public void insert() throws SQLException, ClassNotFoundException {
        try
        {
            Class.forName(DIVER_CLASS);
            connection = DriverManager.getConnection(DB_URl, USER, PASSWORD);

            String sql = "Insert into gameDiary (No, Score, Date) value (?, ?, ?)";

            java.util.Date javaDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(javaDate.getTime());

            int nextNo = getMaxNo() + 1;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, nextNo);
            preparedStatement.setInt(2, gp.player.score);
            preparedStatement.setDate(3,sqlDate);
            preparedStatement.execute();
        }
        finally
        {
            //STEP 5: Close connection
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        }
    }

    public int getMaxNo() throws SQLException, ClassNotFoundException
    {
        int maxNo = 0;
        try
        {
            Class.forName(DIVER_CLASS);
            connection = DriverManager.getConnection(DB_URl, USER, PASSWORD);

            statement = connection.createStatement();
            String sql = "SELECT MAX(No) FROM gameDiary";
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next())
            {
               maxNo = resultSet.getInt(1);
            }
            if(resultSet != null)
            {
                resultSet.close();
            }
        }
        catch (Exception e)
        {

        }
        return maxNo;
    }
}
