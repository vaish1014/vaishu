/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package privacy.image.user;

import connection.DataBaseConnection;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author chiranjeevi
 */
@WebServlet("/Search")
@MultipartConfig(maxFileSize = 16177215)
public class Search extends HttpServlet {

    private String message;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // gets values of text fields
        
        String imagename = request.getParameter("imagename");
        
        Connection con = null;
        InputStream inputStream = null; // input stream of the upload file
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("file");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
        HttpSession session = request.getSession(true);

        try {
            DataBaseConnection db12 = new DataBaseConnection();
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/privacy", "root", "admin");

            ResultSet rs = null;
            rs = db12.Select("select imagename,username from imageupload where imagename='" + imagename + "'");
            if (rs.next()) 
            {
                session.setAttribute("msg", "Image Name Already Exist Please Use different Name !");
                response.sendRedirect("uploadimages.jsp");
            }             

        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UploadImage.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
        // sets the message in request scope
        request.setAttribute("Message", message);

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }
}
