package com.dg.Student.Marks.Portal.Repositories;

import com.dg.Student.Marks.Portal.Entity.StudentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentDetails, Integer> {
}
