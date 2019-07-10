import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EnterBook {

	{
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore?useSSL=false",
				"myuser", "2234xxZZ");

				Statement myStmt = conn.createStatement();) {

			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter a new Id for the Book! ");

			int Id = sc.nextInt();
			sc.nextLine();
			System.out.println("");
			
			System.out.println("Enter Title of the new book! ");
			
			String Title = sc.nextLine();
			System.out.println("");
			
			System.out.println("Who is the Author of the new book? ");
			
			String Author = sc.nextLine();
			System.out.println("");
			
			System.out.println("How many new books will be in stock? ");
			
			int Qty = sc.nextInt();
			sc.nextLine();

			String query = "insert into books(Id, Title, Author, Qty)" + " values (?, ?, ?, ?)"; 
			PreparedStatement prep1 = conn.prepareStatement(query);
			prep1.setInt(1, Id);
			prep1.setString(2, Title);
			prep1.setString(3, Author);
			prep1.setInt(4, Qty);
			
			prep1.execute();
			
			conn.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
}