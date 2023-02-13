package Hr_helpController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hr_helpBo.Freshers_bo;
import Hr_helpBo.Inquiry_bo;
import Hr_helpdao.Hr_Help_Dao;

/**
 * Servlet implementation class All_freshersController
 */
@WebServlet("/All_freshersController")
public class All_freshersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public All_freshersController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.print("<link rel=stylesheet type=text/css href=css/allemp.css>");
		pw.print("<a href='home.html'></a>");
		pw.print("<table border='1px' width='100%'>");
		pw.print("<h1>ALL FRESHERS</h1>");
		pw.print("<tr><th>ID</th><th>NAME</th><th>EDUCATION</th><th>MODE</th><th>DATE</th></tr>");
		List<Freshers_bo> list=Hr_Help_Dao.getallfreshers();
		
		for(Freshers_bo ab:list)
		{
			pw.print("<tr><td>"+ab.getId()+"</td><td>"+ab.getName()+"</td><td>"+ab.getEdu()+"</td><td>"+ab.getMode()+"</td><td>"+ab.getDate()+"</td></tr>");
		}
		pw.print("</table>");
		
		pw.print("<a href=home.html><button>Back</button></a>");

	}

}
