package com.dg.Student.Marks.Portal.Services;

import com.dg.Student.Marks.Portal.Entity.StudentDetails;
import com.dg.Student.Marks.Portal.Exceptions.NotFoundException;
import com.dg.Student.Marks.Portal.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentUserRepository;

    public StudentDetails addStudent(StudentDetails studentDetails) {
       return studentUserRepository.save(studentDetails);
    }

    public List<StudentDetails> getAllStudentsList() {
            return studentUserRepository.findAll();
    }

    public StudentDetails updateStudentDetails(int studentId, StudentDetails studentDetails) {
          StudentDetails existingStudent = studentUserRepository.findById(studentId)
                .orElseThrow(() -> new NotFoundException("Student not found"));

        existingStudent.setFirstName(studentDetails.getFirstName());
        existingStudent.setLastName(studentDetails.getLastName());
        existingStudent.setEmailId(studentDetails.getEmailId());
        existingStudent.setAddress(studentDetails.getAddress());
        existingStudent.setPhoneNumber(studentDetails.getPhoneNumber());
        existingStudent.setCourses(studentDetails.getCourses());
        return studentUserRepository.save(existingStudent);
    }

    public StudentDetails deleteStudentAttributes(int studentId, List<String> attributesToDelete) {
        StudentDetails existingStudent = studentUserRepository.findById(studentId)
                .orElseThrow(() -> new NotFoundException("Student not found"));

        for (String attribute : attributesToDelete) {
            switch (attribute) {
                case "firstName":
                    existingStudent.setFirstName(null);
                    break;
                case "lastName":
                    existingStudent.setLastName(null);
                    break;
                case "emailId":
                    existingStudent.setEmailId(null);
                    break;
                case "address":
                    existingStudent.setAddress(null);
                    break;
                case "phoneNumber":
                    existingStudent.setPhoneNumber(null);
                    break;
                case "courses":
                    existingStudent.setCourses(null);
                    break;
            }
        }

        StudentDetails savedStudent = studentUserRepository.save(existingStudent);
        return savedStudent;
    }

    public void deleteStudent(int studentId) {
        StudentDetails existingStudent = studentUserRepository.findById(studentId)
                .orElseThrow(() -> new NotFoundException("Student not found"));

        studentUserRepository.delete(existingStudent);
    }

}


