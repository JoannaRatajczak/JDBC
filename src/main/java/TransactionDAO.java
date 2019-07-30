import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {

    private Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/budget?serverTimezone=UTC&characterEncoding=utf8";
        try {
            return DriverManager.getConnection(url, "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List list(String type) {
        Connection connection = connect();
        PreparedStatement preparedStatement = null;

        String sql = "SELECT id, type, description, amount, date FROM transaction where type = ?";
        List<Transaction> list = new ArrayList<Transaction>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, type);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                long id = resultSet.getLong(1);
                String typ = resultSet.getString(2);
                String desc = resultSet.getString(3);
                double amount = resultSet.getDouble(4);
                String date = resultSet.getString(5);
                list.add(new Transaction(id, typ, desc, amount, date));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Could not get transaction");
        }
        //close(connection);
        return null;
    }

    public void addNew(Transaction transaction) {
        Connection connection = connect();

        PreparedStatement preparedStatement = null;
        try {
            String sql = "INSERT INTO transaction (type, description, amount, date) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, transaction.getType());
            preparedStatement.setString(2, transaction.getDescription());
            preparedStatement.setDouble(3, transaction.getAmount());
            preparedStatement.setString(4, transaction.getDate());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Could not save record");
            e.printStackTrace();
        }
        //close(connection);

    }

    public void update(Transaction transaction) {
        Connection connection = connect();

        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE transaction SET type = ?, description= ?, amount= ?, date= ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, transaction.getType());
            preparedStatement.setString(2, transaction.getDescription());
            preparedStatement.setDouble(3, transaction.getAmount());
            preparedStatement.setString(4, transaction.getDate());
            preparedStatement.setLong(5, transaction.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Could not find transaction");
        }
        //close(connection);
    }

    public void deleteByID(long id) {
        Connection connection = connect();

        PreparedStatement preparedStatement = null;
        try {
            String sql = "DELETE FROM transaction WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Could not remove");
        }

        //close(connection);

    }


    public void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}