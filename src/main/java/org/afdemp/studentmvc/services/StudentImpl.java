/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.studentmvc.services;

import java.util.List;
import org.afdemp.studentmvc.dao.StudentDaoImpl;
import org.afdemp.studentmvc.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Odisseas KD
 */
@Service("studentService")
@Transactional
public class StudentImpl implements IStudent{

    @Autowired
    StudentDaoImpl dao;
    
    @Override
    public List<Student> findAllStudents() {
        List<Student> students = dao.findAllStudents();
        return students;
    }

    @Override
    public void saveStudent(Student student) {
        dao.saveStudent(student);
        }

    @Override
    public Student findById(int id) {
        return dao.findById(id);
        }
    @Override
    public void updateStudent(Student student) {
                System.out.println("**********************student: " + student);
		Student entity = dao.findById(student.getId());
		if(entity!=null){
			entity.setFirstName(student.getFirstName());
			entity.setLastName(student.getLastName());
                        entity.setDateOfBirth(student.getDateOfBirth());
                        entity.setTuitionFees(student.getTuitionFees());
		}
	}
    
    @Override
    public void deleteStudentById(int id) {
		dao.deleteStudentById(id);
	}
}
