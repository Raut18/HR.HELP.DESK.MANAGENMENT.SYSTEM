package Hr_helpController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hr_helpBo.Freshers_bo;
import Hr_helpdao.Hr_Help_Dao;

/**
 * Servlet implementation class FreshersController
 */
@WebServlet("/FreshersController")
public class FreshersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreshersController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			
			String name=request.getParameter("name");
			String edu=request.getParameter("edu");
			String mode=request.getParameter("mode");
			String date=request.getParameter("date");
			
			Freshers_bo fb=new Freshers_bo(name,edu, date, date);
			
			int status=Hr_Help_Dao.addFreshers(fb);
			if(status>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("All_freshersController");
				rd.forward(request, response);
				
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("freshers.html");
				rd.include(request, response);
			}
			
	
	}

}
