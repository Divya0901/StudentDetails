package com.dg.Student.Marks.Portal.Controllers;

import com.dg.Student.Marks.Portal.Entity.MarksDetails;
import com.dg.Student.Marks.Portal.Exceptions.NotFoundException;
import com.dg.Student.Marks.Portal.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/addMarks/{studentId}")
    public ResponseEntity<String> addMarks(@PathVariable int studentId,
                                           @RequestBody MarksDetails marksDetails) {
        try {
            adminService.addOrUpdateMarks(studentId, marksDetails);
            return ResponseEntity.ok("Marks added successfully");
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/updateMarks/{studentId}")
    public ResponseEntity<String> updateMarks(@PathVariable int studentId,
                                              @RequestBody MarksDetails marksDetails) {
        try {
            adminService.addOrUpdateMarks(studentId, marksDetails);
            return ResponseEntity.ok("Marks updated successfully");
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
