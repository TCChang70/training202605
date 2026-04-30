
public class Student {
   String id;
   String name;
   double grade;
   int age;
   public Student(String id, String name, double grade, int age) {	
	this.id = id;
	this.name = name;
	this.grade = grade;
	this.age = age;
   }
   public Student() {
	
   }
   public String getId() {
	return id;
   }
   public void setId(String id) {
	this.id = id;
   }
   public String getName() {
	return name;
   }
   public void setName(String name) {
	this.name = name;
   }
   public double getGrade() {
	return grade;
   }
   public void setGrade(double grade) {
	this.grade = grade;
   }
   public int getAge() {
	return age;
   }
   public void setAge(int age) {
	this.age = age;
   }
   @Override
   public String toString() {
	return "Student [id=" + id + ", name=" + name + ", grade=" + grade + ", age=" + age + "]";
   }
   
}
