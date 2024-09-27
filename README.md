
# Simple Java HTTP Server

This is a simple HTTP server implemented in Java using the `com.sun.net.httpserver.HttpServer` class. The server listens on port 8000 and provides basic RESTful API endpoints.

## Features

- Handles HTTP methods like GET, POST, PUT, and DELETE.
- Provides simple API endpoints to demonstrate basic REST operations.
- Returns JSON data and plain text responses.

## Endpoints

### `/api/greet`
- **GET**: Returns a greeting message.
- **POST**: Responds with a message indicating that data has been posted.

### `/api/data`
- **GET**: Returns a JSON object with some data.
- **PUT**: Responds with a message indicating that data has been updated.
- **DELETE**: Responds with a message indicating that data has been deleted.

## Usage

1. **Clone the repository**:
    ```sh
    git clone https://github.com/your-username/SimpleHttpServer.git
    ```

2. **Compile the project**:
    ```sh
    javac -d out -sourcepath src src/org/example/SimpleHttpServer.java
    ```

3. **Run the server**:
    ```sh
    java -cp out org.example.SimpleHttpServer
    ```

4. **Test the API**:
    - Use a tool like `curl` or Postman to test the API endpoints.

    Example:
    ```sh
    curl -X GET http://localhost:8000/api/greet
    ```

    Expected output:
    ```
    Hello, welcome to the API!
    ```

## Project Structure

```
SimpleHttpServer/
│
├── src/
│   └── org/
│       └── example/
│           ├── SimpleHttpServer.java
│           └── MyHandler.java
│
├── out/
│   └── (compiled .class files will be here)
│
└── README.md
```

## License

This project is licensed under the MIT License.
