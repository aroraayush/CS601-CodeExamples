package sockets;

import java.io.*;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Original author: Prof. Rollins. Modified by O. Karpenko.
 * HttpFetcher - shows how to sent an HTTP get request to a given webserver via the java program,
 * and how to get the response
 *
 */
public class HttpFetcher {

    public static int PORT = 80;

    /**
     * A method that creates a GET request for the given host and resource
     * @param host
     * @param pathResourceQuery
     * @return HTTP GET request returned as a string
     */
    private static String createRequestString(String host, String pathResourceQuery) {

        String request = "GET " + pathResourceQuery + " HTTP/1.1" + System.lineSeparator() // GET
                // request
                + "Host: " + host + System.lineSeparator() // Host header required for HTTP/1.1
                + "Connection: close" + System.lineSeparator() // make sure the server closes the
                // connection after we fetch one page
                + System.lineSeparator();
        return request;
    }

    /** Sends an HTTP request to fetch a given resource from the given host.
     *  Returns the response as a string.
     * @param host
     * @param pathAndResource
     * @return A string that contains HTML code.
     */
    public static String fetch(String host, String pathAndResource) {

        StringBuffer sb = new StringBuffer();

        // create a connection to the
        // web server
        try (Socket socket = new Socket(host, PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
                                                                // wrap the input stream to make it easier to read from
            OutputStream out = socket.getOutputStream(); // get the output stream from socket

            String request = createRequestString(host, pathAndResource); // // create and send request
            System.out.println("Request = " + request);
            out.write(request.getBytes());
            out.flush();

            // receive response
            // note: we are not removing the header (as we should have!)
            String line;
            while ((line = in.readLine()) != null) {
                // StringBuffer
                sb.append(line + System.lineSeparator());
            }

        } catch (IOException e) {
            System.out.println("HTTPFetcher::IOException occured during download: " + e.getMessage());
        }
        return sb.toString(); // all HTML code is in this string

    }

    /**
     * A method that creates a GET request for the given host and resource
     * @param host
     * @param pathResourceQuery
     * @return HTTP GET request returned as a string
     */
    private static String getRequest(String host, String pathResourceQuery) {
        String request = "GET " + pathResourceQuery + " HTTP/1.1" + System.lineSeparator() // GET
                // request
                + "Host: " + host + System.lineSeparator() // Host header required for HTTP/1.1
                + "Connection: close" + System.lineSeparator() // make sure the server closes the
                // connection after we fetch one page
                + System.lineSeparator();
        return request;
    }

    public static void main(String[] args) {

        // Use HttpFetcher to fetch ArrayList page from Java API
        //String res = HttpFetcher.fetch("docs.oracle.com", "/javase/8/docs/api/java/util/ArrayList.html");
        String res = HttpFetcher.fetch("www.example.com", "/");
        System.out.println(res);

    }
}