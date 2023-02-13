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
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private static final String Emp_dao = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
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
			
			int id=Integer.parseInt(request.getParameter("id"));
			 String name=request.getParameter("name");
			String email=request.getParameter("email");
			String doj=request.getParameter("doj");
			String dept=request.getParameter("dept");
			String des=request.getParameter("des");
			String sal=request.getParameter("sal");
			
			 
			 Employee_bo eb=new Employee_bo();
			 eb.setId(id);
			 eb.setName(name);
			 eb.setEmail(email);
			 eb.setDoj(doj);
			 eb.setDept(dept);
			 eb.setDes(des);
			 eb.setSal(sal);
			 
			 int status=Hr_Help_Dao.update(eb);
			 if(status>0)
			 {
				 RequestDispatcher rd=request.getRequestDispatcher("All_EmpController");
				 rd.forward(request, response);
			 }
			 else
				 
			 {
				 pw.print("Jay bhokat");
			 }
			 
		
	}

}
