package collegefest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int studentId;
	
	private String studentName;
	
	private String department;

	private String Country;

	public StudentDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDetail(int studentId, String name, String department, String country) {
		super();
		this.studentId = studentId;
		this.studentName = name;
		this.department = department;
		Country = country;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String name) {
		this.studentName = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		this.Country = country;
	}

	public String toString() {
		return "StudentDetail [studentId=" + studentId + ", name=" + studentName + ", department=" + department + ", Country="
				+ Country + "]";
	}
}

