package com.nexscend.employee.management.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.nexscend.employee.management.entity.Candidate;
import com.nexscend.employee.management.entity.ResumeFile;
import com.nexscend.employee.management.model.CandidateResponse;
import com.nexscend.employee.management.repository.CandidateRepository;
import com.nexscend.employee.management.repository.ResumeFileRepository;

@Service
public class CandidateServiceImpl implements CandidateService {

	Logger logger = LoggerFactory.getLogger(CandidateServiceImpl.class);

	@Autowired
	CandidateRepository candidateRepository;

	@Autowired
	CandidateService candidateService;

	@Autowired
	ResumeFileRepository resumeFileRepository;

	@Override
	public void saveCandidate(CandidateResponse candidateRequestModel, MultipartFile file) {

		// For DB Save
		Candidate candidateEntity = new Candidate();

		if (candidateRequestModel == null) {
			logger.error("Requested Model Are Not found...");
		}

		candidateEntity.setApplyingPosition(candidateRequestModel.getApplyingPosition());
		candidateEntity.setCandidateFirstName(candidateRequestModel.getCandidateFirstName());
		candidateEntity.setCandidateLastName(candidateRequestModel.getCandidateLastName());
		candidateEntity.setCandidateEmail(candidateRequestModel.getCandidateEmail());
		candidateEntity.setCandidatePhoneNo(candidateRequestModel.getCandidatePhoneNo());
		candidateEntity.setCandidateSkills(candidateRequestModel.getCandidateSkills());
		candidateEntity.setJoiningAvailability(candidateRequestModel.getJoiningAvailability());

		if (file != null) {

//			try {
////				candidateEntity.setCandidateResume(file.getBytes());
//			} catch (IOException e) {
//				logger.error("File not found in requested Model...");
//			}

		}
		candidateEntity.setComments(candidateRequestModel.getComments());

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {
			ResumeFile resume = new ResumeFile(null, fileName, file.getContentType(), file.getBytes());

			// Save In DB
			resumeFileRepository.save(resume);

		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		//
		// Save DB Object
		candidateRepository.save(candidateEntity);

	}

//	@Override
//	public List<CandidateResponse> getAllCandidateDetails() {
//		
//		return candidateRepository
//	}

//	public List<Candidate> getAllCandidate(){
//		return candidateRepository.findAll();
//	}
//	
//	public Candidate getCandidateById(Integer id) {
//		return candidateRepository.findById(id).get();
//	}
//	
//	public Candidate editCandidateDetails(Candidate candidate, Integer id) {
//		Candidate c=candidateRepository.findById(id).get();
//		
//		c.setApplyingPosition(candidate.getApplyingPosition());
//		c.setCandidateFirstName(candidate.getCandidateFirstName());
//		c.setCandidateLastName(candidate.getCandidateLastName());
//		c.setCandidateEmail(candidate.getCandidateEmail());
//		c.setCandidatePhoneNo(candidate.getCandidatePhoneNo());
//		c.setCandidateSkills(candidate.getCandidateSkills());
//		c.setJoiningAvailability(candidate.getJoiningAvailability());
//		c.setComments(candidate.getComments());
//		
//		return candidateRepository.save(c);
//	}

}