package codeCamp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/** Problem 6. Please note that to test this program, you need to write a simple client */
public class ServerProblem6 {
    public static int PORT = 8080;

    public void communicate() {
            // Need to do it the white loop
            // using try with resources - so all sockets will be closed automatically
            try (ServerSocket welcoming = new ServerSocket(PORT);
                 Socket connectionSocket = welcoming.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                 PrintWriter pw = new PrintWriter(connectionSocket.getOutputStream(),true)
            ) {

                    String line = in.readLine();
                    System.out.println("Client's request: " + line);

                    pw.println(line.length()); // send the length of the client's request to the client
//                    pw.flush();

            } catch (IOException e) {
                System.out.println(e);
            }

        }

        public static void main(String[] args) {
            ServerProblem6 s = new ServerProblem6();
            // single threaded in this simple example, runs in the main thread
            s.communicate();
        }
}


