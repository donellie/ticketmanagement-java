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
public class OffenderQuery {
    
    
    public static void Query(String h)    {
        
                
            String trn = h.toString();
             
        String sql = "SELECT * FROM APP.OFFENDER where APP.OFFENDER.TRN_NUMBER = " + trn ;
       
        try{
            
             Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();           
             Connection con= (Connection) DriverManager.getConnection("jdbc:derby://localhost:1527/Traffic Ticket System","Administrator","admin1234");
           
           /*As we are creating a connection on a local computer we will write the url as jdbc:mysql://localhost:3306 */
                      
            Statement stmt=(Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);           
             
                     
            
            while (rs.next())
            {
                String trnNumber = rs.getString("TRN_NUMBER");
                String title = rs.getString("TITLE");
                String firstName = rs.getString("FIRST_NAME");
                String middleInitial = rs.getString("MIDDLE_INITIAL");
                String lastName = rs.getString("LAST_NAME");
                String dateofBirth = rs.getString("DATE_OF_BIRTH");
                String Address1 = rs.getString("ADDRESS1");
                String Address2 = rs.getString("ADDRESS2");
                String telephone = rs.getString("TELEPHONE");
                String licenseType = rs.getString("LICENSE_TYPE");
                String licensePoints = rs.getString("LICENSE_POINTS");
                String licenseExpiryDate = rs.getString("LICENSE_EXPIRYDATE");
                
                                              
                              
                            //uname password
                if (trn.equals(trnNumber))
                {
                    JOptionPane.showMessageDialog(null, "TRN_NUMBER: " + trnNumber + "\nTITLE: " + title
                                                  + "\nFIRST NAME: " + firstName + "\nMIDDLE INITIAL: " + middleInitial
                        + "\nLAST NAME: " + lastName + "\nDATE_OF_BIRTH: " + dateofBirth +
                        "\nADDRESS1: " + Address1 + "\nADDRESS2: " + Address2 + 
                        "\nTELEPHONE: " + telephone + "\nLICENSE_TYPE: " + licenseType
                        + "\nLICENSE_POINTS: " + licensePoints + "\nLICENSE_EXPIRYDATE: " + licenseExpiryDate);            
                        
                }      
              
            }    
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(null,"Cannot connect you to the database. Make sure your entering the correct trn number. "
                   + "Please try again." );
             e.printStackTrace();
        }
    }
    
}
