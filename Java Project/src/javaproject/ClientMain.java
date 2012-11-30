package javaproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.io.PrintWriter;

public class ClientMain 
{
                // Connection properties 
        private static final String HOST = "localhost"; 
        private static final int PORT = 56561; 

    
       public static void startClient(String trn , String Id)
        { 
        // Socket class used for TCP connections 
        Socket sock = null; 

        // I/O components 
        BufferedReader infromServer = null; 
        BufferedWriter outtoServer = null; 
        //BufferedWriter output2 = null;

        try { 
            // Connect our socket to the server. 
            sock = new Socket(HOST, PORT); 

            // Use a BufferedReader to read data from the server. 
            infromServer = new BufferedReader(new InputStreamReader(sock.getInputStream())); 

            // Use a BufferedWriter to send data to the server. 
            outtoServer = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream())); 
            //output2 = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));

            // Send some data to the server. 
            String toServer = trn; 
            String toServer2 = Id;
            String toServer3 = "10";
            System.out.println("ToServer: " + toServer + " " + toServer2 + " " + toServer3); 
            outtoServer.write(toServer); 
            outtoServer.newLine(); 
            outtoServer.write(toServer2); 
            outtoServer.newLine();
            outtoServer.write(toServer3); 
            outtoServer.newLine();
            outtoServer.flush(); 

            // Wait for a response from the server and display it. 
           

        } 
        catch (final IOException ex) 
        { 
            
        } 
        finally 
        { 
        // Do our best to ensure a clean close procedure. 
        // Closing the socket will also close infromServer and outtoServer. 
            try { 

                if (sock != null) 
                { 
                    
                    sock.close(); 
                } 
            } 
            catch (final IOException ex) { 
            } 
        } 
        } 
       
       public static void loginClient(String user , String pwd, String Id)
        { 
        // Socket class used for TCP connections 
        Socket sock = null; 

        // I/O components 
        BufferedReader infromServer = null; 
        BufferedWriter outtoServer = null; 
        //BufferedWriter output2 = null;

        try { 
            // Connect our socket to the server. 
            sock = new Socket(HOST, PORT); 

            // Use a BufferedReader to read data from the server. 
            infromServer = new BufferedReader(new InputStreamReader(sock.getInputStream())); 

            // Use a BufferedWriter to send data to the server. 
            outtoServer = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream())); 
            //output2 = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));

            // Send some data to the server. 
            String toServer = user; 
            String toServer2 = pwd;
            String toServer3 = Id;
            System.out.println("ToServer: " + toServer + " " + toServer2 + " " + toServer3); 
            outtoServer.write(toServer); 
            outtoServer.newLine(); 
            outtoServer.write(toServer2); 
            outtoServer.newLine();
            outtoServer.write(toServer3); 
            outtoServer.newLine();
            outtoServer.flush(); 

            // Wait for a response from the server and display it. 
            //String fromServer = infromServer.readLine(); 
            //System.out.println("FromServer: " + fromServer); 

        } 
        catch (final IOException ex) 
        { 
            
        } 
        finally 
        { 
        // Do our best to ensure a clean close procedure. 
        // Closing the socket will also close infromServer and outtoServer. 
            try { 

                if (sock != null) 
                { 
                    sock.close(); 
                } 
            } 
            catch (final IOException ex) { 
            } 
        } 
        } 
}
