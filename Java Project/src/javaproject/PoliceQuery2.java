/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author Painmachine
 */
public class PoliceQuery2 {
    
    public static String ticketNumber ;
   public static  String trnNumber1;
    public static String badgeNumber;
    public static  String offenseNumber ;
    public static  String offenseName ;
    public static String dateofOffense ;
    public static String placeofOffense ;
    public static String descrip ;
    public static String fine;
    public static String points ;
    public static String paymentStatus ;                
    public static String Paid = "Not Paid";
    public static String trnNumber2 ;
    public static String title ;
    public static String firstName ;
    public static String middleInitial;
    public static String lastName ;
    public static String dateofBirth ;
    public static String Address1;
    public static String Address2 ;
    public static String telephone ;
    public static String licenseType ;
    public static String licensePoints ;
    public static String licenseExpiryDate ;
    
    public static  void Query2(String trn)
    {
        
                String ticket =  JOptionPane.showInputDialog("Enter Ticket Number to generate ticket."); 
                     
        
             
        String sql = "SELECT * FROM APP.TICKETS where APP.TICKETS.TICKET_NUMBER= " + ticket ;
        String sql1 = "SELECT * FROM APP.OFFENDER where APP.OFFENDER.TRN_NUMBER= " + trn ;
        
                
         
           
        try{
            
            
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();           
            Connection con= (Connection) DriverManager.getConnection("jdbc:derby://localhost:1527/Traffic Ticket System","Administrator","admin1234");
           /*As we are creating a connection on a local computer we will write the url as jdbc:mysql://localhost:3306 */
            
                    
            
            Statement stmt=(Statement) con.createStatement();
            Statement stmt1=(Statement) con.createStatement();
           
           // stmt.executeUpdate(sql1);
            ResultSet rs1 = stmt.executeQuery(sql); 
            ResultSet rs = stmt1.executeQuery(sql1); 
                      
            
            while (rs1.next())
            {
                
                 ticketNumber = rs1.getString("TICKET_NUMBER");
                 trnNumber1 = rs1.getString("TRN_NUMBER");
                 badgeNumber = rs1.getString("BADGE_NUMBER");
                 offenseNumber = rs1.getString("OFFENSE_NUMBER");
                 offenseName = rs1.getString("OFFENSE_NAME");
                 dateofOffense = rs1.getString("DATE_OF_OFFENSE");
                 placeofOffense = rs1.getString("PLACE_OF_OFFENSE");
                 descrip = rs1.getString("DESCRIPTION");
                 fine = rs1.getString("FINE");
                 points = rs1.getString("POINTS");
                 paymentStatus = rs1.getString("PAYMENT_STATUS");                
                //String Paid = "Not Paid";
                
                
                if (ticket.equals(ticketNumber))
                  {
                    int x=0;    
                  }
            }
            
            while (rs.next())
            {
                
                
                 trnNumber2 = rs.getString("TRN_NUMBER");
                 title = rs.getString("TITLE");
                 firstName = rs.getString("FIRST_NAME");
                 middleInitial = rs.getString("MIDDLE_INITIAL");
                 lastName = rs.getString("LAST_NAME");
                 dateofBirth = rs.getString("DATE_OF_BIRTH");
                 Address1 = rs.getString("ADDRESS1");
                 Address2 = rs.getString("ADDRESS2");
                 telephone = rs.getString("TELEPHONE");
                 licenseType = rs.getString("LICENSE_TYPE");
                 licensePoints = rs.getString("LICENSE_POINTS");
                 licenseExpiryDate = rs.getString("LICENSE_EXPIRYDATE");
                
                                              
                              
                                         
                
                if (trn.equals(trnNumber2))
                {
                    
                    int y = 1;
                }
                
                String name = "Traffic Ticket" + trn + ".pdf";
                
                OutputStream file = new FileOutputStream(name);

                Document document = new Document();
                PdfWriter.getInstance(document, file);
                document.open();

                document.add(new Paragraph("Traffic Ticket System Generated Ticket"));
                document.add(new Paragraph("TICKET_NUMBER : " + ticketNumber));
                document.add(new Paragraph("TRN_NUMBER : " + trnNumber1));
                document.add(new Paragraph("BADGE_NUMBER :" + badgeNumber));
                document.add(new Paragraph("OFFENSE_NUMBER :" + offenseNumber));
                document.add(new Paragraph("TITLE :" + title));
                document.add(new Paragraph("FIRST_NAME :" + firstName));
                document.add(new Paragraph("MIDDLE_INITIAL :" + middleInitial));
                document.add(new Paragraph("LAST_NAME :" + lastName));
                document.add(new Paragraph("DATE_OF_BIRTH :" + dateofBirth));
                document.add(new Paragraph("ADDRESS1 :" + Address1));
                document.add(new Paragraph("ADDRESS2 :" + Address2));
                document.add(new Paragraph("TELEPHONE :" + telephone));
                document.add(new Paragraph("LICENSE_TYPE :" + licenseType));
                document.add(new Paragraph("LICENSE_POINTS :" + licensePoints));
                document.add(new Paragraph("LICENSE_EXPIRYDATE :" + licenseExpiryDate));                    
                document.add(new Paragraph("OFFENSE_NAME :" + offenseName));
                document.add(new Paragraph("DATE_OF_OFFENSE :" + dateofOffense));
                document.add(new Paragraph("PLACE_OF_OFFENSE :" + placeofOffense));                    
                document.add(new Paragraph("DESCRIPTION :" + descrip));                    
                document.add(new Paragraph("FINE :" + fine));                    
                document.add(new Paragraph("POINTS DEDUCTION :" + points));                    
                document.add(new Paragraph("PAYMENT_SATUS :" + Paid));
                    
                    
                    

                document.addAuthor("Traffic Ticket System");
                document.addCreationDate();
                document.addCreator("iText library");
                document.addTitle("Traffic Ticket");
                    
                 
                document.close();
                file.close();
                
                                    
                JOptionPane.showMessageDialog(null,"The ticket has been generated.");
                
                 try {
 
		File pdfFile = new File(name);
		if (pdfFile.exists()) {
 
			if (Desktop.isDesktopSupported()) {
				Desktop.getDesktop().open(pdfFile);
			} else {
				JOptionPane.showMessageDialog(null,"Version of Pdf is not supported.");
			}
 
		} else {
			JOptionPane.showMessageDialog(null,"Pdf File does  not exists.");
		}
 
		 
	  } catch (Exception ex) {
		ex.printStackTrace();
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
