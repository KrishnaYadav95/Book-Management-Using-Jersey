
# Book Management System Using Jersey

A simple RESTful Book Management application built with **Jersey (JAX-RS)**, Maven, and MySQL. It provides CRUD operations for managing books via a REST API, along with a clean browser-based frontend for easy interaction.

## Features

- **REST API Endpoints** (using Jersey 3.x):
  - `PUT /api/books/uploadbookbyid` - Add or update a book (upsert)
  - `POST /api/books/uploadbyname` - Add a book by name
  - `PUT /api/books/update/{BookNumber}` - Update a book
  - `DELETE /api/books/delete/{BookNumber}` - Delete a book
  - `GET /api/books/Allbooks` - Retrieve all books
  - `GET /api/books/onebook/{BookNumber}` - Get a book by ID

- **Technologies**:
  - Java 17
  - Jersey 3.1.3 (JAX-RS implementation)
  - Jackson for JSON
  - JAXB for XML support
  - MySQL Connector
  - Maven

- **Frontend**: Modern, responsive single-page HTML interface (`BookManager.html`) with JavaScript fetch calls.

## Project Structure

```
BookManagement_Jersey/
├── pom.xml
├── src/
│   └── main/
│       ├── java/
│       │   └── com/krishna/
│       │       ├── BookModel.java          # Book entity (POJO with JAXB)
│       │       ├── BookResource.java       # Jersey REST resource
│       │       └── BookRepository.java     # MySQL data access layer
│       ├── webapp/
│       │   ├── BookManager.html            # Main UI
│       │   ├── index.jsp
│       │   └── WEB-INF/
│       │       └── web.xml                 # Jersey servlet configuration
│       └── resources/
└── target/                                 # Compiled artifacts
```

## Prerequisites

1. **Java 17** or higher
2. **Apache Tomcat** (recommended 10.x)
3. **MySQL** server running
4. **Maven**

## Database Setup

Create a MySQL database and table:

```sql
CREATE DATABASE bookDb;
USE bookDb;

CREATE TABLE book (
    BookNumber INT PRIMARY KEY,
    BookName VARCHAR(255) NOT NULL,
    Author VARCHAR(255) NOT NULL
);
```

Update credentials in `BookRepository.java` if needed (default: `root` / `12345678`).

## How to Run

1. **Clone the repository**:
   ```bash
   git clone https://github.com/KrishnaYadav95/Book-Management-Using-Jersey.git
   cd Book-Management-Using-Jersey/BookManagement_Jersey
   ```

2. **Build the project**:
   ```bash
   mvn clean package
   ```

3. **Deploy to Tomcat**:
   - Copy `target/Jersey_Demo.war` to Tomcat's `webapps/` folder
   - Or deploy directly via Tomcat Manager

4. **Start Tomcat** (usually on port 8080 or 8088)

5. **Open the UI**:
   - Navigate to: `http://localhost:8080/BookManagement_Jersey/BookManager.html` (adjust port/context as needed)

## API Usage Examples

### Get All Books
```http
GET http://localhost:8080/BookManagement_Jersey/api/books/Allbooks
```

### Add/Update Book
```http
PUT http://localhost:8080/BookManagement_Jersey/api/books/uploadbookbyid
Content-Type: application/json

{
  "bookNumber": 101,
  "bookName": "Clean Code",
  "author": "Robert C. Martin"
}
```

## Technologies Used

- **Backend**: Jersey + JAX-RS
- **Database**: MySQL
- **Build Tool**: Maven
- **Frontend**: HTML5 + CSS + Vanilla JavaScript

## Future Improvements

- Add proper exception handling and validation
- Implement authentication
- Add more comprehensive testing
- Docker support
- Swagger/OpenAPI documentation

---

**Made with ❤️ using Jersey**

Feel free to contribute or raise issues!
