package com.spring.orm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entites.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao stDao = context.getBean("studentDao",StudentDao.class);
        Student st = new Student(2342,"Rakesh Kumar","Delhi");
        int r=stDao.insert(st);
        System.out.println("inserted :- "+r);
    }
}
