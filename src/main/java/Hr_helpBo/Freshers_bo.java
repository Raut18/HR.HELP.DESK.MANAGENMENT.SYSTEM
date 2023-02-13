package Hr_helpBo;

public class Freshers_bo 
{
	private int id;
	private String name;
	private String edu;
	private String mode;
	private String date;
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
	public String getEdu() {
		return edu;
	}
	public void setEdu(String edu) {
		this.edu = edu;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Freshers_bo [id=" + id + ", name=" + name + ", edu=" + edu + ", mode=" + mode + ", date=" + date + "]";
	}
	public Freshers_bo(String name, String edu, String mode, String date) {
		super();
		this.id = id;
		this.name = name;
		this.edu = edu;
		this.mode = mode;
		this.date = date;
	}
	public Freshers_bo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
