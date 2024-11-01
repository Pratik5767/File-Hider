# File Hider

File Hider is a simple Java application that provides a secure way to hide, unhide, and manage files with login and signup functionalities. Users can securely log in to the application and hide or unhide files as needed. Additionally, the application provides a view of the number of hidden and unhidden files for easy file management.

## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Installation](#installation)
- [Usage](#usage)
- [Database Structure](#database-structure)

## Features

- **Hide a File**:
  - Hide any file from the file system, making it invisible to standard views.
- **Unhide a File**:
  - Restore visibility for previously hidden files.
- **File Count**:
  - Check the count of currently hidden and unhidden files.
- **User Authentication**:
  - **Sign Up**: Register a new account with OTP verification.
  - **Login**: Log in securely with valid credentials and OTP.
  
## Tech Stack

- **Core Java**: Used to implement the main logic and UI.
- **JDBC**: For database connectivity and executing SQL queries.
- **MySQL**: Used for storing user data and file records.

## Key Concepts

1. **File Management**:
   - Hiding and unhiding files is achieved through custom Java logic that modifies file properties to manage their visibility.
2. **User Authentication**:
   - An OTP-based sign-up system ensures secure and verified account creation.
   - User data is securely stored in MySQL.
3. **Database Management**:
   - Track hidden and unhidden files, as well as user credentials, through a MySQL database.

## Installation

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- MySQL server installed and running
- An IDE or text editor (e.g., IntelliJ IDEA, Eclipse, VS Code)

### Steps

1. Clone the repository:
   
   ```bash
   git clone https://github.com/yourusername/file-hider.git
   cd file-hider
   ```

2. Set up MySQL database and tables using the SQL scripts provided in the db folder.

3. Configure database credentials in the application's configuration file.

4. Run the application using your IDE.

## Usage

1. **Sign Up**:
   - Users must sign up by providing their credentials. An OTP will be generated for verification.
2. **Login**:
   - Log in using valid credentials.
3. **Hide a File**:
   - Choose a file to hide, and the application will securely conceal it from standard access.
4. **Unhide a File**:
   - Choose a hidden file to make it visible again.
5. **View File Count**:
   - Track how many files are currently hidden or visible.
  
## Database Structure

1. **Users Table**:
   - Stores user credentials and OTPs.
2. **Files Table**:
   - Tracks files hidden and their states (hidden or unhidden).   
