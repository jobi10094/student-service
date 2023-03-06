package com.jobi.studentservice.service;
import com.jobi.studentservice.dto.StudentDto;
import com.jobi.studentservice.model.Students;
import com.jobi.studentservice.repo.StudentRepo;
import com.jobi.studentservice.dto.StudentDto;
import com.jobi.studentservice.model.Students;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class StudentService {
    final Logger log = LoggerFactory.getLogger(StudentService.class);
    @Autowired
    private StudentRepo studentRepo;
    public Students saveStudent(StudentDto studentDto){
        Students students= new Students();
        students.setEmail(studentDto.getEmail());
        students.setFirstName(studentDto.getFirstName());
        students.setLastName(studentDto.getLastName());
        students.setCourse(studentDto.getCourse());

        return studentRepo.save(students);
//business login
    }

    public List<Students> getAllStudents() {

        return studentRepo.findAll();
    }

    public Optional<Students> getStudentById(Long studentId) {
        return studentRepo.findById(studentId);
    }

    public Students updateStudent(Long studentId, StudentDto studentDto) {
        // get the student with the help of Id.
        Optional<Students> existingStudentOptional=studentRepo.findById(studentId);
        if (existingStudentOptional.isPresent()){
            Students existingStudent= existingStudentOptional.get();
            existingStudent.setLastName(studentDto.getLastName());
            existingStudent.setEmail(studentDto.getEmail());
            existingStudent.setFirstName(studentDto.getFirstName());
            return studentRepo.save(existingStudent);

        }else{

            log.info("Student is not found in database with Id: ", + studentId);
            return null;
        }


    }

    public String deleteStudent(Long studentId) {
        Optional<Students> studentExist = studentRepo.findById(studentId);
        if (studentExist.isPresent()) {
            studentRepo.deleteById(studentId);
            return "User deleted Successfully!";
        }else{
            return " User not found in database";

        }
    }

    public Students findStudentByEmail(String email) {
        return studentRepo.findByEmail(email).get();
    }



}

