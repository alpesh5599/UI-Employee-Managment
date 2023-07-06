package com.nexscend.employee.management.service;

import org.springframework.web.multipart.MultipartFile;

import com.nexscend.employee.management.model.CandidateResponse;

public interface CandidateService {
	
	void saveCandidate(CandidateResponse candidateRequestModel, MultipartFile file);
	
//	List<CandidateResponse> getAllCandidateDetails();
}
