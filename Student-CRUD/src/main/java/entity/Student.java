package entity;

public class Student {

	private int s_no;
	private String sname;
	private String dob;
	private String doj;


	public Student(int s_no, String sname, String dob, String doj) {
		super();
		this.s_no = s_no;
		this.sname = sname;
		this.dob = dob;
		this.doj = doj;
	}


	public Student() {

	}


	public int getS_no() {
		return s_no;
	}


	public void setS_no(int s_no) {
		this.s_no = s_no;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getDoj() {
		return doj;
	}


	public void setDoj(String doj) {
		this.doj = doj;
	}


}
