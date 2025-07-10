# 📚 Online Bookshop - Java Maven Project (JDBC + PostgreSQL)

This is a simple **menu-driven Java console application** that simulates an online bookshop. It allows you to manage authors, categories, books, and view book listings using JDBC and a PostgreSQL database.

---

## 📦 Project Structure

- **Maven project** with `pom.xml` for dependency management.
- Java source files:
  - `createtables.java` – Creates necessary tables in PostgreSQL.
  - `onlinebookshopapp.java` – Menu-driven application to manage bookshop operations.

---

## 🛠️ Technologies Used

- Java (JDK 11+)
- JDBC (Java Database Connectivity)
- PostgreSQL (Database)
- Maven (Build tool)

---

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

## 🧰 Prerequisites

- JDK 11 or higher
- PostgreSQL installed and running
- Maven installed and configured
- Database `bookshop` created in PostgreSQL

---

## ⚙️ Setup Instructions

### 1. 🔧 Configure PostgreSQL

- Create a PostgreSQL database:

```sql
CREATE DATABASE bookshop;
```

- Update database credentials in Java files:
  - `onlinebookshopapp.java`
  - `createtables.java`

```java
static final String DB_URL = "jdbc:postgresql://localhost:5432/mydb";
static final String USER = "postgres";
static final String PASS = "shrutu";
```

2. 📂 Project Directory Structure

project-root/
│
├── pom.xml
└── src/
    └── main/
        └── java/
            └── main/
                ├── createtables.java
                └── onlinebookshopapp.java
