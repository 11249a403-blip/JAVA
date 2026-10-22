import java.sql.*;

public class DeleteData {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/scsvmv_lab";
        String sql = "DELETE FROM student WHERE reg_no = ?";

        try (Connection con = DriverManager.getConnection(url, "root", "root");
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "103");

            int n = ps.executeUpdate();
            System.out.println(n + " row deleted.");

        } catch (SQLException e) {
            System.out.println("Database error : " + e.getMessage());
        }
    }
}

/*
OUTPUT:

1 row deleted.
*/
