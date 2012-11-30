package javaproject;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerMain 
{
	
    // Connection properties 
//    private static final int PORT = 56561;
//    ServerSocket server = null; 
//    
//
//   ServerMain() 
//    { 
//    // ServerSocket class used to accept TCP connections 
//        
//        
//    try { 
//    // Create our server on the given port. 
//         Main.getApplication().showLoginBox();
//    server = new ServerSocket(PORT); 
//    System.out.println("Server waiting for client on port " + server.getLocalPort());
//    
//    
//    while(true)
//    {
//    // Wait for a client to connect to us.
//        Socket sock = null;
//        sock = server.accept(); 
//       
//        TcpThread t = new TcpThread(sock);    // make a thread of it
//        t.start();
//
//    }
//    
//    
//
//    } catch (final IOException ex)
//    { 
//    } finally 
//    { 
//    // Do our best to ensure a clean close procedure. 
//    // Closing the socket will also close infromClient and outtoClient. 
//   
//    // Close the server socket, as well. 
//    try { 
//    if (server != null) { 
//    server.close(); 
//    } 
//    } catch (final IOException ex) { 
//    } 
//    } 
//    } 
//    
//    class TcpThread extends Thread 
//    {
//        // the socket where to listen/talk
//        Socket socket;
//        // I/O components 
//        BufferedReader infromClient = null; 
//        BufferedWriter outtoClient = null;
//        //BufferedReader input2 = null;
//
//        TcpThread(Socket socket)
//        {
//                this.socket = socket;
//        }
//        
//        public void run()
//        {
//            
//             
//             
//            try {
//                /* Creating both Data Stream */
//
//        // Use a BufferedReader to read data from the client. 
//        infromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        //input2 = new BufferedReader(new InputStreamReader(sock.getInputStream()));
//           
//            
//                // Use a BufferedWriter to send data to the client. 
//                outtoClient = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//           
//
//
//         // Wait for the client to talk to us. 
//        String fromClient = infromClient.readLine(); 
//        String fromClient2 = infromClient.readLine(); 
//        String fromClient3 = infromClient.readLine();
//
//        if (Integer.parseInt(fromClient3) == 6)
//        {
//            LoginQuery.Query(fromClient2,fromClient);
//        }
//        else if (Integer.parseInt(fromClient2) == 1 & Integer.parseInt(fromClient3) == 10)        
//        {    
//            OffenderQuery.Query(fromClient);  
//        }
//        else if (Integer.parseInt(fromClient2) == 2 & Integer.parseInt(fromClient3) == 10)
//        {
//            PoliceQuery.Query(fromClient);
//        }
//        else if(Integer.parseInt(fromClient2) == 3 & Integer.parseInt(fromClient3) == 10)
//        {
//             PoliceQuery2.Query2(fromClient);  
//        }
//        else if(Integer.parseInt(fromClient2) == 4 & Integer.parseInt(fromClient3) == 10)
//        {
//              TaxOfficeQuery2.Query2(fromClient);  
//        }
//        else if (Integer.parseInt(fromClient2) == 5 & Integer.parseInt(fromClient3) == 10)
//        {
//            TaxOfficeQuery.Query(fromClient);
//        }
//
//        System.out.println("FromClient: " + fromClient + " " + fromClient2); 
//            }
//        catch(IOException e)
//        {
//        
//        }
//        // Send them a response. 
//        String toClient = "Yes, I'm here, Client."; 
//        System.out.println("ToClient: " + toClient); 
//            try {
//                outtoClient.write(toClient);
//            } catch (IOException ex) {
//                Logger.getLogger(ServerMain.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            try {
//                outtoClient.newLine();
//            } catch (IOException ex) {
//                Logger.getLogger(ServerMain.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            try {
//                outtoClient.flush();
//            } catch (IOException ex) {
//                Logger.getLogger(ServerMain.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//}
//    
//            
////      public static void startServer()
////      {          
////          new ServerMain();
////       }
//       
//    public static void main(String [] args)
//    {
//        new ServerMain();
//          
//
//    }
    
    
         
    public static void startServer() throws IOException
    {
       
        //String capitalizedSentence;
        //Create a welcoming socket at port 6789
        
        ServerSocket welcomeSocket = new ServerSocket(56561);
        System.out.println("Server waiting for client on port " + welcomeSocket.getLocalPort());
        
        Main.getApplication().showLoginBox();
        //Wait on welcoming socket for contact by client
        while (true)
        {
            
            
            Socket connectionSocket = welcomeSocket.accept();
            
           
            //Create input stream attached to socket
            BufferedReader infromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            //Create output stream attached to socket
            BufferedWriter outtoClient = new BufferedWriter(new OutputStreamWriter(connectionSocket.getOutputStream()));
           
                
                String fromClient = infromClient.readLine(); 
                String fromClient2 = infromClient.readLine(); 
                String fromClient3 = infromClient.readLine();
                
                if (Integer.parseInt(fromClient3) == 6)
                {
                      LoginQuery.Query(fromClient2,fromClient);
                }
                else if (Integer.parseInt(fromClient2) == 1 & Integer.parseInt(fromClient3) == 10)        
                {    
                      OffenderQuery.Query(fromClient);  
                }
                else if (Integer.parseInt(fromClient2) == 2 & Integer.parseInt(fromClient3) == 10)
                {
                      PoliceQuery.Query(fromClient);
                }
                else if(Integer.parseInt(fromClient2) == 3 & Integer.parseInt(fromClient3) == 10)
                {
                      PoliceQuery2.Query2(fromClient);  
                }
                else if(Integer.parseInt(fromClient2) == 4 & Integer.parseInt(fromClient3) == 10)
                {
                      TaxOfficeQuery2.Query2(fromClient);  
                }
                else if (Integer.parseInt(fromClient2) == 5 & Integer.parseInt(fromClient3) == 10)
                {
                      TaxOfficeQuery.Query(fromClient);
                }
               
                //outtoclient.write("Processed.");
                //outtoclient.newLine();
                outtoClient.flush();
            
            
        }//End of the while loop, loop back and wait for another client connection
    }

        
}