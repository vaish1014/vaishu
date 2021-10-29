    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package privacy.image.user;
import connection.DataBaseConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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

@WebServlet("/UploadImage")
@MultipartConfig(maxFileSize = 16177215)
public class UploadImage extends HttpServlet 
{
    private String message;
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // gets values of text fields

        String imagename = request.getParameter("imagename");
        String file = request.getParameter("file");
        String key = request.getParameter("key");
        String policy = request.getParameter("policy");
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
        String filename = getFileName(filePart);

        try {
            DataBaseConnection db12 = new DataBaseConnection();
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/privacy", "root", "admin");

            ResultSet rs = null;
            rs = db12.Select("select imagename from imageupload where imagename='" + imagename + "'");
            if (rs.next()) {
                session.setAttribute("msg", "Image Already Exist!");
                response.sendRedirect("uploadimages.jsp");
            } else {
                String sql = "INSERT INTO imageupload(policy,imagename,file,key1) values(?,?,?,?)";
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1, policy);
                statement.setString(2, filename);
                statement.setString(3, file);

                if (inputStream != null) {
                    // fetches input stream of the upload file for the blob column
                    statement.setBlob(3, inputStream);

                }
                statement.setString(4, key);
                // sends the statement to the database server
                int row = statement.executeUpdate();
                if (row > 0) {


                    session.setAttribute("msg", "Successfully Uploaded");
                    response.sendRedirect("uploadimages.jsp");
                } else {
                    session.setAttribute("msg", "Database Error");
                    response.sendRedirect("uploadimages.jsp");
                }
            }

        } catch (SQLException ex) {
           PrintWriter pw=response.getWriter();
           pw.print(ex);
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UploadImage.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
        // sets the message in request scope
        request.setAttribute("Message", message);

    }

    private String getFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim()
                        .replace("\"", "");
            }
        }
        return null;
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
