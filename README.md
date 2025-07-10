# 📚 Online Bookshop - Java Maven Project (JDBC + PostgreSQL)

This is a simple **menu-driven Java console application** that simulates an online bookshop. It allows you to manage authors, categories, books, and view book listings using JDBC and a PostgreSQL database.

---

_______________________________________________________________________________________________________________________________________________________________

## 📦 Project Structure

- **Maven project** with `pom.xml` for dependency management.
- Java source files:
  - `createtables.java` – Creates necessary tables in PostgreSQL.
  - `onlinebookshopapp.java` – Menu-driven application to manage bookshop operations.

---

___________________________________________________________________________________________________________________________________________________________________

## 🛠️ Technologies Used

- Java (JDK 11+)
- JDBC (Java Database Connectivity)
- PostgreSQL (Database)
- Maven (Build tool)

---
_____________________________________________________________________________________________________________________________________________________________


## 🗃️ Database Tables

- `users`
- `authors`
- `categories`
- `books`
- `orders`
- `order_items`

The initial version includes full functionality for managing:
- Authors
- Categories
- Books

(Users and orders can be added later.)

---

_________________________________________________________________________________________________________________________________________________________


## 🧰 Prerequisites

- JDK 11 or higher
- PostgreSQL installed and running
- Maven installed and configured
- Database `bookshop` created in PostgreSQL

---

___________________________________________________________________________________________________________________________________________________________

## ⚙️ Setup Instructions

### 1. 🔧 Configure PostgreSQL

- Create a PostgreSQL database:

```sql
CREATE DATABASE bookshop;
```

- Update database credentials in Java files:
  - `onlinebookshopapp.java`
  - `createtables.java`

_______________________________________________________________________________________________________________________________________________________________

```java
static final String DB_URL = "jdbc:postgresql://localhost:5432/mydb";
static final String USER = "postgres";
static final String PASS = "shrutu";
```

_________________________________________________________________________________________________________________________________________________________________

**🔧dependencies:**

 <dependencies>
   
        <!-- PostgreSQL JDBC Driver -->
        
        <dependency>
        
            <groupId>org.postgresql</groupId>
            
            <artifactId>postgresql</artifactId>
            
            <version>42.7.3</version> <!-- Use latest version available -->
            
        </dependency>
        
    </dependencies>

___________________________________________________________________________________________________________________________________________________________

### 2.📂 Project Directory Structure

project-root/

│

├── pom.xml

└── src/

    └── main/
    
        └── java/
        
            └── main/
            
                ├── createtables.java
                
                └── onlinebookshopapp.java

______________________________________________________________________________________________________________________________________                

### 3.📞Contact:
For any questions or feedback, feel free to reach out:

**Your Name :** shruti thorat

**Email:** shrutithorat767@gmail.com

**GitHub:** shruti-thorat0715

____________________________________________________________________________________________________________________________________________________________

### 4.📷ScreenShots of output:

![Screenshot (66)](https://github.com/user-attachments/assets/594772d3-ed58-48dd-a6b6-a148250f4716)


![Screenshot (67)](https://github.com/user-attachments/assets/46a37df0-0bdf-418c-bf3c-76daf7d46f5c)


![Screenshot (68)](https://github.com/user-attachments/assets/5e92e94e-9d20-4bda-87ba-24bde1fba924)

___

## Enjoy using the Online Book Shop!😊🚀


