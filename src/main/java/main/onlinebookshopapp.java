package main;
import java.sql.*;
import java.util.Scanner;

public class onlinebookshopapp {
    static final String URL = "jdbc:postgresql://localhost:5432/mydb";
    static final String USER = "postgres";
    static final String PASS = "shrutu";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            while (true) {
                System.out.println("\n====== ONLINE BOOKSHOP MENU ======");
                System.out.println("1. Add Author");
                System.out.println("2. Add Category");
                System.out.println("3. Add Book");
                System.out.println("4. Register User");
                System.out.println("5. View All Books");
                System.out.println("6. Place Order");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine(); // clear input buffer

                switch (choice) {
                    case 1:
                        System.out.print("Enter Author Name: ");
                        String authorName = sc.nextLine();
                        PreparedStatement ps1 = conn.prepareStatement("INSERT INTO Authors(name) VALUES(?)");
                        ps1.setString(1, authorName);
                        ps1.executeUpdate();
                        System.out.println("Author added.");
                        break;

                    case 2:
                        System.out.print("Enter Category Name: ");
                        String categoryName = sc.nextLine();
                        PreparedStatement ps2 = conn.prepareStatement("INSERT INTO Categories(name) VALUES(?)");
                        ps2.setString(1, categoryName);
                        ps2.executeUpdate();
                        System.out.println( "Category added.");
                        break;

                    case 3:
                        System.out.print("Enter Book Title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter Price: ");
                        double price = sc.nextDouble();
                        System.out.print("Enter Author ID: ");
                        int authorId = sc.nextInt();
                        System.out.print("Enter Category ID: ");
                        int categoryId = sc.nextInt();
                        sc.nextLine();

                        PreparedStatement ps3 = conn.prepareStatement(
                            "INSERT INTO Books(title, price, author_id, category_id) VALUES(?,?,?,?)");
                        ps3.setString(1, title);
                        ps3.setDouble(2, price);
                        ps3.setInt(3, authorId);
                        ps3.setInt(4, categoryId);
                        ps3.executeUpdate();
                        System.out.println("Book added.");
                        break;

                    case 4:
                        System.out.print("Enter User Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();
                        System.out.print("Enter Password: ");
                        String password = sc.nextLine();

                        PreparedStatement ps4 = conn.prepareStatement(
                            "INSERT INTO Users(name, email, password) VALUES(?,?,?)");
                        ps4.setString(1, name);
                        ps4.setString(2, email);
                        ps4.setString(3, password);
                        ps4.executeUpdate();
                        System.out.println("User registered.");
                        break;

                    case 5:
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(
                            "SELECT b.book_id, b.title, b.price, a.name AS author, c.name AS category " +
                            "FROM Books b JOIN Authors a ON b.author_id = a.author_id " +
                            "JOIN Categories c ON b.category_id = c.category_id");

                        System.out.println("\n Available Books:");
                        while (rs.next()) {
                            System.out.println("Book ID: " + rs.getInt("book_id") +
                                    ", Title: " + rs.getString("title") +
                                    ", Price: " + rs.getDouble("price") +
                                    ", Author: " + rs.getString("author") +
                                    ", Category: " + rs.getString("category"));
                        }
                        break;

                    case 6:
                        System.out.print("Enter User ID: ");
                        int userId = sc.nextInt();

                        PreparedStatement psOrder = conn.prepareStatement(
                            "INSERT INTO Orders(user_id) VALUES(?)", Statement.RETURN_GENERATED_KEYS);
                        psOrder.setInt(1, userId);
                        psOrder.executeUpdate();

                        ResultSet keys = psOrder.getGeneratedKeys();
                        keys.next();
                        int orderId = keys.getInt(1);

                        while (true) {
                            System.out.print("Enter Book ID to order (0 to finish): ");
                            int bookId = sc.nextInt();
                            if (bookId == 0) break;

                            System.out.print("Enter Quantity: ");
                            int quantity = sc.nextInt();

                            PreparedStatement psItem = conn.prepareStatement(
                                "INSERT INTO Order_Items(order_id, book_id, quantity) VALUES(?,?,?)");
                            psItem.setInt(1, orderId);
                            psItem.setInt(2, bookId);
                            psItem.setInt(3, quantity);
                            psItem.executeUpdate();
                        }

                        System.out.println("Order placed successfully.");
                        break;

                    case 7:
                        System.out.println("Exiting Bookshop...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}

