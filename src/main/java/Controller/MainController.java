package Controller;

import java.util.Scanner;

import Model.Student;
import Service.StudentService;
import Service.StudentServiceImpl;

public class MainController {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		methodsForOperation methodsForOperation = new methodsForOperation();

		int choice = 0;

		while(choice < 7){
			System.out.println("<-----Main Menu----->");
			System.out.println("1. Add Student.\n 2. Update Student\n 3. Delete Student By Id\n 4. Delete Student By Name\n 5. View Student\n 6. Exit");
			System.out.println("Enter Your Choice?");
			choice = scanner.nextInt();
			switch (choice){
				case 1:
					methodsForOperation.addStudent();
					break;
				case 2:
					methodsForOperation.updateStudentById();
					break;
				case 3:
					methodsForOperation.deleteStudentById();
					break;
				case 4:
					methodsForOperation.deleteStudentByName();
					break;
				case 5:
					methodsForOperation.viewAllStudent();
					break;
				case 6:
					System.exit(0);
					break;
				default:
					System.out.println("Not a Valid Choice!!");
					break;
			}
		}
	}
}


class methodsForOperation{
	StudentService studentService = new StudentServiceImpl();
	Scanner scanner = new Scanner(System.in);


	//		For Insertion of Student
	void addStudent(){
		System.out.println("Enter Student name?");
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
	}


//	For Update Of Student By Student Id
	void updateStudentById(){
		System.out.println("Enter Student Id to Update?");
		int sid1 = scanner.nextInt();

		String result3 = studentService.updateStudentById(sid1);

		if (result3.equalsIgnoreCase("Success"))
			System.out.println("Updation Successfull");
		else
			System.out.println("Updation Failed");
	}


//Delete of Student By Student Id
	void deleteStudentById(){
		System.out.println("Enter Student Id to Delete?");
		int sid = scanner.nextInt();

		String result1 = studentService.deleteStudentId(sid);
		if (result1.equalsIgnoreCase("Success"))
			System.out.println("Deletion of Student With Id " + sid + " Successfull");
		else
			System.out.println("No Student Found With Id" + sid + ".");
	}


//	For Deletion Of Student By Student Name
	void deleteStudentByName(){
		System.out.println("Enter Student Name to Delete?");
		String sname = scanner.nextLine();
		String result2 = studentService.deleteByStudentName(sname);
		if (result2.equalsIgnoreCase("Success"))
			System.out.println("Deletion Successfully");
		else
			System.out.println("No Student Found With Name " +sname + ".");
	}

	//		For Viewing of Studets One By One
	void viewAllStudent(){
		System.out.println("Printing All The Student List.");
		studentService.viewAllStudents();
	}
}
