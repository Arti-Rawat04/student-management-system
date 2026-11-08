
package com.student.student_mangement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.student_mangement.entity.Student;
import com.student.student_mangement.repository.StudentRepository;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "index";
    }

    @GetMapping("/students/new")
    public String newStudent(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    @PostMapping("/students/save")
    public String saveStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "redirect:/";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return "redirect:/";
    }
    @GetMapping("/students/edit/{id}")
public String editStudent(@PathVariable Long id, Model model) {

    Student student = studentRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid student ID"));

    model.addAttribute("student", student);

    return "edit-student";
}

@PostMapping("/students/update")
public String updateStudent(@ModelAttribute Student student) {

    studentRepository.save(student);

    return "redirect:/";
}
}
