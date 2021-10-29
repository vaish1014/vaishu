
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="connection.DataBaseConnection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%

            // size of byte buffer to send file
            int BUFFER_SIZE = 4096;

            // database connection settings

            // get upload id from URL's parameters
            String id2=request.getParameter("id");
             String key=request.getParameter("key");%>
             <script>
                 var x=id2;
                 alert(id2);
             </script>        
            <%String filepath =null;
            DataBaseConnection db = new DataBaseConnection();
            Connection conn = null; // connection to the database
            ResultSet result = null;
            String fileName = null;
            try {
                // connects to the database
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/privacy", "root", "admin");
                // queries the database
                String sql = "SELECT imageuploadfolder.key1,imageuploadfolder.id,share.id,share.imagename,imageuploadfolder.textfile FROM share join imageuploadfolder on imageuploadfolder.id=share.id where imageuploadfolder.key1='"+request.getParameter("key")  +"' && imageuploadfolder.id='"+request.getParameter("id")+"'";
                //String sql="SELECT imageuploadfolder.key1,imageuploadfolder.id,share.id,share.imagename FROM privacy.imageuploadfolder,share where imageuploadfolder.key1='"+request.getParameter("key")+"' && imageuploadfolder.id='"+request.getParameter("id")+"'";
                PreparedStatement statement = null;
                 //filepath = "D:\\ImagePrivacy\\web\\image\\upload\\";
                  String p=request.getRealPath("/");
                System.out.println("p:\t"+p);
                
                filepath = p+"\\image\\upload\\";
                System.out.println("path:\t"+filepath);
                 //filepath="C:\\Users\\Public\\Pictures\\Sample Pictures\\";
                statement = conn.prepareStatement(sql);
                result = statement.executeQuery();
                if (result.next()) {
                    // gets file name and file blob data

                    
                    ServletContext context = getServletContext();

                    // sets MIME type for the file download
                    String mimeType = context.getMimeType(filepath);
                    if (mimeType == null) {
                        // set to binary type if MIME mapping not found
                        mimeType = "application/octet-stream";
                    }
                    System.out.println("MIME type: " + mimeType);

                    // modifies response
                    File downloadfile = new File(filepath + result.getString("imagename"));
                    FileInputStream inStream = new FileInputStream(downloadfile);
                    response.setContentType(mimeType);
                    response.setContentLength((int) downloadfile.length());

                    // forces download
                    String headerKey = "Content-Disposition";
                    String headerValue = String.format("attachment; filename=\"%s\"", downloadfile.getName());
                    response.setHeader(headerKey, headerValue);

                    // obtains response's output stream
                    OutputStream outStream = response.getOutputStream();
                    
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;
                    
                    while ((bytesRead = inStream.read(buffer)) != -1) {
                        outStream.write(buffer, 0, bytesRead);
                    }
                    
                    inStream.close();
                    outStream.close();
                } else{
               //filepath = "D:\\ImagePrivacy\\web\\image\\upload\\agenthome.txt";
                      String sql1 = "SELECT imageuploadfolder.key1,imageuploadfolder.id,share.id,share.imagename,imageuploadfolder.textfile FROM share join imageuploadfolder on imageuploadfolder.id=share.id where  imageuploadfolder.id='"+request.getParameter("id")+"'";
                 
                 PreparedStatement   statement12 = conn.prepareStatement(sql1);
            ResultSet    result12 = statement12.executeQuery();
                if(result12.next()){
                    fileName=result12.getString(5).trim();
                ServletContext context = getServletContext();
                filepath = p+"\\image\\upload\\"+fileName ;
                System.out.println("path:\t"+filepath);
                    // sets MIME type for the file download
                    String mimeType = context.getMimeType(filepath);
                    if (mimeType == null) {
                        // set to binary type if MIME mapping not found
                        mimeType = "application/octet-stream";
                    }
                    System.out.println("MIME type: " + mimeType);

                    // modifies response
                    File downloadfile = new File(filepath );
                    FileInputStream inStream = new FileInputStream(downloadfile);
                    response.setContentType(mimeType);
                    response.setContentLength((int) downloadfile.length());

                    // forces download
                    String headerKey = "Content-Disposition";
                    String headerValue = String.format("attachment; filename=\"%s\"", downloadfile.getName());
                    response.setHeader(headerKey, headerValue);

                    // obtains response's output stream
                    OutputStream outStream = response.getOutputStream();
                    
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;
                    
                    while ((bytesRead = inStream.read(buffer)) != -1) {
                        outStream.write(buffer, 0, bytesRead);
                    }
                    
                    inStream.close();
                    outStream.close();
                    
                   
                    response.sendRedirect("viewsharedimages.jsp");
                }  }
            } catch (Exception e) {
               System.out.print("ret "+e);
            }
        %>

    </body>
</html>
