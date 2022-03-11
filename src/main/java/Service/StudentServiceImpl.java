package Service;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import Model.Student;

public class StudentServiceImpl implements StudentService{

	Scanner scanner = new Scanner(System.in);
	
	@Override
	public String saveStudent(Student student) {
		String result = null;
		try {
			Configuration conf = new Configuration();
			conf.addAnnotatedClass(Student.class);
			SessionFactory sesf = conf.buildSessionFactory();

			Session ses = sesf.openSession();

			ses.getTransaction().begin();
			ses.save(student);
			ses.getTransaction().commit();
			ses.close();
			result = "Success";
		} catch (Exception e) {
			e.printStackTrace();
			result = "Fail";
		}
		return result;
	}

	
	
	
	@Override
	public String deleteStudentId(int id) {
		String result = null;
		try {
			Configuration conf = new Configuration();
			conf.addAnnotatedClass(Student.class);
			SessionFactory sesf = conf.buildSessionFactory();

			Session ses = sesf.openSession();
			Student student = ses.get(Student.class, id);
			ses.delete(student);
			
			ses.getTransaction().begin();
			ses.getTransaction().commit();
			ses.close();

			result = "Success";
		} catch (Exception e) {
			e.printStackTrace();
			result = "Fail";
		}
		return result;
	}




	@Override
	public String deleteByStudentName(String sname) {
		String result = null;
		try {
			Configuration conf = new Configuration();
			conf.addAnnotatedClass(Student.class);
			SessionFactory sesf = conf.buildSessionFactory();
			
			Session ses = sesf.openSession();
			 ses.getTransaction().begin();

			
			  Query querry=ses.createQuery("SELECT student.sid, student.sname, student.stream, student.mark FROM Student as student");
			  
			  
			  for(Object object:querry.list()) { 
				  Object[] objects=(Object [])object;
//				  System.out.println(objects[0]+"  "+objects[1]+"  "+objects[2] + " " +objects[3]); 
				  String name = (String) objects[1];
				  if (name.equalsIgnoreCase(sname)) {
					  int id = (Integer)objects[0];
					deleteStudentId(id);
					System.out.println("Deletion of Student With Name "+name+" With ID "+id+".");
					  result = "Success";
				}
				  else
					  result = "Fail";
			  }
			 ses.getTransaction().commit();
			 ses.close();
		} catch (Exception e) {
			e.printStackTrace();
			result = "Fail";
		}
		return result;
	}



	public String updateStudentById(int id) {
		String result = null;
		Student student;
		try {
			Configuration conf = new Configuration();
			conf.addAnnotatedClass(Student.class);
			SessionFactory sesf = conf.buildSessionFactory();

			Session ses = sesf.openSession();
			student = ses.get(Student.class, id);
			
			System.out.println("Enter New Name to Update?");
			String sname1 = scanner.nextLine();
			
			student.setSname(sname1);
			System.out.println(student);
			
			saveStudent(student);
			
			ses.getTransaction().begin();
			ses.getTransaction().commit();
			ses.close();
			result = "Success";
		} catch (Exception e) {
			e.printStackTrace();
			result = "Fail";
		}
		return result;
	}

	@Override
	public String viewAllStudents() {
		String result = null;
		try {
			Configuration conf = new Configuration();
			conf.addAnnotatedClass(Student.class);
			SessionFactory sesf = conf.buildSessionFactory();

			Session ses = sesf.openSession();
			ses.getTransaction().begin();


			Query querry=ses.createQuery("SELECT student.sid, student.sname, student.stream, student.mark FROM Student as student");


			for(Object object:querry.list()) {
				Object[] objects=(Object [])object;
				  System.out.println("Student Name:  "+objects[1]+" || Stream:  "+objects[2] + " || Mark: " +objects[3]);
			}

			ses.getTransaction().commit();
			ses.close();

			result = "Success";
		} catch (Exception e) {
			e.printStackTrace();
			result = "Fail";
		}
		return result;
	}

}
