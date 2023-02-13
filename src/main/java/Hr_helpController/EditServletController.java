package Hr_helpController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hr_helpBo.Employee_bo;
import Hr_helpdao.Hr_Help_Dao;

/**
 * Servlet implementation class EditServletController
 */
@WebServlet("/EditServletController")
public class EditServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServletController() {
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
		
		String id=request.getParameter("id");
        
	      int eid= Integer.parseInt(id);
	    
	      Employee_bo eb=Hr_Help_Dao.getEmpById(eid);
	    
		 
		pw.print("<form  action='UpdateController' method='get'> ");
	    
		pw.print("<table>");
		
		pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+eb.getId()+"'/></td></tr>");  
		pw.print("<tr><td>Name: </td> <td><input type='text' name='name' value='"+eb.getName()+"'/></td></tr>");
	   	pw.print("<tr><td>Email: </td> <td><input type='text' name='email' value='"+eb.getEmail()+"'/></td></tr>");
	   	pw.print("<tr><td>Date of joining :</td> <td><input type='text'  name='doj' value='"+eb.getDoj()+"'/></td></tr>");
	   	pw.print("<tr><td>Depertment : </td> <td><input type='text' name='dept' value='"+eb.getDept()+"'/></td></tr>");
	   	pw.print("<tr><td>Designation : </td> <td><input type='text' name='des' value='"+eb.getDes()+"'/></td></tr>");
	   	pw.print("<tr><td>Salary : </td> <td><input type='text' name='sal' value='"+eb.getSal()+"'/></td></tr>");
		
	    pw.print("<tr><td><input type='submit' value='Edit '/></td></tr>"); 
	    
	   	pw.print("</table>");
		
		pw.print("</form>");
		
	}

}
