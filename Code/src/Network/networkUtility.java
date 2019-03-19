package Network;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;


public class networkUtility
{
    private static final int port = 80;
    private static final String host = "172.20.10.8";
    static Socket socket;
    static PrintWriter out;
    static BufferedReader in;

    private static networkUtility networkUtility;

    private networkUtility()
    {

    }

    public static networkUtility getInstance()
    {
        if(networkUtility == null)
        {
            networkUtility = new networkUtility();
        }

        return networkUtility;
    }



    public void connectToServer()
    {

        if(socket != null)
        {
            System.out.println("Already connected to server");
            return;
        }


        socket = new Socket();

        try {
            socket.connect(new InetSocketAddress(host, port), 5000);
        } catch (IOException e) {
            System.out.println("Failed to connect to host");
            return;
        }

        System.out.println("Connected to server\n");

        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {

            System.out.println("Failed to bind input and output streams");
        }


    }

    public String sendCommand(String message)
    {

        String response = "We did not get a request";

        if(socket == null)
        {
            return "Cannot send command until we connect to server";
        }


        out.println(message);


        try {

            response = in.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }


        return response;
    }

    public void closeServerConnection()
    {
        if(socket == null)
        {
            return;
        }

        out.close();
        out = null;

        System.out.println("\nClosed output stream");

        try {

            in.close();
            in = null;

        } catch (IOException e) {

            e.printStackTrace();
        }

        System.out.println("Closed input stream");


        try {
            socket.close();
            socket = null;
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Closed socket");
    }

}
