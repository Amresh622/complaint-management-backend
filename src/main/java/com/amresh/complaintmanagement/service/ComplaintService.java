package com.amresh.complaintmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amresh.complaintmanagement.model.Complaint;
import com.amresh.complaintmanagement.repository.ComplaintRepository;

import java.util.List;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    public Complaint createComplaint(Complaint complaint) {
        complaint.setStatus("Pending");
        return complaintRepository.save(complaint);
    }

    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    public List<Complaint> getUserComplaints(Long userId) {
        return complaintRepository.findByUserId(userId);
    }

    public Complaint updateStatus(Long id, String status) {
        Complaint complaint = complaintRepository.findById(id).orElseThrow();
        complaint.setStatus(status);
        return complaintRepository.save(complaint);
    }
}

