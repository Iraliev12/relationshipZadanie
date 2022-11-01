package org.example.dao;

import org.example.configuration.Config;
import org.example.model.School;
import org.example.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class SchoolDao {
    private final SessionFactory sessionFactory = Config.creatSessionFactory();

    public void saveSchool(SchoolDao school) {
        Session session = Config.creatSessionFactory().openSession();
        session.beginTransaction();
        session.persist(school);
        session.getTransaction().commit();
        session.close();
    }
    public void updateSchool(Long id, School school) {
        Session session = Config.creatSessionFactory().openSession();
        session.beginTransaction();
        School school1 = session.find(School.class, id);
        school1.setSchoolName(school.getSchoolName());
        school1.setSchoolnumber(school.getSchoolnumber());
        session.getTransaction();
        session.close();
    }
    public School getSchoolById(Long id) {
        Session session = Config.creatSessionFactory().openSession();
        session.beginTransaction();
        School school = session.get(School.class,id);
        session.getTransaction().commit();
        session.close();
        return null;
    }
    public List<School> getSchoolByStundentId(Long id) {
        Session session = Config.creatSessionFactory().openSession();
        session.beginTransaction();
        Student student = session.find(Student.class,id);
        session.getTransaction().commit();
        session.close();
        return student.getSchools();
    }
    public void DeleteInstructorById(Long id) {
        Session session=Config.creatSessionFactory().openSession();
        session.beginTransaction();
        School school = session.find(School.class,id);
        session.delete(school);
        session.getTransaction().commit();
        session.close();
    }
    public void assignInstructorToCourse(Long school_id, Long student_id){
        Session session = Config.creatSessionFactory().openSession();
        session.beginTransaction();
        School school = session.find(School.class,school_id);
        Student student = session.get(Student.class, student_id);
        school.getSchools().add(student);
        session.merge(school);
        session.getTransaction().commit();
        session.close();
    }
}





