package com.dg.Student.Marks.Portal.Repositories;

import com.dg.Student.Marks.Portal.Entity.MarksDetails;
import com.dg.Student.Marks.Portal.Entity.StudentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MarksRepository extends JpaRepository<MarksDetails, Integer> {

//    @Query("SELECT student.student_id, student.name, marks.marks\n" +
//            "FROM student\n" +
//            "JOIN marks ON student.student_id = marks.student_id\n" +
//            "WHERE student.student_id = :studentId;")
//    MarksDetails findByStudentId(@Param("studentId") int studentId);
}
