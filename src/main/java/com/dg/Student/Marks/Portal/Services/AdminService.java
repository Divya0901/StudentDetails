package com.dg.Student.Marks.Portal.Services;

import com.dg.Student.Marks.Portal.Entity.MarksDetails;
import com.dg.Student.Marks.Portal.Entity.StudentDetails;
import com.dg.Student.Marks.Portal.Exceptions.NotFoundException;
import com.dg.Student.Marks.Portal.Repositories.MarksRepository;
import com.dg.Student.Marks.Portal.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AdminService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    MarksRepository marksRepository;

    public void addOrUpdateMarks(int studentId, MarksDetails marksDetails) {

        StudentDetails existingStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new NotFoundException("Student not found"));

        MarksDetails marksDetails1 = new MarksDetails();
        marksDetails1.setMathsMarks(marksDetails.getMathsMarks());
        marksDetails1.setPhyMarks(marksDetails.getPhyMarks());
        marksDetails1.setChemMarks(marksDetails.getChemMarks());

        double totalMarks = (marksDetails.getMathsMarks() + marksDetails.getPhyMarks() + marksDetails.getChemMarks());
        marksDetails1.setTotalMarks(totalMarks);

        double percentage = ((totalMarks / 300) * 100);
        marksDetails1.setPercentage(percentage);

        marksDetails1.setStudentDetails(existingStudent);
        marksRepository.save(marksDetails1);
    }

    public MarksDetails calculateResult(int studentId) {

//        StudentDetails existingStudent = studentRepository.findById(studentId)
//                .orElseThrow(() -> new NotFoundException("Student not found"));
//
//        MarksDetails marksDetails = marksRepository.findByStudentId(existingStudent.getStudentId());
//
//        if (marksDetails == null) {
//            throw new NotFoundException("Marks not found for the student");
//        }
//
//        double totalMarks = marksDetails.getMathsMarks() + marksDetails.getPhyMarks() + marksDetails.getChemMarks();
//        marksDetails.setTotalMarks(totalMarks);
//
//        double percentage = (totalMarks / 300) * 100;
//        marksDetails.setPercentage(percentage);
//
//        if(percentage >= 40) {
//            marksDetails.setResult("Pass");
//            return marksDetails;
//        }
//        else
//        {
//            marksDetails.setResult("Fail");
//            return marksDetails;
//        }
        MarksDetails marksDetails = new MarksDetails();
        return marksDetails;
    }
}
