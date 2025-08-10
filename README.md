# 💳 ATM Simulator App — Java Swing + MySQL

A fully functional **ATM Simulator** desktop application built using **Java Swing** for the GUI and **MySQL** for persistent data storage.  
This project replicates core ATM functionalities like deposits, withdrawals, fast cash, mini statements, balance enquiry, and PIN change.

---

## 🚀 Features

- **User Authentication** — Secure login using PIN.
- **Multi-step Sign-Up Form** — For new users to register.
- **Deposit & Withdrawal** — Handles transaction logic with proper validation.
- **Fast Cash** — Predefined quick withdrawal options.
- **Mini Statement** — Displays recent transactions in a clean format.
- **Balance Enquiry** — Shows current account balance instantly.
- **PIN Change** — Allows secure PIN updates.
- **Database Integration** — Persistent storage of user and transaction data.

---

## 🛠 Tech Stack

- **Java** (Swing, AWT, JDBC)
- **MySQL** (Relational Database)
- **JDBC Driver** for database connectivity

---

## ⚙️ Setup Instructions

### 1️⃣ Prerequisites
- **Java JDK** (version 8 or higher)
- **MySQL Server** installed and running
- **MySQL JDBC Driver** added to your classpath

## 📦 Database Setup

1. Ensure you have **MySQL** installed and running on your system.
2. Create a new database for the Bank Management System:
   ```sql
   CREATE DATABASE bankmanagementsystem;
3. Import the provided SQL file to set up tables and initial data:
- Open MySQL Workbench or command line.

- Run the following command (update the path if needed):

```bash
mysql -u your_username -p bankmanagementsystem < "E:\Documents\bankmanagementsystem.sql"
```
- Replace your_username with your MySQL username.

## ▶️ Running the Application
- Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse, or NetBeans).

- Ensure you have added the MySQL JDBC driver to your project’s classpath.

- Update the database connection details in the Conn.java file:
```java
String url = "jdbc:mysql://localhost:3306/bankmanagementsystem";
String user = "your_username";
String password = "your_password";
```
- Build and run the project from your IDE or use the terminal:

```bash
javac *.java
java MainClassName
```
(Replace MainClassName with the main file of your application)

---

## 🎯 Learning Outcomes

Through this project, you will gain hands-on experience in:
- Building Java Swing GUI desktop applications.
- Designing intuitive UIs with **Swing** and **AWT**.
- Handling user interactions with **ActionListener**.
- Performing **CRUD** operations with MySQL using JDBC.
- Structuring Java projects with **OOP principles**.
- Connecting frontend and backend for desktop software.

---

## 📬 Contact


- **Name:** Ekta Naresh Chandak  
- **Email:** [ektachandak.edu@gmail.com](mailto:ektachandak.edu@gmail.com)  


---
