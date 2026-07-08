import java.sql.*;

public class TestDB {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "password";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Success!");

            Statement stmt = con.createStatement();

            String query =
                    "SELECT customer_name, city, total_purchase, " +
                    "DENSE_RANK() OVER(ORDER BY total_purchase DESC) AS purchase_rank " +
                    "FROM customers";

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("------ Palindrome Customer Report ------");

            while (rs.next()) {

                String name = rs.getString("customer_name");
                String city = rs.getString("city");
                int purchase = rs.getInt("total_purchase");
                int rank = rs.getInt("purchase_rank");

                if (isPalindrome(name)) {
                    System.out.println(
                            name + " | " +
                            city + " | " +
                            purchase + " | Rank : " + rank
                    );
                }
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isPalindrome(String str) {

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {

            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
