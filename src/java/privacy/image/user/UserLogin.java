package privacy.image.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.DataBaseConnection;

/**
 * Servlet implementation class EmployeeCheck
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        try {
            String name = request.getParameter("username");
            String pass = request.getParameter("password");
            String imagename = request.getParameter("imagename");
            DataBaseConnection db = new DataBaseConnection();
            ResultSet rs = db.Select("select * from userinsert where username='" + name + "' and password='" + pass + "'and status='VERIFIED'");
            if (rs.next()) {

                String uname = rs.getString("username");
                String pass1 = rs.getString("password");
               session.setAttribute("mail", rs.getString("mailid"));

                if (uname.equals(name) && (pass1.equals(pass))) {
                    int id = rs.getInt(1);
                    String policy = rs.getString("policy");
                    session.setAttribute("msg", "User Successfully Login");
                    session.setAttribute("policy", policy);
                    session.setAttribute("userid", id);
                    session.setAttribute("username", name);
                    session.setAttribute("imagename", imagename);
                    response.sendRedirect("userhome.jsp");

                } else {


                    session.setAttribute("msg", "Case Sensitive UserName and PassWord");
                    response.sendRedirect("userlogin.jsp");

                }

            } else {


                session.setAttribute("msg", "Invalid UserName and PassWord(or)Admin Not Verified User Details");
                response.sendRedirect("userlogin.jsp");


            }
        } catch (Exception e) {
            out.println(e);
        } finally {
            out.close();
        }
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
