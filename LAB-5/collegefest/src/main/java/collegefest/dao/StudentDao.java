package collegefest.dao;
import java.util.List;

import org.springframework.stereotype.Component;

import collegefest.model.StudentDetail;

@Component
public interface StudentDao {

		
		public void createStudentDetails (StudentDetail studentDetail);
		public List<StudentDetail> getStudentDetail();
		public void deleteStudentDetail (int StudentId);
		public StudentDetail getStudentDetail (int StudentId);
}
