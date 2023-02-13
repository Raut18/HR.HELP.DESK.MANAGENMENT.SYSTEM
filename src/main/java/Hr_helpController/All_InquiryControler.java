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
import Hr_helpBo.Inquiry_bo;
import Hr_helpdao.Hr_Help_Dao;

/**
 * Servlet implementation class All_InquiryControler
 */
@WebServlet("/All_InquiryControler")
public class All_InquiryControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public All_InquiryControler() {
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
		pw.print("<table border='1px' width='100%'>");
		pw.print("<h1>ALL INQUIRY</h1>");
		pw.print("<tr><th>ID</th><th>NAME</th><th>EMAIL</th><th>DESCRIPTION</th><th>DATE</th></tr>");
		List<Inquiry_bo> list=Hr_Help_Dao.getallinquiry();
		
		for(Inquiry_bo ab:list)
		{
			pw.print("<tr><td>"+ab.getId()+"</td><td>"+ab.getName()+"</td><td>"+ab.getEmail()+"</td><td>"+ab.getDecs()+"</td><td>"+ab.getDate()+"</td></tr>");
		}
		pw.print("</table>");
		
		pw.print("<a href=home.html><button>Back</button></a>");

	}

}
