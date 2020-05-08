/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.studentmvc.dao;

import java.util.List;
import org.afdemp.studentmvc.entities.Student;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Odisseas KD
 */
@Repository("studentDao")
public class StudentDaoImpl extends AbstractDao<Integer, Student> implements IStudentDao {

    @Override
    public List<Student> findAllStudents() {
        Criteria criteria = createEntityCriteria();
        return (List<Student>) criteria.list();
    }

    @Override
    public void saveStudent(Student student) {
        persist(student);
    }

    @Override
    public Student findById(int id) {
        return getByKey(id);
    }

    @Override
    public void deleteStudentById(int id) {
        Query query = getSession().createSQLQuery("delete from students where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

}
