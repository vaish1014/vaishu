/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author admin
 */
@WebServlet(name = "email", urlPatterns = {"/email"})
public class email extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
      public String extractFN(Part part) 
     {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
     public Boolean email(String to, String msg) throws AddressException,MessagingException
    {
                    boolean k;
                    final String username = "asoftware25@gmail.com";
                    final String password = "Admin.123";
                    Properties props = new Properties();
                    props.put("mail.smtp.user",username);  //props.put("mail.smtp.port", "25"); //props.put("mail.debug", "true"); 
                    props.put("mail.smtp.password", password);
                    props.put("mail.smtp.host","smtp.gmail.com"); 
                    props.put("mail.smtp.auth", "true"); 
                    props.put("mail.smtp.starttls.enable","true");  
                    props.put("mail.smtp.EnableSSL.enable","true");
                    props.put("mail.smtp.debug", "true");
                    props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");   
                    props.setProperty("mail.smtp.socketFactory.fallback", "false");   
                    props.setProperty("mail.smtp.port", "465");   
                    props.setProperty("mail.smtp.socketFactory.port", "465");      

                    Session mailSession = Session.getInstance(props,new javax.mail.Authenticator() {    
                        
                           protected PasswordAuthentication getPasswordAuthentication()
                           {    
                           return new PasswordAuthentication(username,password);  
                           }    
                          });//Get the Session object.
                        mailSession.getDebug();
                        Message message1 = new MimeMessage(mailSession);// Create a default MimeMessage object
                        message1.setFrom(new InternetAddress(username));// Set From: header field of the header.
                        message1.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
                        message1.setText(msg);// Now set the actual message  //message.setSubject("");// Set Subject: header field
                        Transport.send(message1);// Send message
    return true;
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
        
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
