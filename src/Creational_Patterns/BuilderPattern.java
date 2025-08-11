package Creational_Patterns;

public class BuilderPattern {
	
	public static class Student {
		private String name; 
		private int age; 
		private String className;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getClassName() {
			return className;
		}
		public void setClassName(String className) {
			this.className = className;
		}
		@Override
		public String toString() {
			return "Student [name=" + name + ", age=" + age + ", className=" + className + "]";
		}
		
		
	}
	
	public static interface Builder<T> {
		Builder<T> reset(); 
		Builder<T> setName(String name);
		Builder<T> setAge(int age); 		
		Builder<T> setClassName(String className);
		T get();
	}
	
	public static class StudentBuilder implements Builder<Student> {
		private Student student; 
		
		public StudentBuilder() { 
			this.reset();
		}
		
		@Override
		public Builder<Student> reset() {
			this.student = new Student();
			return this;
		}
		
		@Override
		public Builder<Student> setAge(int age) {
			this.student.setAge(age);
			return this;
		}
		
		@Override
		public Builder<Student> setClassName(String className) {
			this.student.setClassName(className);
			return this;
		}
		@Override
		public Builder<Student> setName(String name) {
			this.student.setName(name);
			return this;
		}
		@Override
		public Student get() {
			return this.student;
		}
	}
	
	
	public static void main(String[] args) {
		Student studentBuilder = new StudentBuilder()
				.setAge(20)
				.setClassName("21DTHB1")
				.get();
		System.out.println(studentBuilder);
	}

}
