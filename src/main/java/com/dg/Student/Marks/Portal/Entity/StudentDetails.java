package com.dg.Student.Marks.Portal.Entity;

import jakarta.persistence.*;

@Entity
//@Table(name = "student_details", schema = "student_marks")
public class StudentDetails {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "student_id")
    private int studentId;
//    @Column(name = "student_first_name")
    private String firstName;
//    @Column(name = "student_last_name")
    private String lastName;
//    @Column(name = "student_email")
    private String emailId;
//    @Column(name = "student_address")
    private String address;
//    @Column(name = "student_contact")
    private String phoneNumber;
//    @Column(name = "student_course")
    private String courses;

    public StudentDetails() {
    }

    public StudentDetails(int studentId, String firstName, String lastName, String emailId, String address, String phoneNumber, String courses) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.courses = courses;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }
}
