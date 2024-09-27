package org.example;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SimpleHttpServer {
    public static void main(String[] args) throws IOException {
        // Create an HTTP server on port 8000
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        // Define a context to handle requests at "/api/greet"
        server.createContext("/api/greet", new GreetHandler());

        // Define a context to handle requests at "/api/data"
        server.createContext("/api/data", new DataHandler());

        // Start the server
        server.setExecutor(null); // Creates a default executor
        server.start();

        System.out.println("Server is listening on port 8000");
    }
}

class GreetHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Determine the HTTP method used
        String method = exchange.getRequestMethod();

        // Prepare the response
        String response = "";

        switch (method) {
            case "GET":
                response = "Hello, welcome to the API!";
                exchange.sendResponseHeaders(200, response.length());
                break;
            case "POST":
                response = "Data has been posted successfully!";
                exchange.sendResponseHeaders(201, response.length());
                break;
            default:
                response = "Method not supported";
                exchange.sendResponseHeaders(405, response.length());
                break;
        }

        // Send the response body
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}

class DataHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Determine the HTTP method used
        String method = exchange.getRequestMethod();

        // Prepare the response
        String response = "";

        switch (method) {
            case "GET":
                response = "{\"data\": \"Here is some data\"}";
                exchange.getResponseHeaders().set("Content-Type", "application/json");
                exchange.sendResponseHeaders(200, response.length());
                break;
            case "PUT":
                response = "Data has been updated!";
                exchange.sendResponseHeaders(200, response.length());
                break;
            case "DELETE":
                response = "Data has been deleted!";
                exchange.sendResponseHeaders(200, response.length());
                break;
            default:
                response = "Method not supported";
                exchange.sendResponseHeaders(405, response.length());
                break;
        }

        // Send the response body
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}

