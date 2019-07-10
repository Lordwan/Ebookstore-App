import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteBook {

	{
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore?useSSL=false",
				"myuser", "2234xxZZ");

				Statement myStmt = conn.createStatement();) {

			Scanner sc = new Scanner(System.in);

			System.out.println("Please chooce the Id of book you want to delete: ");

			int Id = sc.nextInt();

			String query = "delete from books where Id = ?";
			PreparedStatement prep1 = conn.prepareStatement(query);
			prep1.setInt(1, Id);

			prep1.execute();

			conn.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
}