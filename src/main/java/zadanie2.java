import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Napisz program który dopisze do Produktów o id 1,3,5 frazę " - BRAK" do description -
 * skorzystaj z sparametryzowanego PreparedStatement. Wyświetl ile rekordów zostało zaktualizowanych
 * */
public class zadanie2 {
    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder(" ?");
        String questionMark = ",?";
        int[] tablica = new int[]{1,3,5};

        for (int i=1; i<tablica.length; i++) {
            stringBuilder.append(questionMark);
        }
        String query = "UPDATE PRODUCT " + "SET PRO_DESCRIPTION=CONCAT(PRO_DESCRIPTION, ?) " + "Where pro_id in ("+stringBuilder.toString()+")";

        try (PreparedStatement preStatement = DataBaseConnection.getInstance().getConnection().prepareStatement(query)){
            preStatement.setString(1, " - Brak");
            for (int i=0; i<tablica.length; i++){
                preStatement.setInt(i+2, tablica[i]);
            }
            int count = preStatement.executeUpdate();
            System.out.println("Zaktualizowano " + count + " wierszy");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
