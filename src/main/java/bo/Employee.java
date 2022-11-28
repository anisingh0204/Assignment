package bo;

public class Employee {
	private Long eid;
	private String ename;
	private String doj;
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	private Long yearOfExperience;
	private String designation;
	public Employee() {
		super();
	}
	public Employee(Long eid, String ename,String doj, Long yearOfExperience, String designation) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.doj = doj;
		this.yearOfExperience = yearOfExperience;
		this.designation = designation;
	}
	public Long getEid() {
		return eid;
	}
	public void setEid(Long eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Long getYearOfExperience() {
		return yearOfExperience;
	}
	public void setYearOfExperience(Long yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
