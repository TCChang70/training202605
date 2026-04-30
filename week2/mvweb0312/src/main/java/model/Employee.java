package model;

public class Employee {
   int employeeNumber;
   String firstName;
   String lastName;
   String extension;
   String officeCode;
   String email;
   String jobTitle;
   int reportsTo;
   public Employee() {
	   
   }
   public Employee(int employeeNumber, String firstName, String lastName, String extension, String email ,
		String officeCode, String jobTitle, int repostsTo) {	
	this.employeeNumber = employeeNumber;
	this.firstName = firstName;
	this.lastName = lastName;
	this.extension = extension;
	this.officeCode = officeCode;
	this.email = email;
	this.jobTitle = jobTitle;
	this.reportsTo = repostsTo;
   }
   public int getEmployeeNumber() {
	return employeeNumber;
   }
   public void setEmployeeNumber(int employeeNumber) {
	this.employeeNumber = employeeNumber;
   }
   public String getFirstName() {
	return firstName;
   }
   public void setFirstName(String firstName) {
	this.firstName = firstName;
   }
   public String getLastName() {
	return lastName;
   }
   public void setLastName(String lastName) {
	this.lastName = lastName;
   }
   public String getExtension() {
	return extension;
   }
   public void setExtension(String extension) {
	this.extension = extension;
   }
   public String getOfficeCode() {
	return officeCode;
   }
   public void setOfficeCode(String officeCode) {
	this.officeCode = officeCode;
   }
   public String getEmail() {
	return email;
   }
   public void setEmail(String email) {
	this.email = email;
   }
   public String getJobTitle() {
	return jobTitle;
   }
   public void setJobTitle(String jobTitle) {
	this.jobTitle = jobTitle;
   }
   public int getReportsTo() {
	return reportsTo;
   }
   public void setReportsTo(int repostsTo) {
	this.reportsTo = repostsTo;
   }
   @Override
   public String toString() {
	return "Employee [employeeNumber=" + employeeNumber + ", firstName=" + firstName + ", lastName=" + lastName
			+ ", extension=" + extension + ", officeCode=" + officeCode + ", email=" + email + ", jobTitle=" + jobTitle
			+ ", reportsTo=" + reportsTo + "]";
   }
   
}
