package privacy.image.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.DataBaseConnection;

/**
 * Servlet implementation class EmployeeInsert
 */
@WebServlet("/UserInsert")
public class UserInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInsert() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
		// TODO Auto-generated method stub
            response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    HttpSession session=request.getSession(true);
	   
	    try {	
		   String userid=request.getParameter("userid");
		   String policy=request.getParameter("policy");
		   String username=request.getParameter("username");
		   String password=request.getParameter("password");
		   String confirmpassword=request.getParameter("confirmpassword");
		   String mobilenumber=request.getParameter("mobilenumber");
		   String mailid=request.getParameter("mailid");
                   String status="PENDING";
                   DataBaseConnection db=new DataBaseConnection();
		   ResultSet rs=null;
            if((userid!="")&&(policy!="")&&(username!="")&&(password!="")&&(confirmpassword!="")&&(mobilenumber!="")&&(mailid!=""))
            {
                rs=db.Select("select * from  userinsert where username='"+username+"'or mobilenumber='"+mobilenumber+"' or mailid='"+mailid+"'");
                if(rs.next())
                {
                    session.setAttribute("msg","UserName, PhoneNumber and EmailId Should be Unique !");
                    response.sendRedirect("register.jsp"); 
                }
                else
                {
	  
	    String query="select * from userinsert where userid='"+userid+"' and username='"+username+"'";
	    String query1="insert into userinsert values('"+0+"','"+username+"','"+password+"','"+confirmpassword+"','"+mobilenumber+"','"+mailid+"','"+policy+"','"+status+"') ";
	    rs=db.Select(query);
	   
	   
	                int i=db.Insert(query1);
	                if(i>0)
	                {
	                session.setAttribute("msg","User Successfully Registered");
	                response.sendRedirect("register.jsp");
	                }
	            }
	        } 
            }catch (SQLException ex) 
                {
	           out.println(ex);
	        }
        
        
        }
}