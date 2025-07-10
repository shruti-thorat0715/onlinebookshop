package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class createtables {
    static final String URL = "jdbc:postgresql://localhost:5432/mydb";
    static final String USER = "postgres";
    static final String PASS = "shrutu";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            Statement stmt = conn.createStatement();

            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Authors (" +
                    "author_id SERIAL PRIMARY KEY," +
                    "name VARCHAR(100) NOT NULL);");

            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS Categories ("+
                    "category_id SERIAL PRIMARY KEY,"+
                   " name VARCHAR(100) NOT NULL);");

            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS Users ("+
                    "user_id SERIAL PRIMARY KEY,"+
                   " name VARCHAR(100) NOT NULL,"+
                    "email VARCHAR(100) UNIQUE NOT NULL,"+
                    "password VARCHAR(100) NOT NULL);");

            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS Books ("+
                    "book_id SERIAL PRIMARY KEY,"+
                   " title VARCHAR(200) NOT NULL,"+
                   " price DECIMAL(10,2) NOT NULL,"+
                    "author_id INT REFERENCES Authors(author_id) ON DELETE CASCADE,"+
                    "category_id INT REFERENCES Categories(category_id) ON DELETE CASCADE);");

            stmt.executeUpdate(
               " CREATE TABLE IF NOT EXISTS Orders ("+
                   " order_id SERIAL PRIMARY KEY,"+
                   " user_id INT REFERENCES Users(user_id) ON DELETE CASCADE,"+
                    "order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP);");

            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS Order_Items ("+
                    "item_id SERIAL PRIMARY KEY,"+
                    "order_id INT REFERENCES Orders(order_id) ON DELETE CASCADE,"+
                   "book_id INT REFERENCES Books(book_id) ON DELETE CASCADE,"+
                    "quantity INT NOT NULL);");

            stmt.close();
            System.out.println(" All tables created successfully.");
            System.out.println("databse connected successfully.");
        } catch (SQLException e) {
            System.out.println(" Error creating tables: " + e.getMessage());
        }
    }
}
