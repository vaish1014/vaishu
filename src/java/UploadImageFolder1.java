
import com.ddsoft.tornado.core.image.ImageAnalyzerUtil;
import connection.DataBaseConnection;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/UploadImageFolder1")
/**
 * A Java servlet that handles file upload from client.
 *
 * @author www.codejava.net
 */
public class UploadImageFolder1 extends HttpServlet 
{
    private static final long serialVersionUID = 1L;
    // location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "upload";
    // upload settings
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

    /**
     * Upon receiving file upload submission, parses the request to read upload
     * data and saves the file on disk.
     */
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        // checks if the request actually contains upload file
        String fileName = null;
        HttpSession ses=request.getSession();
        if (!ServletFileUpload.isMultipartContent(request)) {
            // if not, we stop here
            PrintWriter writer = response.getWriter();
            writer.println("Error: Form must has enctype=multipart/form-data.");
            writer.flush();
            return;
        }
            String policy=request.getParameter("policy");

        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // sets memory threshold - beyond which files are stored in disk
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // sets temporary location to store files
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);

        // sets maximum size of upload file
        upload.setFileSizeMax(MAX_FILE_SIZE);

        // sets maximum size of request (include file + form data)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // constructs the directory path to store upload file
        // this path is relative to application's directory
        String path = "Z:\\NetBeans\\ImagePrivacy\\web\\photo" + File.separator + UPLOAD_DIRECTORY;

        // creates the directory if it does not exist
        File uploadDir = new File(path);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {
            // parses the request's content to extract file data
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);

            if (formItems != null && formItems.size() > 0) {
                // iterates over form's fields
                for (FileItem item : formItems) {
                    // processes only fields that are not form fields
                    if (!item.isFormField()) {
                        fileName = new File(item.getName()).getName();
                        String filePath = path + File.separator + fileName;
                        File storeFile = new File(filePath);

                        // saves the file on disk
                        item.write(storeFile);
                        request.setAttribute("msg","Upload has been done successfully!");
                    
                }
            }

            DataBaseConnection db = new DataBaseConnection();
           // ImageAnalyzerUtil.convertImageToText("Z:\\NetBeans\\ImagePrivacy\\web\\photo\\upload\\" + fileName);
           // ImageAnalyzerUtil.convertTextToImage("Z:\\NetBeans\\ImagePrivacy\\web\\photo\\textfile\\" + fileName + ".txt");
            String textfile=fileName+".txt";
            String[] newtext=textfile.split(".jpg");
            String txtfile=newtext[0]+".txt";
            db.Insert("insert into share(filename,textfile,username,policy) values('" + fileName + "','"+txtfile+"','"+ ses.getAttribute("username")+"','"+policy+"')");
        }
        }catch (Exception ex) {
            request.setAttribute("msg","There was an error: " + ex.getMessage());
        }
    
        // redirects client to message page
        getServletContext().getRequestDispatcher("/imagetotextshare.jsp").forward(request, response);
    }
}
