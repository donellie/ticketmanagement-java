/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author Painmachine
 */
public class TaxOfficeQuery {
    
    public static void Query(String badgeNumber)
    {
        
            //String trn = message.toString();
             
             String sql = "SELECT * FROM APP.POLICE_TABLE where APP.POLICE_TABLE.BADGE_NUMBER = " + badgeNumber ;     
       
        try{
            
            
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();           
            Connection con= (Connection) DriverManager.getConnection("jdbc:derby://localhost:1527/Traffic Ticket System","Administrator","admin1234");
           /*As we are creating a connection on a local computer we will write the url as jdbc:mysql://localhost:3306 */
            
                    
            
            Statement stmt=(Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);           
             
           
            
            
            while (rs.next())
            {
                String badgeNum = rs.getString("BADGE_NUMBER");
                String title = rs.getString("TITLE");
                String firstName = rs.getString("FIRST_NAME");
                String middleInitial = rs.getString("MIDDLE_INITIAL");
                String lastName = rs.getString("LAST_NAME");
                String dateofBirth = rs.getString("DATE_OF_BIRTH");
                String Address1 = rs.getString("ADDRESS1");
                String Address2 = rs.getString("ADDRESS2");
                String telephone = rs.getString("TELEPHONE");             
                
                                                
                              
                            //uname password
                if (badgeNumber.equals(badgeNum))
                {
                    JOptionPane.showMessageDialog(null, "BADGE_NUMBER: " + badgeNum + "\nTITLE: " + title
                                                  + "\nFIRST NAME: " + firstName + "\nMIDDLE INITIAL: " + middleInitial
                        + "\nLAST NAME: " + lastName + "\nDATE_OF_BIRTH: " + dateofBirth +
                        "\nADDRESS1: " + Address1 + "\nADDRESS2: " + Address2 + 
                        "\nTELEPHONE: " + telephone);            
                    JOptionPane.showMessageDialog(null,"The record has been updated. Close module and click the refersh button.");      
                }      
               
            }    
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(null,"Cannot connect you to the database. Make sure your entering the correct badge number. "
                   + "Please try again." );
             e.printStackTrace();
        }
    }
    
}
