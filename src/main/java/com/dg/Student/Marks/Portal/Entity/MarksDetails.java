package com.dg.Student.Marks.Portal.Entity;

import jakarta.persistence.*;

@Entity
public class MarksDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentDetails studentDetails;

    private String course;
    private double mathsMarks;
    private double chemMarks;
    private double phyMarks;
    private double totalMarks;
    private double percentage;
    private String result;

    public MarksDetails() {
    }

    public MarksDetails(int id, StudentDetails studentDetails, String course, double mathsMarks, double chemMarks, double phyMarks, double totalMarks, double percentage, String result) {
        this.id = id;
        this.studentDetails = studentDetails;
        this.course = course;
        this.mathsMarks = mathsMarks;
        this.chemMarks = chemMarks;
        this.phyMarks = phyMarks;
        this.totalMarks = totalMarks;
        this.percentage = percentage;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StudentDetails getStudentDetails() {
        return studentDetails;
    }

    public void setStudentDetails(StudentDetails studentDetails) {
        this.studentDetails = studentDetails;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getMathsMarks() {
        return mathsMarks;
    }

    public void setMathsMarks(double mathsMarks) {
        this.mathsMarks = mathsMarks;
    }

    public double getChemMarks() {
        return chemMarks;
    }

    public void setChemMarks(double chemMarks) {
        this.chemMarks = chemMarks;
    }

    public double getPhyMarks() {
        return phyMarks;
    }

    public void setPhyMarks(double phyMarks) {
        this.phyMarks = phyMarks;
    }

    public double getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(double totalMarks) {
        this.totalMarks = totalMarks;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
