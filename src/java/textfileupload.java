/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import connection.DataBaseConnection;
import connection.email;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vinoth
 */
@WebServlet(urlPatterns = {"/textfileupload"})
public class textfileupload extends HttpServlet {

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        String name = session.getAttribute("username").toString();
        String imagename = request.getParameter("imagename");
        String id = request.getParameter("id");
        String mail1= request.getParameter("mail1");
        String policy = request.getParameter("policy");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/privacy", "root", "admin");
            PreparedStatement st = con.prepareStatement("insert into share values (?,?,?,?)");
            st.setString(1, id);
            st.setString(2, policy);
            st.setString(3, imagename);
            st.setString(4, name);
            int i = st.executeUpdate();
            
            String key=null;
            DataBaseConnection db=new DataBaseConnection();
            String sqll="select key1 from imageuploadfolder where id='"+id+"' ";
            ResultSet rs1=db.Select(sqll);
            if(rs1.next())
            {
                key=rs1.getString(1);
            }
            System.out.println(id+"\tkey:\t"+key);
           session.setAttribute("msg", "Image Shared Successfully");
           email e=new email(); 
           boolean k=e.email(mail1, "Image Shared By your Policy Friends. key for image:"+key);
           if(k){ System.out.println("Email Sent"); 
            session.setAttribute("msg", "Image Shared Successfully");
            response.sendRedirect("viewuploadimagesshare.jsp"); 
           }
           else
           {
                System.out.println("Email not Sent"); 
                session.setAttribute("msg", "Image Sharing Success");
                response.sendRedirect("viewuploadimagesshare.jsp"); 
           }
            
           
           // response.sendRedirect("mail1?poli=" + policy + "&id=" + id +"&mail=");
        } catch (Exception e) {
            out.println(e);
        }
    }
}
