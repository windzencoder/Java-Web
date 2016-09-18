package mybatis.bean;

import java.util.List;

public class Class {

	private int id;
	private String name;
	private Teacher teacher;
	private List<Student> students;
	
	public Class() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Class(int id, String name, Teacher teacher, List<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.students = students;
	}

	@Override
	public String toString() {
		return "Class [id=" + id + ", name=" + name + ", teacher=" + teacher + ", students=" + students + "]";
	}

	
	
	
	
	
	
}
