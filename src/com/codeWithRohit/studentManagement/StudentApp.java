package com.codeWithRohit.studentManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentApp {
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("Press 1 to Ddd Student");
			System.out.println("Press 2 to Delete Student");
			System.out.println("Press 3 to Display Student");
			System.out.println("Press 4 to Update student details");
			System.out.println("Press 5 to Exit Application");
			int choice=Integer.parseInt(br.readLine());
		
		if(choice==1) {
			//Enter studet record into data base
			System.out.println("Enter Student Name: ");
			String name=br.readLine();
			
			System.out.println("Enter Stuent Phone Number");
			String phone=br.readLine();
			
			System.out.println("Enter Stuent City");
			String city=br.readLine();
			
			//Create student class object to intialize student data
			Student student=new Student(name, phone, city);
			
			boolean result=StudentDao.insertStudentIntoDB(student);
			
			if(result) {
				System.out.println("Student has been successfully added.......");
			}
			else {
				System.out.println("Something went wrong...Try again");
			}
			System.out.println(student);
			
			
		}
		else if(choice==2) {
			//Delete student record using Id
			System.out.println("Enter student Id to delete record.....");
			int studentId=Integer.parseInt(br.readLine());
			boolean response=StudentDao.deletStudent(studentId);
			if(response) {
				System.out.println("Student record of Id "+ studentId +" has been deleted successfully.....");
			}
			else {
				System.out.println("Something went wrong .... Try again to delete record of this Id "+ studentId);
			}
			
		}
		else if(choice==3) {
			//Display all students
			StudentDao.displayAllStudents();
		}
		else if(choice==4) {
			//Update student details
			Student student=new Student();
			
			System.out.println("Enter student Id : ");
			int studentId=Integer.parseInt(br.readLine());
			student.setStudentId(studentId);
			
			System.out.println("Enter new Name :");
			String newName=br.readLine();
			student.setStuentName(newName);
			
			System.out.println("Enter new City :");
			String newCity=br.readLine();
			student.setStudentCity(newCity);
					
			StudentDao.updateStudent(student);
			
		}
		else if(choice==5) {
			
			System.out.println("Successfully Exit......See U Again........Thanks !! ");
			System.exit(0);
		}
		}
	}

}
