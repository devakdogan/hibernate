package com.hb01.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {

    public static void main(String[] args) {

        Student student1 = new Student();
        student1.setId(1001);
        student1.setName("Harry Potter");
        student1.setGrade(100);
        student1.setHouse("Gryffindor");

        Student student2 = new Student();
        student2.setId(1002);
        student2.setName("Draco Malfoy");
        student2.setGrade(85);
        student2.setHouse("Slytherin");

        Student student3 = new Student();
        student3.setId(1003);
        student3.setName("Hermione Granger");
        student3.setGrade(100);
        student3.setHouse("Gryffindor");

        Student student4= new Student();
        student4.setId(1004);
        student4.setName("Ronald Ron Weasley");
        student4.setGrade(100);
        student4.setHouse("Gryffindor");

        Student student5 = new Student();
        student5.setId(1005);
        student5.setName("Morag McDougal");
        student5.setGrade(73);
        student5.setHouse("Ravenclaw");

        Student student6 = new Student();
        student6.setId(1006);
        student6.setName("Gregory Goyle");
        student6.setGrade(50);
        student6.setHouse("Slytherin");

        Student student7 = new Student();
        student7.setId(1007);
        student7.setName("Megan Jones");
        student7.setGrade(77);
        student7.setHouse("Hufflepuff");

        Student student8 = new Student();
        student8.setId(1008);
        student8.setName("Mandy Brocklehurst");
        student8.setGrade(69);
        student8.setHouse("Ravenclaw");

        SessionFactory sf = new Configuration().configure()
                .addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);
        session.save(student5);
        session.save(student6);
        session.save(student7);
        session.save(student8);

        tx.commit();
        session.close();
        sf.close();
    }
}
