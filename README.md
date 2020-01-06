# EBOOKSTORE APP
This is a bookstore app using the jdbc plugin to create a sql database. Java definitions are then used to manipulate the bookstore as needed.
Credit given to #htorun for the DBTablePrinter.java program which prints the results in the console.

# -Step 1-

Download and install MySQL.
Create a project directory, for example: "c:\myProject".
Unzip the downloaded file into the newly created project directory, for example: "c:\myProject\mysql-5.7.{xx}-winx64".
Start a Command Prompt (as administrator) and enter the following commands:
```
} c:

} cd \myProject\mysql-5.7.21-winx64\bin

 ......

// Initialize the database. Create a root user without a password.
//Show the message on console

} mysqld -- initialize -- console

 ......
 
 ...... 
  
[Note] A temporary password is generated for root@localhost :
  xxxxxxxx
  
Remember and write down the password and shut down the terminal
```
# -Step 2-

Start a Command Prompt(as administrator) and enter the following:
```
} c:

} cd \myProject\mysql-5.7.21-winx64\bin

} mysqld --console

 ......
 
 ......
 
} XXXXXX XX:XX:XX [Note] mysqld: ready for connections.
  Version: '5.7.xx' socket: '' port: 3306 MySQL Community Server (GPL)
```
# -Step 3-

Start a new Command Prompt to run the client-side server, enter the following:
```
} cd \myProject\mysql-5.7.21-winx64\bin

} mysql -u root -p

} Enter password: "Enter root's password which was set during installation.

......

......

} Welcome to the MySQL monitor. Commands end with ; or \g.

} Your MySQL connection id is 1

} Server version: 5.1.39-community MySQL Community Server (GPL)

} Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

} mysql>

// When the Client has started, the prompt changes to "mysql>".
// You can now enter SQL commands.
```
# -Step 4-

Create a new database called 'ebookstore':
```
} mysql> create database if not exists ebookstore;

} Query OK, 1 row affected (0.08 sec)

Use "ebookstore" database as the default database

} mysql> use ebookstore;

} Database changed

Create a new table called "books" in "ebookstore",
with 4 columns of the specified types

} mysql> create table books (id int, Title varchar(50), Author varchar(50), Qty int);

} Query OK, 0 rows affected (0.15 sec)

Insert a row into the "books" table.
Strings are enclosed between single quotes.
There are no quotes for int and float values.

} mysql> insert into books values (3001, 'A Tale of Two Cities', 'Charles Dickens', 86);

} Query OK, 1 row affected (0.03 sec)
```
# -Step 5-

In your chosen java ide, open the ebookstore.java file.
In code lines 15-16 change the values of the connection conn to correspond with your newly created database, example:
```
} Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore?useSSL=false", "root",
                "xxxxxx");
                
//where xxxxx is password given at installation
```     
# -Step 6-

Run the program and enjoy functions like:

1 = Insert Book

2 = Update Book

3 = View Books

4 = Delete Book

5 = Exit
