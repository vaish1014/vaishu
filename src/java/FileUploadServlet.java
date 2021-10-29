import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/FileUploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
             maxFileSize=1024*1024*10,      // 10MB
             maxRequestSize=1024*1024*50)

public class FileUploadServlet extends HttpServlet {
private static final String SAVE_DIR="images";
 /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
        String savePath = "C:" + File.separator + SAVE_DIR;
            File fileSaveDir=new File(savePath);
            if(!fileSaveDir.exists()){
                fileSaveDir.mkdir();
            }
        String firstName=request.getParameter("firstname");
        String lastName=request.getParameter("lastname");
        Part part=request.getPart("file");
        String fileName=extractFileName(part);
        part.write(savePath + File.separator + fileName);
       /* 
        //You need this loop if you submitted more than one file 
        for (Part part : request.getParts()) {
        String fileName = extractFileName(part);
        part.write(savePath + File.separator + fileName);
    }*/
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/privacy","root","admin");
        String query="INSERT INTO uploadfile (first_name, last_name, file) values (?, ?, ?)";

            PreparedStatement pst;
            pst=con.prepareStatement(query);
            pst.setString(1, firstName);
            pst.setString(2,lastName);
            String filePath= savePath + File.separator + fileName ;
            pst.setString(3,filePath);
            pst.executeUpdate();
}
catch(Exception e)
        {}
}
    // file name of the upload file is included in content-disposition     header like this:
//form-data; name="dataFile"; filename="PHOTO.JPG"
private String extractFileName(Part part) {
    String contentDisp = part.getHeader("content-disposition");
    String[] items = contentDisp.split(";");
    for (String s : items) {
        if (s.trim().startsWith("filename")) {
            return s.substring(s.indexOf("=") + 2, s.length()-1);
        }
    }
    return "";
}
}