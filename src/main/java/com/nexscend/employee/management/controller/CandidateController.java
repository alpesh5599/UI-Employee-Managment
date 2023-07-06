package com.nexscend.employee.management.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nexscend.employee.management.model.CandidateResponse;
import com.nexscend.employee.management.service.CandidateService;

@RestController
@RequestMapping("api/v1/candidate")
@CrossOrigin(origins = "http://localhost:4200")
public class CandidateController {

	Logger logger = LoggerFactory.getLogger(CandidateController.class);

	@Autowired
	CandidateService candidateService;

	@PostMapping(value = "/save/candidate", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<Void> saveCandidateData(@RequestPart("candidate") CandidateResponse candidate,
			@RequestPart(name = "candidateResume", required = true) MultipartFile file) {
		//  Calling the service
		candidateService.saveCandidate(candidate, file);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}

//	@GetMapping("/getAll/candidate")
//	public List<CandidateResponse> getAllCandidateData() {
//		logger.info("Fetching All Candidate Details from Database...");
//		return candidateService.getAllCandidate();
//	}
//
//	@GetMapping("/getCandidate/ById/{id}")
//	public Candidate getCandidateDataById(@PathVariable Integer id) {
//		logger.info("Fetching Specific Candidate By Id...");
//		return candidateService.getCandidateById(id);
//	}
//
//	@PutMapping("/editCandidate/{id}")
//	public Candidate updateCandidateDetails(@RequestBody Candidate candidate, @PathVariable Integer id) {
//		logger.info("updating details of candidate...");
//		return candidateService.editCandidateDetails(candidate, id);
//	}

}