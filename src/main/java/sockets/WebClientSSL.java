package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/**
 * Shows how to write a WebClient that can send a GET request to googleapis.com
 * (Geocode API ) that uses https. Modified from the example at:
 * http://www.jguru.com/faq/view.jsp?EID=32388
 * Note: before you run the code, you'd get an API key:
 * https://developers.google.com/maps/documentation/geocoding/start
 * You need to create a billing account, but Google Maps Platform has a free trial period.
 */
public class WebClientSSL {

    /**
     * Creates a secure socket to communicate with googleapi's server that
     * provides geocode API, sends a GET request, and gets a response as a
     * string. The header of the response is not removed in this example."
     *
     * @return A String of the response.
     */
    public static String callGeocodeAPI() {
        String response = "";

        // let's say we want to find out USF's coordinates:
        String urlString = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=tourist%20attractions+in+Emeryville&location=37.837773,-122.298142&radius=321&key=AIzaSyBovD9ARF-Yx7vpLHUO9WLP-KpciLhy32A";
//        String urlString = "https://maps.googleapis.com/maps/api/geocode/json?address=University%20of%20San%20Francisco,%20US&key=AIzaSyBovD9ARF-Yx7vpLHUO9WLP-KpciLhy32A";
        // IMPORTANT: before running this code, get an API key and append it to this urlString
        // &key=YouAPIKeyHere
        // When I showed you this example in class, I used my own API key, but deleted it before posting this example.
        URL url;
        PrintWriter out = null;
        BufferedReader in = null;
        SSLSocket socket = null;
        // An SSLSocketFactory create SSLSockets
        try {
            url = new URL(urlString);

            // public abstract class SSLSocketFactory extends SocketFactoryx
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();

            // HTTPS uses port 443
            socket = (SSLSocket) factory.createSocket(url.getHost(), 443);

            // output stream for the secure socket
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
            String request = getRequest(url.getHost(), url.getPath() + "?" + url.getQuery());
            System.out.println("Request: " + request);

            out.println(request); // send a request to the server

            // input stream for the secure socket.
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // use input stream to read server's response
            String line;
            StringBuffer sb = new StringBuffer();
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                sb.append(line);
            }
            response = sb.toString();
        } catch (IOException e) {
            System.out.println(
                    "An IOException occured while writing to the socket stream or reading from the stream: " + e);
        } finally {
            try {
                // close the streams and the socket
                out.close();
                in.close();
                socket.close();
            } catch (IOException e) {
                System.out.println("An exception occured while trying to close the streams or the socket: " + e);
            }
        }

        return response;

    }

    /**
     * Takes a host and a string containing path/resource/query and creates a
     * string of the HTTP GET request
     *
     * @param host
     * @param pathResourceQuery
     * @return
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
        String jsonResult = callGeocodeAPI();
        System.out.println(jsonResult);
    }
}
