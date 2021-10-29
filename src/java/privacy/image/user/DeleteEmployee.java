package privacy.image.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.DataBaseConnection;

/**
 * Servlet implementation class DeleteEmployee
 */
@WebServlet("/DeleteEmployee")
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession(true);
        try 
        {
            DataBaseConnection db1=new DataBaseConnection();
            String id1=request.getParameter("id");
            
            
            if(id1!="")
            {
                String qry="delete from share where id='"+id1+"'";
                System.out.println("Deleted Query");
                int i=db1.Delete(qry);
                if (i > 0) 
                {
                    
                    session.setAttribute("msg", "PolicyID Deleted Successfully !");
                    response.sendRedirect("viewsharedimages.jsp");
                } 
           
                
            }
            else 
            {
                session.setAttribute("msg", "Please Select the Valid Records !");
                response.sendRedirect("viewsharedimages.jsp");
            }
            
        }
        catch (Exception e) 
        { 
            out.println(e);
        }

    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
