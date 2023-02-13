package Hr_helpController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hr_helpBo.Inquiry_bo;
import Hr_helpdao.Hr_Help_Dao;

/**
 * Servlet implementation class EnqController
 */
@WebServlet("/EnqController")
public class EnqController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnqController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String decs=request.getParameter("decs");
		String date =request.getParameter("date");
		
		Inquiry_bo ib=new Inquiry_bo(name,email,decs,date);
		ib.setName(name);
		ib.setEmail(email);
		ib.setDecs(decs);
		ib.setDate(date);
		
		int status=Hr_Help_Dao.addinquiry(ib);
		if(status>0)
		{
			 RequestDispatcher rd=request.getRequestDispatcher("All_InquiryControler");
			 rd.forward(request, response);
		}
		else
		{
			pw.print("Some thing error....!!!!");
		}
		
		
		
		
	}

}
