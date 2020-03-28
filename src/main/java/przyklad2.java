
import java.sql.*;

public class przyklad2 {
    public static void main(String[] args) {

//        String url = "jdbc:mysql://localhost:3306/shop?serverTimezone=CET";
//        String user = "root";
//        String password = "Kijas66085@";
        String query = "Select * from address where add_city like \"%\"?\"%\";";
        try (
                PreparedStatement preStatement = DataBaseConnection.getInstance().getConnection().prepareStatement(query);
        ) {
            preStatement.setString(1,"Paris");
            ResultSet resultSet = preStatement.executeQuery();
            while (resultSet.next()) {
                System.out.print( resultSet.getInt("ADD_ID")+" ");
                System.out.print( resultSet.getString("ADD_CITY"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
