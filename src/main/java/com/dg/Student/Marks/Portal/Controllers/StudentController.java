package com.dg.Student.Marks.Portal.Controllers;

import com.dg.Student.Marks.Portal.Entity.MarksDetails;
import com.dg.Student.Marks.Portal.Entity.StudentDetails;
import com.dg.Student.Marks.Portal.Exceptions.NotFoundException;
import com.dg.Student.Marks.Portal.Repositories.StudentRepository;
import com.dg.Student.Marks.Portal.Services.AdminService;
import com.dg.Student.Marks.Portal.Services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    StudentRepository studentUserRepository;

    @Autowired
    AdminService adminService;

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @PostMapping("/addStudentsDetails")
    public ResponseEntity<Object> addStudentDetails(@RequestBody StudentDetails studentDetails) {

        try {
            if (studentDetails == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            else {
                    StudentDetails studentDetails1 = studentService.addStudent(studentDetails);
                logger.info("Added studentDetails with ID: {}", studentDetails.getStudentId());
                return ResponseEntity.status(HttpStatus.CREATED).body(studentDetails1);
            }
        } catch (Exception e) {
            logger.error("Error adding studentDetails", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<StudentDetails>> getAllStudentsList() {
        try {
            List<StudentDetails> allStudents = studentService.getAllStudentsList();
            logger.info("Retrieved {} students", allStudents.size());
            return ResponseEntity.ok(allStudents);
        } catch (Exception e) {
            logger.error("Error retrieving students", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/updateStudentDetails/{id}")
    public ResponseEntity<StudentDetails> updateStudentDetails(@PathVariable int id, @RequestBody StudentDetails studentDetails) {
        try {
            if (studentDetails == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            else {
                StudentDetails studentDetails1 = studentService.updateStudentDetails(id, studentDetails);
                logger.info("Added studentDetails with ID: {}", studentDetails.getStudentId());
                return ResponseEntity.status(HttpStatus.CREATED).body(studentDetails1);
            }
        } catch (Exception e) {
            logger.error("Error adding studentDetails", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @DeleteMapping("/deleteField/{id}")
    public ResponseEntity<StudentDetails> deleteStudentAttributes(@PathVariable int id,
                                                                     @RequestParam(name = "attributes") List<String> attributesToDelete) {
        try {
            StudentDetails updatedStudent = studentService.deleteStudentAttributes(id, attributesToDelete);
            return ResponseEntity.ok(updatedStudent);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        try {
            studentService.deleteStudent(id);
            return ResponseEntity.ok("Student deleted successfully");
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getResults/{studentId}")
    public ResponseEntity<Object> showResult(@PathVariable int studentId) {
        try {
            MarksDetails marksDetails = adminService.calculateResult(studentId);
            return ResponseEntity.ok("Results fetched successfully");
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
