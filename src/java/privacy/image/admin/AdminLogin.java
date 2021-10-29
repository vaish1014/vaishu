/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package privacy.image.admin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession(true);
        try {
            String name=request.getParameter("adminname");
            String pass=request.getParameter("password");
            if(name.equalsIgnoreCase("ADMIN")&&pass.equalsIgnoreCase("ADMIN"))
            {
                session.setAttribute("name",name);
                session.setAttribute("pass",pass);
                session.setAttribute("msg","Admin Successfully Login");
                response.sendRedirect("adminhome.jsp");
               
            }
             else
            { 
               session.setAttribute("msg","Invalid AdminName and PassWord");
               response.sendRedirect("adminlogin.jsp");            
            }
        }
        catch(Exception e)
        {
            out.println(e);
        }
        finally {            
            out.close();
        }
    }
}

   
