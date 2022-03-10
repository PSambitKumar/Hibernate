package Service;

import Model.Student;

public interface StudentService {
	
	public String saveStudent(Student student);
	public String deleteStudentId(int id);
	public String deleteByStudentName(String sname);
	public String updateStudentById(int id);
	
}
