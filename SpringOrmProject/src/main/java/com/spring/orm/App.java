package com.spring.orm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entites.Student;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao stDao = context.getBean("studentDao", StudentDao.class);

		/*
		 * Student st = new Student(2342,"Rakesh Kumar","Delhi"); int
		 * r=stDao.insert(st); System.out.println("inserted :- "+r);
		 */

		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {

			System.out.println("Press 1 for add new student");
			System.out.println("Press 2 for display all students");
			System.out.println("Press 3 for get details for single student");
			System.out.println("Press 4 for delete student");
			System.out.println("Press 5 for update student");
			System.out.println("Press 6 for exit");

			try {
				int input = sc.nextInt();
				switch (input) {
				case 1:
					// add new student
					// taking input from users

					System.out.println("Enter student id :- ");
					int id = sc.nextInt();

					System.out.println("Enter Student name :- ");
					String name = sc.next();

					System.out.println("Enter Student city name :- ");
					String city = sc.next();

					// creating student object and setting values
					Student st = new Student();
					st.setId(id);
					st.setName(name);
					st.setCity(city);

					// savig student object to database by calling insert studentDao
					int r = stDao.insert(st);
					System.out.println(r + " student added..");
					System.out.println("***************************************");
					System.out.println();

					break;
				case 2:
					// display all students
					System.out.println("*****************************************");
					List<Student> st1 = stDao.getAllStudents();
					for (Student x : st1) {
						System.out.println(x.getId() + "  " + x.getName() + "  " + x.getCity());
					}
					System.out.println("*****************************************");
					break;
				case 3:
					// get details for single student
					System.out.println("Enter student id :- ");
					int sId = sc.nextInt();
					Student student = stDao.getStudent(sId);
					System.out.println(student.getId() + " " + student.getName() + " " + student.getCity());
					System.out.println("***************************************");

					break;
				case 4:
					// delete student

					System.out.println("Enter student id :- ");
					int sid = sc.nextInt();
					stDao.deleteStudent(sid);
					System.out.println("Student deleted....");
					System.out.println("**********************************************");

					break;
				case 5:
					// update student

					break;
				case 6:
					// exit
					flag = false;
					break;
				}

			} catch (Exception e) {
				System.out.println("Invalid input try with another one!!");
				System.out.println(e.getMessage());
				flag = false;
			}
		}
		System.out.println("The End");
	}
}
