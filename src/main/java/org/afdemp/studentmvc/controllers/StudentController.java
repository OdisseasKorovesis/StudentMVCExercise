/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.studentmvc.controllers;

import java.util.List;
import javax.validation.Valid;
import org.afdemp.studentmvc.entities.Student;
import org.afdemp.studentmvc.services.IStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Odisseas KD
 */
@Controller
@RequestMapping("/")
public class StudentController {

    @Autowired
    IStudent studentService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String listAllStudents(ModelMap view) {
        List<Student> students = studentService.findAllStudents();
        view.addAttribute("students", students);
        return ("studentlist");
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String newStudent(ModelMap view) {
        Student student = new Student();
        view.addAttribute("student", student);
        return "newstudent";
    }

    @RequestMapping(value = {"/newstudent"}, method = RequestMethod.POST)
    public String saveStudent(ModelMap view, Student student) {
        studentService.saveStudent(student);
        view.addAttribute("message", new String("Student " + student.getFirstName() + " " + student.getLastName() + " has been registered succesfully!"));
        return "newstudent";
    }

    @RequestMapping(value = {"/edit-{id}-student"}, method = RequestMethod.GET)
    public String editStudent(@PathVariable int id, ModelMap view) {
        Student student = studentService.findById(id);
        view.addAttribute("student", student);
        view.addAttribute("edit", true);
        return "newstudent";
    }

    @RequestMapping(value = {"/edit-{id}-student"}, method = RequestMethod.POST)
    public String updateStudent(@Valid Student student, ModelMap view) {

        studentService.updateStudent(student);

        view.addAttribute("message", "Student " + student.getFirstName() + " " + student.getLastName() + " updated successfully");
        return "newstudent";
    }
    
    @RequestMapping(value = { "/delete-{id}-student" }, method = RequestMethod.GET)
	public String deleteStudent(@PathVariable int id) {
		studentService.deleteStudentById(id);
		return "redirect:/list";
	}
    
    

}
