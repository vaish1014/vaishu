/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package privacy.image.user;

import connection.DataBaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author chiranjeevi
 */
public class Permission extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession(true);
        try 
        {
            DataBaseConnection db1=new DataBaseConnection();
            
            String userid1=request.getParameter("userid");
            
            String verify1="VERIFIED";
            ResultSet rs1=null;
            
            if(userid1!="")
            {
                String qry="update userinsert set status='"+verify1+"' where userid='"+userid1+"'";
                System.out.println("Updated Query");
                int i=db1.Update(qry);
                if (i > 0) 
                {
                    
                    session.setAttribute("msg", "Admin Verified User Details Successfully!");
                    response.sendRedirect("adminlistusers.jsp");
                }
               
            }
            else 
            {
                session.setAttribute("msg", "Request Id Cannot be Empty !");
                response.sendRedirect("adminlistusers.jsp"); 
            }
            
        }
        catch (Exception e) 
        { 
            out.println(e);
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
