import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BalanceManager {
	
    public static int calculateBalance(String pinNumber) {
        int balance = 0;
        Conn connManager = new Conn();
        String query = "SELECT * FROM bank WHERE pinNumber=?";
        try (PreparedStatement statement = connManager.getC().prepareStatement(query)) {
            statement.setString(1, pinNumber);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle SQL exception
        }
        return balance;
    }
}
