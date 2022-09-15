package com.hb01.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        Student student1 = session.get(Student.class, 1001); // We can fetch our records with their id like this
        Student student2 = session.get(Student.class, 1002);
        Student student3 = session.get(Student.class, 1003);

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);

        System.out.println("-------------------------------------------------------------------------------------------");

        // SQL Query Example
        String sqlQuery1 = "SELECT * FROM tbl01_student";
        // 1st way
        List<Object[]> resultList = session.createSQLQuery(sqlQuery1).getResultList();
        for (Object[] students:resultList) {
            System.out.println(Arrays.toString(students));
        }
        System.out.println("-------------------------------------------------------------------------------------------");
        // 2nd way
        Query query = session.createSQLQuery(sqlQuery1);
        List<Object[]> resultList2 = query.getResultList();
        for (Object[] students:resultList2) {
            System.out.println(Arrays.toString(students));
        }

        System.out.println("-------------------------------------------------------------------------------------------");

        // HQL Query Example (In HQL queries we must use variable and class names for fetch)
        String hqlQuery1="FROM Student";
		List<Student> resultList3=session.createQuery(hqlQuery1,Student.class).getResultList();
        for (Student student : resultList3) {
            System.out.println(student);
        }
    }
}
