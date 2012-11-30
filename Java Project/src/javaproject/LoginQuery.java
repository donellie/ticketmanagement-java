/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Painmachine
 */
public class LoginQuery {    
   
    
    public static void Query(String pwd, String user)
    {
        String sql="Select BADGE_NUMBER,FIRST_NAME from APP.POLICE_TABLE";                
                        
        try 
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();           
            Connection con= (Connection) DriverManager.getConnection("jdbc:derby://localhost:1527/Traffic Ticket System","Administrator","admin1234");
            /*As we are creating a connection on a local computer we will write the url as jdbc:mysql://localhost:3306 */
            
            Statement stmt=(Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            
            
            while(rs.next())
            {   
                
                String uname=rs.getString("FIRST_NAME");
                //Username is the coloumn name in the database table 
                String password=rs.getString("BADGE_NUMBER");
                
                            //uname password
                if ((user.equals(uname)) && (pwd.equals(password)))
                {
                    JOptionPane.showMessageDialog(null, "Your credentials are approved. Welcome to the system officer: " + uname);
                    
                    
                    JFrame frame = new JFrame();
                    frame.setContentPane(new OffenderForm());
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    frame.setTitle("Traffic Ticket System - Police Office Module :" + user);
                    frame.pack();
                    frame.setVisible(true); 
                   
                    
                }
                else if ((user.equals("TaxOfficer")) && (pwd.equals("tax1234")))
                {
                    JOptionPane.showMessageDialog(null, "Welcome to the system " + user);
                    //dispose(); 

                    JFrame frame = new JFrame();
                    frame.setContentPane(new TicketForm());
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    frame.setTitle("Traffic Ticket System - Tax Office Module :" + user);
                    frame.pack();
                    frame.setVisible(true);   
                    break;
                }
                else if ((user.equals("Admin")) && (pwd.equals("admin1234")))
                {
                    JOptionPane.showMessageDialog(null, "Welcome to the system " + user);
                    //dispose(); 

                    JFrame frame = new JFrame();
                    frame.setContentPane(new PoliceForm());
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    frame.setTitle("Traffic Ticket System - Data Management Module :" + user);
                    frame.pack();
                    frame.setVisible(true);   
                    break;
                }                             
             
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Cannot connect you to the database. Make sure your entering the correct credentials. "
                    + "Please try again." + e.getMessage());
            
        }
        
    }
    
}
