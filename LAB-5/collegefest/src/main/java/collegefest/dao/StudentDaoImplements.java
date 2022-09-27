package collegefest.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import collegefest.model.StudentDetail;
@Component
public class StudentDaoImplements implements StudentDao {
	
	@Autowired
	private  HibernateTemplate hibernateTemplate;

	@Override
	@Transactional
	public void createStudentDetails(StudentDetail studentDetail) {
		this.hibernateTemplate.saveOrUpdate(studentDetail);
		
	}

	@Override
	@Transactional
	public List<StudentDetail> getStudentDetail() {
		List<StudentDetail> studentDetails = this.hibernateTemplate.loadAll(StudentDetail.class); 
		return studentDetails;
	}

	@Override
	@Transactional
	public void deleteStudentDetail(int StudentId) {
		StudentDetail sd = this.hibernateTemplate.get(StudentDetail.class, StudentId);
		this.hibernateTemplate.delete(sd);
	}

	@Override
	@Transactional
	public StudentDetail getStudentDetail(int StudentId) {
		StudentDetail sd = this.hibernateTemplate.get(StudentDetail.class, StudentId);
		return sd;
	}


}
