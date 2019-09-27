import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ebookstoreOptions {

	private static ebookstoreOptions options;

	private ebookstoreOptions() {
	}

	public static ebookstoreOptions getInstance() {

		if (options == null) {
			options = new ebookstoreOptions();
		}
		return options;
	}

	private static Connection getConnection() throws ClassNotFoundException, SQLException {

		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore?useSSL=false", "myuser", "2234xxZZ");
		return con;
	}

	// to insert a new book
	public int insert(int Identivication, String TitleName, String AuthorName, int amount) throws SQLException {
		Connection c = null;
		PreparedStatement ps = null;
		int recordCounter = 0;

		try {

			c = ebookstoreOptions.getConnection();
			ps = c.prepareStatement("insert into books(Id, Title, Author, Qty)values(?, ?, ?, ?)");
			ps.setInt(1, Identivication);
			ps.setString(2, TitleName);
			ps.setString(3, AuthorName);
			ps.setInt(4, amount);
			recordCounter = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (c != null) {
				c.close();
			}
		}

		return recordCounter;
	}

	// to update the chosen value of the book
	public int update() throws SQLException {
		Connection c = null;
		PreparedStatement ps = null;
		int recordCounter = 0;

		try {

			c = ebookstoreOptions.getConnection();
			Scanner sc = new Scanner(System.in);

			System.out.print("Please choose the Id of the book you want to update: ");
			int id = sc.nextInt();

			System.out.println("What value do you want to update? 1-Title, 2-Author, 3-Qty, 4-Id: \n ");
			int userChoice = sc.nextInt();

			if (userChoice == 1) {

				System.out.println("Please insert new Title! ");
				String TitleName = sc.next();
				ps = c.prepareStatement("update books set Title = ? where Id = ?");
				ps.setString(1, TitleName);
				ps.setInt(2, id);
				recordCounter = ps.executeUpdate();

			} else if (userChoice == 2) {

				System.out.println("Please insert new Author name! ");
				String AuthorName = sc.next();
				ps = c.prepareStatement("update books set Author = ? where Id = ?");
				ps.setString(1, AuthorName);
				ps.setInt(2, id);
				recordCounter = ps.executeUpdate();

			} else if (userChoice == 3) {

				System.out.println("Please insert new amount of books in store! ");
				int amount = sc.nextInt();
				ps = c.prepareStatement("update books set Qty = ? where Id = ?");
				ps.setInt(1, amount);
				ps.setInt(2, id);
				recordCounter = ps.executeUpdate();
				
			} else if (userChoice == 4) {

				System.out.println("Please insert new ID of book selected! ");
				int idNew = sc.nextInt();
				ps = c.prepareStatement("update books set Id = ? where Id = ?");
				ps.setInt(1, idNew);
				ps.setInt(2, id);
				recordCounter = ps.executeUpdate();	

			} else {
				System.out.println("Goodbye");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (ps != null) {
				ps.close();
			}
			if (c != null) {
				c.close();
			}
		}

		return recordCounter;
	}

	// to delete a chosen Book
	public int delete(int Identivication) throws SQLException {

		Connection c = null;
		PreparedStatement ps = null;
		int recordCounter = 0;

		try {
			c = ebookstoreOptions.getConnection();
			ps = c.prepareStatement("delete from books where Id = ?");
			ps.setInt(1, Identivication);
			recordCounter = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (c != null) {
				c.close();
			}
		}
		return recordCounter;
	}
}
