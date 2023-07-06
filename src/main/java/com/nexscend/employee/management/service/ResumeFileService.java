package com.nexscend.employee.management.service;

import org.springframework.stereotype.Service;

import com.nexscend.employee.management.model.ResumeFileModel;

@Service
public interface ResumeFileService {

	void saveCandidate(ResumeFileModel file);
	
}