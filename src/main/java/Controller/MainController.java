package Controller;

import java.util.Scanner;

import Model.Student;
import Service.StudentService;
import Service.StudentServiceImpl;
import net.bytebuddy.description.ModifierReviewable.OfAbstraction;

public class MainController {
	
	
	public static void main(String[] args) {
		
		StudentService studentService = new StudentServiceImpl();
		
//		For Insertion of Student
		System.out.println("Enter Student name?");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		
		System.out.println("Enter Student Stream?");
		String stream = scanner.nextLine();
		
		System.out.println("Enter Student Mark?");
		int mark = scanner.nextInt();
		
		Student student = new Student();
		student.setSname(name);
		student.setStream(stream);
		student.setMark(mark);
		
		String result = studentService.saveStudent(student);
		
		if (result.equalsIgnoreCase("Success"))
			System.out.println("Database Insertion Successfull");
		else
			System.out.println("Database Insertion Failed");
		
		
			
//		For Deletion Of Student By Student Id
		System.out.println("Enter Student Id to Delete?");
		int sid = scanner.nextInt();
		
		String result1 = studentService.deleteStudentId(sid);
		if (result1.equalsIgnoreCase("Success"))
			System.out.println("Deletion of Student With Id " + sid + " Successfull");
		else
			System.out.println("Student Deletion Failed");
		
		
		
//		For Deletion Of Student By Student Name
		System.out.println("Enter Student Name to Delete?");
		String sname = scanner.nextLine();
		String result2 = studentService.deleteByStudentName(sname);
		if (result2.equalsIgnoreCase("Success"))
			System.out.println("Deletion Successfull");
		else
			System.out.println("Student Deletion Failed");
		
		
		
//		For Update Of Student By Student Id
		System.out.println("Enter Student Id to Update?");
		int sid1 = scanner.nextInt();
		
		String result3 = studentService.updateStudentById(sid1);
		
		if (result3.equalsIgnoreCase("Success"))
			System.out.println("Updation Successfull");
		else
			System.out.println("Updation Failed");
		
	}
}
