package Hr_helpController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hr_helpBo.Employee_bo;
import Hr_helpdao.Hr_Help_Dao;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/Add_EmpController")
public class Add_EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_EmpController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
	
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String doj=request.getParameter("doj");
		String dept=request.getParameter("dept");
		String des=request.getParameter("des");
		String sal=request.getParameter("sal");
		Employee_bo eb=new Employee_bo(name, email, doj, dept, des, sal);
		
		int status=Hr_Help_Dao.addEmp(eb);
		if(status>0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("All_EmpController");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("addemp.html");
			rd.include(request, response);
		}
		
	}

}
