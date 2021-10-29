<%-- 
    Document   : filedownload
    Created on : Jul 30, 2015, 11:45:17 AM
    Author     : chiranjeevi
--%>

<%@page import="java.io.IOException"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
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
                int BUFFER_SIZE = 4096;

                // database connection settings
                String dbURL = "jdbc:mysql://localhost:3306/privacy";
                String dbUser = "root";
                String dbPass = "admin";
                int uploadId = Integer.parseInt(request.getParameter("id"));

                Connection conn = null; // connection to the database

                try {
                    // connects to the database
                    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                    conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

                    // queries the database
                    String sql = "SELECT * FROM imageupload WHERE id = ?";
                    PreparedStatement statement = conn.prepareStatement(sql);
                    statement.setInt(1, uploadId);

                    ResultSet result = statement.executeQuery();
                    if (result.next()) {
                        // gets file name and file blob data
                        String fileName = result.getString("imagename");
                        Blob blob = result.getBlob("file");
                        InputStream inputStream = blob.getBinaryStream();
                        int fileLength = inputStream.available();

                        System.out.println("fileLength = " + fileLength);

                        ServletContext context = getServletContext();

                        // sets MIME type for the file download
                        String mimeType = context.getMimeType(fileName);
                        if (mimeType == null) {
                            mimeType = "application/octet-stream";
                        }

                        // set content properties and header attributes for the response
                        response.setContentType(mimeType);
                        response.setContentLength(fileLength);
                        String headerKey = "Content-Disposition";
                        String headerValue = String.format("attachment; filename=\"%s\"", fileName);
                        response.setHeader(headerKey, headerValue);

                        // writes the file to the client
                        OutputStream outStream = response.getOutputStream();

                        byte[] buffer = new byte[BUFFER_SIZE];
                        int bytesRead = -1;

                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            outStream.write(buffer, 0, bytesRead);
                        }

                        inputStream.close();
                        outStream.close();
                    } else {
                        // no file found
                        response.getWriter().print("File not found for the id: " + uploadId);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    response.getWriter().print("SQL Error: " + ex.getMessage());
                } catch (IOException ex) {
                    ex.printStackTrace();
                    response.getWriter().print("IO Error: " + ex.getMessage());
                } finally {
                    if (conn != null) {
                        // closes the database connection
                        try {
                            conn.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
         

        %>
    </body>
</html>
