import java.sql.*;
import java.util.Scanner;

public class ebookstore {

	private static int userChoice = 0;

	public static void main(String[] args) throws SQLException {

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore?useSSL=false", "myuser",
				"2234xxZZ");

		DBTablePrinter.printTable(conn, "books");

		System.out.println(
				"Please choose the number of option you want:\n 1-ENTER BOOK\n 2-UPDATE BOOK\n 3-DELETE BOOK\n 0-EXIT\n");
		Scanner scanner = new Scanner(System.in);
		userChoice = scanner.nextInt();
		System.out.println(userChoice);

		if (userChoice == 1) {
			EnterBook myEnter = new EnterBook();
		} else if (userChoice == 2) {
			UpdateBook myUpdate = new UpdateBook();
		} else if (userChoice == 3) {
			DeleteBook myDelete = new DeleteBook();
		} else {
			System.out.println("Thanks for using ebookstore, see you soon!!");
		}

		DBTablePrinter.printTable(conn, "books");
	}
}