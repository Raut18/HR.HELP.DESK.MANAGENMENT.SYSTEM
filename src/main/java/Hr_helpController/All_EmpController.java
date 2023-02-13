package Hr_helpController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Hr_helpBo.Employee_bo;
import Hr_helpdao.Hr_Help_Dao;



/**
 * Servlet implementation class All_EmpController
 */
@WebServlet("/All_EmpController")
public class All_EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public All_EmpController() {
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
		pw.print("<link rel=stylesheet type=text/css href=css/allemp.css>");
		pw.print("<a href='home.html'></a>");
		pw.print("<h1>ALL EMPLOYEE DETAILS</h1>");
		pw.print("<table border='1px' width='100%'>");
		
		pw.print("<tr><th>ID</th><th>NAME</th><th>EMAIL</th><th>DATE</th><th>DEPARTMENT</th><th>DESIGNATION</th><th>SALARY</th><th>ACTION</th><th>ACTION</th></tr>");
		
		List<Employee_bo> list=Hr_Help_Dao.getallEmp();
		
		for(Employee_bo ab:list)
		{
			pw.print("<tr><td>"+ab.getId()+"</td><td>"+ab.getName()+"</td><td>"+ab.getEmail()+"</td><td>"+ab.getDoj()+"</td><td>"+ab.getDept()+"</td><td>"+ab.getDes()+"</td><td>"+ab.getSal()+"</td><td><a href='EditServletController?id="+ab.getId()+"'> edit </a></td> <td><a href='DeleteServletController?id="+ab.getId()+"'>delete </a></td></tr>\"");
		}
		pw.print("</table>");
		
		pw.print("<a href=home.html><button>Back</button></a>");
	
		
	}

}
