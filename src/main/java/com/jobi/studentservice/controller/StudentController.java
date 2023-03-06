package com.jobi.studentservice.controller;

import com.jobi.studentservice.dto.StudentDto;
import com.jobi.studentservice.model.Students;
import com.jobi.studentservice.service.StudentService;
import com.jobi.studentservice.model.Students;
import com.jobi.studentservice.service.StudentService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public Students createStudent(@RequestBody StudentDto studentDto) {
        return studentService.saveStudent(studentDto);
    }

    @GetMapping("/students")
    public List<Students> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{studentID}")
    public Students getStudentById(@PathVariable Long studentID) {
        return studentService.getStudentById(studentID).get();
    }

    @PutMapping("/students/{studentId}")
    public Students updateStudentById(@PathVariable Long studentId, @RequestBody StudentDto studentDto) {
        return studentService.updateStudent(studentId, studentDto);
    }

    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable Long studentId) {
        return studentService.deleteStudent(studentId);
    }

    @GetMapping("/students/search")
    public Students getEmailByStudents(@RequestParam(required = false) String email) {
        return studentService.findStudentByEmail(email);
    }

}

