package Hr_helpdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;


import Hr_helpBo.Employee_bo;
import Hr_helpBo.Freshers_bo;
import Hr_helpBo.Inquiry_bo;

public class Hr_Help_Dao 
{
	

	
	public static Connection getConnection()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/hrhelpdesk";
			String uname="root";
			String pass="root";
			con=DriverManager.getConnection(url,uname,pass);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return con;
	}
	
	public static boolean hrlogin(String email , String pwd)
	{
		boolean status=false;
			Connection con=Hr_Help_Dao.getConnection();
			
			String sql="select * from signin where email=? and pwa=?";
			try
			{
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, email);
				ps.setString(2, pwd);
				 ResultSet rs=ps.executeQuery();
				 status=rs.next();
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
		
		return status;
	}
	public static int addEmp(Employee_bo eb)
	{
		int status=0;
	
		Connection con=Hr_Help_Dao.getConnection();
		
		String sql="insert into employee(name,email,doj,dept,des,sal) values(?,?,?,?,?,?)";
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, eb.getName());
			ps.setString(2, eb.getEmail());
			ps.setString(3, eb.getDoj());
			ps.setString(4, eb.getDept());
			ps.setString(5, eb.getDes());
			ps.setString(6, eb.getSal());

			status=ps.executeUpdate();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return status;
	}
	public static List getallEmp()
	{
		List<Employee_bo> list=new ArrayList<Employee_bo>();

			Connection con=Hr_Help_Dao.getConnection();
			try
			{
				String sql="Select *from employee";
				PreparedStatement ps=con.prepareStatement(sql);
				
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					Employee_bo eb=new Employee_bo();
					eb.setId(rs.getInt(1));
					eb.setName(rs.getString(2));
					eb.setEmail(rs.getString(3));
					eb.setDoj(rs.getString(4));
					eb.setDept(rs.getString(5));
					eb.setDes(rs.getString(6));
					eb.setSal(rs.getString(7));
					list.add(eb);
				}
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
		return list;
	}
	public static Employee_bo getEmpById(int eid)
	{
		Employee_bo eb=new Employee_bo();
		try
		{
			Connection con= Hr_Help_Dao.getConnection();
			String sql="select * from employee where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,eid);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				eb.setId(rs.getInt(1));
				eb.setName(rs.getString(2));
				eb.setEmail(rs.getString(3));
				eb.setDoj(rs.getString(4));
				eb.setDept(rs.getString(5));
				eb.setDes(rs.getString(6));
				eb.setSal(rs.getString(6));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return eb;
	}
	public static int update(Employee_bo eb)
	{
		int status=0;
			try
			{
				Connection con=Hr_Help_Dao.getConnection();
				
				String sql="update employee set name=?,email=?,doj=?,dept=?,des=?,sal=? where id=?";
				
				try
				{
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, eb.getName());
					ps.setString(2, eb.getEmail());
					ps.setString(3, eb.getDoj());
					ps.setString(4, eb.getDept());
					ps.setString(5, eb.getDes());
					ps.setString(6, eb.getSal());
					ps.setInt(7, eb.getId());
					
					
					status=ps.executeUpdate();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
		return status;
	}
	public static int addinquiry(Inquiry_bo ib)
	{
		int status=0;
		
		Connection con=Hr_Help_Dao.getConnection();
		try
		{
			String sql="insert into inquiry(name,email,decs,date) values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, ib.getName());
			ps.setString(2, ib.getEmail());
			ps.setString(3, ib.getDecs());
			ps.setString(4, ib.getDate());
			
			status=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
	public static List getallinquiry()
	{
		ArrayList<Inquiry_bo> list=new ArrayList<Inquiry_bo>();
		Connection con=Hr_Help_Dao.getConnection();
		try
		{
			String sql="select * from inquiry";
			PreparedStatement ps=con.prepareStatement(sql);
			
			
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Inquiry_bo ib=new Inquiry_bo();
				ib.setId(rs.getInt(1));
				ib.setName(rs.getString(2));
				ib.setEmail(rs.getString(3));
				ib.setDecs(rs.getString(4));
				ib.setDate(rs.getString(5));
				list.add(ib);
			}
		}
		catch(Exception e)
		{
		
			System.out.println(e);
		}
		
		
		return list;
	}
	public static int addFreshers(Freshers_bo fb)
	{
		int status=0;
		Connection con=Hr_Help_Dao.getConnection();
		try
		{
			String sql="insert into freshers (name,edu,mode,date) values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, fb.getName());
			ps.setString(2, fb.getEdu());
			ps.setString(3, fb.getMode());
			ps.setString(4, fb.getDate());
			
			status=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return status;
	}
	public static List getallfreshers()
	{
		ArrayList<Freshers_bo> list=new ArrayList<Freshers_bo>();
		Connection con=Hr_Help_Dao.getConnection();
		try
		{
			String sql="select * from freshers";
			PreparedStatement ps=con.prepareStatement(sql);
			
			
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Freshers_bo ib=new Freshers_bo();
				ib.setId(rs.getInt(1));
				ib.setName(rs.getString(2));
				ib.setEdu(rs.getString(3));
				ib.setMode(rs.getString(4));
				ib.setDate(rs.getString(5));
				list.add(ib);
			}
		}
		catch(Exception e)
		{
		
			System.out.println(e);
		}
		
		
		return list;
	}
	public static int delet(int id)
	{
		int status=0;
		try
		{
			Connection con=Hr_Help_Dao.getConnection();
			String sql="Delete from employee where id=?";
			 PreparedStatement ps=con.prepareStatement(sql);
			  ps.setInt(1, id);
			  status=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		return status;
	}
}
