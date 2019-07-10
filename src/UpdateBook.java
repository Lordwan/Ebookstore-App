import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateBook {

	{
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore?useSSL=false",
				"myuser", "2234xxZZ");

				Statement myStmt = conn.createStatement();) {

			Scanner sc = new Scanner(System.in);

			System.out.println("Please chooce the Id of the book you want to update: ");

			int Id = sc.nextInt();

			System.out.println("What value do you want to update? 1-Title, 2-Author, 3-Qty: \n ");
			int userChoice = sc.nextInt();
			
			Scanner sc1 = new Scanner(System.in);
			if (userChoice == 1) {

				System.out.println("whats the updated value ?");
				String userChoice1 = sc1.nextLine();

				String query1 = "update books set Title = ? where id = ?";
				PreparedStatement prep1 = conn.prepareStatement(query1);
				prep1.setString(1, userChoice1);
				prep1.setInt(2, Id);
			
				prep1.execute();

			} else if (userChoice == 2) {

				System.out.println("whats the updated value ?");
				String userChoice2 = sc1.nextLine();
				
				String query2 = "update books set Author = ? where id = ?";
				PreparedStatement prep2 = conn.prepareStatement(query2);
				prep2.setString(1, userChoice2);
				prep2.setInt(2, Id);

				prep2.execute();

			} else if (userChoice == 3) {

				System.out.println("whats the updated value ?");
				int userChoice3 = sc1.nextInt();
				
				String query3 = "update books set Author = ? where id = ?";
				PreparedStatement prep3 = conn.prepareStatement(query3);
				prep3.setInt(1, userChoice3);
				prep3.setInt(2, Id);

				prep3.execute();

			} else {
				System.out.println("Goodbye");
			}
			conn.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
}
