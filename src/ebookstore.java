import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

class ebookstore {
	static int count = 1;
	static int userChoice;

	public static void main(String[] args) throws IOException, SQLException {

		ebookstoreOptions options = ebookstoreOptions.getInstance();

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore?useSSL=false", "myuser",
				"2234xxZZ");

		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println("Database Operations");
			System.out.println("-------------------");
			System.out.println("1 = Insert Book ");
			System.out.println("2 = Update Book ");
			System.out.println("3 = View Books ");
			System.out.println("4 = Delete Book ");
			System.out.println("5 = Exit ");

			System.out.println("\n");
			System.out.println("Please select a number of operation to perform: ");

			int userChoice = scanner.nextInt();
			switch (userChoice) {

			// Insert a new book
			case 1: {
				Scanner sc = new Scanner(System.in);

				System.out.print("Enter the Identification number! ");
				int id = sc.nextInt();

				sc.nextLine();
				System.out.print("Enter the Title of the book! ");
				String title = sc.nextLine();

				System.out.print("Enter the Authors Name! ");
				String author = sc.nextLine();

				System.out.print("Enter the amount in store! ");
				int amount = sc.nextInt();

				try {
					int i = options.insert(id, title, author, amount);
					if (i > 0) {
						count++;
						System.out.println("New book has been inserted successfully");
					} else {
						System.out.println("Data has not been inserted ");
					}

				} catch (Exception e) {
					System.out.println(e);
				}

				System.out.println("Press Enter to continue...");
				System.in.read();

			}
				break;

			// Update book
			case 2: {

				DBTablePrinter.printTable(conn, "books");

				try {
					int i = options.update();
					if (i > 0) {
						count++;
						System.out.println("Book was updated sucessfully");
					}

				} catch (Exception e) {
					System.out.println(e);
				}
				DBTablePrinter.printTable(conn, "books");
				System.out.println("Please press enter to continue...");
				System.in.read();
			}
				break;

			// View Book
			case 3: {

				try {
					DBTablePrinter.printTable(conn, "books");

				} catch (Exception e) {
					System.out.println(e);
				}
				System.out.println("Please press enter to continue...");
				System.in.read();
			}
				break;

			// Delete book
			case 4: {

				DBTablePrinter.printTable(conn, "books");
				System.out.print("Please choose the Id of book you want to delete: ");
				int id = scanner.nextInt();

				try {
					int i = options.delete(id);
					if (i > 0) {
						count++;
						System.out.println("Book has been deleted" + "\n");
						DBTablePrinter.printTable(conn, "books");
					} else {
						System.out.println("Book has not been deleted");
					}

				} catch (Exception e) {
					System.out.println(e);
				}
				System.out.println("Press Enter key to continue...");
				System.in.read();
			}
				break;

			default:
				return;
			}
		} while (userChoice != 4);
	}
}