package creational.design.pattern;

import java.util.ArrayList;
import java.util.List;

//Model class
class Student {
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
}

/**
 * Dummy Student DAO implementation
 * In Real Scenario Object can be constructed by calling database.
 */
class StudentDAO implements Cloneable{
	private static List<Student> studentList;
	
	static {
		studentList = new ArrayList<Student>();
		Student student1 = new Student();
		student1.setId(10);
		student1.setName("PK");
 
		Student student2 = new Student();
		student2.setId(20);
		student2.setName("MK");
 
		studentList.add(student1);
		studentList.add(student2);
	}
	
	/**
	 * In Real Scenario Object can be constructed by calling database.
	 * @return Student List
	 */
	public List<Student> getAllStudents(){
		return studentList;
	}
	
	/**
	 * Creating Clone of an Existing object
	 */
	@Override
	protected List<Student> clone() throws CloneNotSupportedException {
		List<Student> dummyList = new ArrayList<>();
		for(Student student : studentList) {
			dummyList.add(student);
		}
		return dummyList;
	}
}

public class PrototypePattern {

	public static void main(String[] args) throws CloneNotSupportedException {
		StudentDAO studentDAO = new StudentDAO();
		
		//Getting Original copy of student list
		List<Student> allStudents = studentDAO.getAllStudents();
		
		//Getting clone copy of student list
		List<Student> updatedStudentList = studentDAO.clone();
		Student student = new Student();
		student.setId(30);
		student.setName("SK");
		
		//Doing manipulation on cloned copy
		updatedStudentList.add(student);
		
		System.out.println("Original list");
		allStudents.forEach(System.out::println);
		
		System.out.println("Updated list");
		updatedStudentList.forEach(System.out::println);
		
	}

}
