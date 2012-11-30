/*
 * Main.java
 */

package javaproject;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.ws.Action;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class Main extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        //show(new JavaProjectView(this));
        
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of Main
     */
    public static Main getApplication()
    {
        return Application.getInstance(Main.class);
        
        
    }
   private JDialog LoginBox;
    
    
    @Action
    public void showLoginBox() 
    {
        
        
        if (LoginBox == null) {
            JFrame mainFrame = Main.getApplication().getMainFrame();
            LoginBox = new Login(mainFrame);
            LoginBox.setLocationRelativeTo(mainFrame);
        }
        
         
         Main.getApplication().show(LoginBox);
        
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) throws Exception
    {              
             ServerMain.startServer();
    } 
}

	


