package Hr_helpBo;

public class Employee_bo 
{
	private int id;
	private String name;
	private String email;
	private String doj;
	private String dept;
	private String des;
	private String sal;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getSal() {
		return sal;
	}
	public void setSal(String sal) {
		this.sal = sal;
	}
	public Employee_bo( String name, String email, String doj, String dept, String des, String sal) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.doj = doj;
		this.dept = dept;
		this.des = des;
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Employee_bo [id=" + id + ", name=" + name + ", email=" + email + ", doj=" + doj + ", dept=" + dept
				+ ", des=" + des + ", sal=" + sal + "]";
	}
	public Employee_bo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
