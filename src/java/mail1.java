/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import connection.DataBaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.*;
import javax.mail.internet.*;
import javax.print.DocFlavor;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sluser
 */
@WebServlet(name = "mail1", urlPatterns = {"/mail1"})
public class mail1 extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String t = "";
        //String otp=null;


        try {
            String otp = request.getParameter("poli");
            final String username = "sangeethatriostech@gmail.com";
            final String password = "Sangi@trios";
            String key1 = null;
            Connection con;
            PreparedStatement psmt;
            Statement st, st2;
            ResultSet rs1, rs2;
            // Get system properties object
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/privacy", "root", "admin");
            st = con.createStatement();
            String q = "select key1 from imageuploadfolder where id='" + request.getParameter("id") + "'";
            rs1 = st.executeQuery(q);
            if (rs1.next()) {
                key1 = rs1.getString("key1");
            }
            st2 = con.createStatement();
            String q1 = "select mailid from userinsert where status='VERIFIED' and policy='" + otp + "'";
            rs2 = st2.executeQuery(q1);
           
            while (rs2.next()) {
                String email = rs2.getString("mailid");


                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.socketFactory.class",
                        "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "465");
                Session session1 = Session.getInstance(props, new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

                try {
                    HttpSession ses = request.getSession();
                    // String mail = (String) ses.getAttribute("mail");
                    Message message = new MimeMessage(session1);
                    message.setFrom(new InternetAddress(username));
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
                    message.setSubject("Your key");
                    message.setText(key1);
                    Transport.send(message);


                    // uploadimagefolder.jsp

                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Done");
            response.sendRedirect("viewuploadimagesshare.jsp");
        } catch (Exception e) {
            e.printStackTrace();
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