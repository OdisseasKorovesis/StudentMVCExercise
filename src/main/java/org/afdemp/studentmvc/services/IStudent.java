/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.studentmvc.services;

import java.util.List;
import org.afdemp.studentmvc.entities.Student;

/**
 *
 * @author Odisseas KD
 */
public interface IStudent {
   public List<Student> findAllStudents();
   public Student findById(int id);
   public void saveStudent(Student student);
   public void updateStudent(Student student);
   public void deleteStudentById(int id);
   
   
}
