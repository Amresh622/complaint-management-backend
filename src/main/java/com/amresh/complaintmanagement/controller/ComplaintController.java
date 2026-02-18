package com.amresh.complaintmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.amresh.complaintmanagement.model.Complaint;
import com.amresh.complaintmanagement.service.ComplaintService;

import java.util.List;

@RestController
@RequestMapping("/api/complaints")
@CrossOrigin("*")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @PostMapping
    public Complaint create(@RequestBody Complaint complaint) {
        return complaintService.createComplaint(complaint);
    }

    @GetMapping
    public List<Complaint> getAll() {
        return complaintService.getAllComplaints();
    }

    @GetMapping("/user/{userId}")
    public List<Complaint> getUserComplaints(@PathVariable Long userId) {
        return complaintService.getUserComplaints(userId);
    }

    @PutMapping("/{id}")
    public Complaint updateStatus(@PathVariable Long id,
                                  @RequestParam String status) {
        return complaintService.updateStatus(id, status);
    }
}

