# Java User Authentication System

A complete user registration and login system built with Java Swing and MySQL database. This application provides a secure and modern interface for user authentication with features including registration, login, and welcome dashboard.

## Features

- **User Registration**: Create new accounts with secure password handling
- **User Login**: Authenticate existing users with credentials verification
- **Modern UI**: Clean and intuitive Swing-based interface with animated backgrounds
- **Database Integration**: MySQL database for secure user data storage
- **Input Validation**: Comprehensive form validation for user inputs
- **Responsive Design**: Adaptable interface components

## Project Structure

```
Java-User-Authentication-System/
├── src/
│   ├── App.java                 # Main application entry point
│   ├── dao/
│   │   └── UserDAO.java        # Data Access Object for user operations
│   ├── database/
│   │   └── DBConnection.java   # Database connection management
│   ├── model/
│   │   └── User.java           # User entity model
│   ├── ui/
│   │   ├── Login.java          # Login interface
│   │   ├── createaccount.java  # Registration interface
│   │   └── Welcomepage.java    # Welcome dashboard
│   └── images/
│       └── background.png      # UI background image
├── bin/                         # Compiled class files
└── lib/                         # External dependencies
```

## Technology Stack

- **Language**: Java
- **UI Framework**: Java Swing
- **Database**: MySQL
- **IDE**: IntelliJ IDEA / VS Code

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- MySQL Server
- MySQL Connector/J driver
- IDE (IntelliJ IDEA, Eclipse, or VS Code with Java extensions)

## Database Setup

1. Install MySQL Server on your system
2. Create a database named `user_auth_db`
3. Create a `users` table with the following structure:

```sql
CREATE DATABASE user_auth_db;
USE user_auth_db;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

## Installation and Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/SMD-ASIF/UserRegLoginSystem.git
   cd UserRegLoginSystem
   ```

2. Configure database connection in `src/database/DBConnection.java`:
   ```java
   private static final String URL = "jdbc:mysql://localhost:3306/user_auth_db";
   private static final String USERNAME = "your_mysql_username";
   private static final String PASSWORD = "your_mysql_password";
   ```

3. Add MySQL Connector/J to your project's classpath or lib folder

4. Compile and run the application:
   ```bash
   javac -cp ".:lib/mysql-connector-j-x.x.x.jar" src/*.java
   java -cp ".:lib/mysql-connector-j-x.x.x.jar" App
   ```

## Usage

1. **Registration**: 
   - Click on "Create Account" button
   - Fill in the registration form with username, email, and password
   - Click "Register" to create your account

2. **Login**:
   - Enter your username and password
   - Click "Login" to access your account
   - Successful login redirects to the welcome page

3. **Welcome Page**:
   - Displays personalized welcome message
   - Access to user profile and settings

## Security Features

- Password encryption and secure storage
- Input validation to prevent SQL injection
- Proper database connection management
- Session management

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## Author

**SMD ASIF**
- GitHub: [@SMD-ASIF](https://github.com/SMD-ASIF)
- Email: smdasif1804@gmail.com

## Version History

- **v1.0.0** - Initial release with basic authentication features
- **v1.1.0** - Added modern UI with animated backgrounds
- **v1.2.0** - Enhanced security and database integration
